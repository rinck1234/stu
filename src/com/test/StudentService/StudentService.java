package com.test.StudentService;

import java.sql.SQLException;
import java.util.List;

import com.test.domain.Student;

public interface StudentService {

	List<Student> findAll() throws SQLException;
	
	void insert(Student student) throws SQLException;
}