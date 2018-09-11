package com.test.dao;
/**
 * 针对学生表的数据访问
 */
import com.test.domain.Student;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {

	/**
	 * 查询所有
	 * @return
	 * @throws SQLException 
	 * @throws PropertyVetoException 
	 */
	List<Student> findAll() throws SQLException, PropertyVetoException;
	//添加到数据库的学生对象
	void insert(Student student) throws SQLException, PropertyVetoException;
	
	//根据ID删除数据库的学生对象
	void delete(int id) throws SQLException, PropertyVetoException;
}
