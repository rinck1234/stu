package com.test.StudentService;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;
import com.test.domain.Student;

public class StudentServiceImpl implements StudentService {

	public List<Student> findAll() throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		try {
			return dao.findAll();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Student student) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		try {
			dao.insert(student);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		try {
			dao.delete(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
