package com.test.dao;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.test.domain.Student;
import com.test.utils.JDBCUtils;

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
}
