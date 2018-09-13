package com.test.StudentService;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

import com.test.domain.BeanPage;
import com.test.domain.Student;

public interface StudentService {

	List<Student> findAll() throws SQLException;
	
	void insert(Student student) throws SQLException;
	
	void delete(int id)throws SQLException;
	
	Student findStuById(int id) throws SQLException;
	
	void update(Student student) throws SQLException;
	
	List<Student> search(String name,String sex) throws SQLException, PropertyVetoException;

	BeanPage findStudentByPage(int currentpage, int listperpage) throws PropertyVetoException, SQLException;
}
