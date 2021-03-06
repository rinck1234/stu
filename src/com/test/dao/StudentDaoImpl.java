package com.test.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.test.domain.Student;
import com.test.utils.JDBCUtils;
import com.test.utils.TextUtils;

public class StudentDaoImpl implements StudentDao{
/**
	 * 查询所有学生
 * @throws SQLException 
 * @throws PropertyVetoException 
	 */
	public List<Student> findAll() throws SQLException, PropertyVetoException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		System.out.println(list);
		return list;
	}


	public void insert(Student student) throws SQLException, PropertyVetoException {
	// TODO Auto-generated method stub
	QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
	
	runner.update("insert into stu values(null,?,?,?,?,?,?)",
			student.getName(),
			student.getSex(),
			student.getPhone(),
			student.getBirthday(),
			student.getHobby(),
			student.getInfo()
			);
	}


	public void delete(int id) throws SQLException, PropertyVetoException {
		// TODO Auto-generated method stub
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		
		runner.update("delete from stu where id=?",id);
		
	}
	
	public void update(Student student) throws SQLException, PropertyVetoException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		
		runner.update("UPDATE stu SET name=? , sex=? , phone=? , birthday=? , hobby=? , info=? WHERE id=?",
				student.getName(),
				student.getSex(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getId());
	}


	public Student findStuById(int id) throws SQLException, PropertyVetoException {
		// TODO Auto-generated method stub

		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "SELECT * FROM stu WHERE id=?";
		Student student = runner.query(sql,new BeanHandler<Student>(Student.class),id);
		return student;
	}


	public List<Student> search(String name,String sex) throws SQLException, PropertyVetoException {
		// TODO Auto-generated method stub
		String sql="select * from stu where 1=1";
		List<String> list = new ArrayList<String>();
		
		if(!TextUtils.isEmpty(name)) {
			sql = sql + " and name like ?";
			list.add("%"+name+"%");
		}
		if(!TextUtils.isEmpty(sex)) {
			sql = sql + " and sex=?";
			list.add(sex);
		}
		
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
		
	}


	public List<Student> findPage(int currentpage, int listperpage) throws SQLException, PropertyVetoException {
		// TODO Auto-generated method stub
		String sql = "select * from stu limit ? offset ?";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Student>(Student.class),listperpage,(currentpage-1)*listperpage);
		
	}


	public int findCount() throws PropertyVetoException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select count(*) from stu";
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		Long result = (Long)runner.query(sql, new ScalarHandler());
		return result.intValue();
	}
}
