package com.test.dao;
/**
 * 针对学生表的数据访问
 */
import com.test.domain.Student;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

	//一次查询指定条数
	List<Student> findPage(int currentpage, int listperpage)throws SQLException, PropertyVetoException;
	
	//一次查询所有
	List<Student> findAll() throws SQLException, PropertyVetoException;
	
	//添加到数据库的学生对象
	void insert(Student student) throws SQLException, PropertyVetoException;
	
	//根据ID删除数据库的学生对象
	void delete(int id) throws SQLException, PropertyVetoException;
	
	//根据ID修改数据库的学生对象
	void update(Student student) throws SQLException, PropertyVetoException;
	
	Student findStuById(int id) throws SQLException, PropertyVetoException;
	
	List<Student> search(String name,String sex) throws SQLException, PropertyVetoException;

	int findCount() throws PropertyVetoException, SQLException;
}
