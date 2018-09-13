package com.test.StudentService;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

import com.test.dao.StudentDao;
import com.test.dao.StudentDaoImpl;
import com.test.domain.BeanPage;
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
	
	public Student findStuById(int id) throws SQLException{
		StudentDao dao = new StudentDaoImpl();
		try {
			return dao.findStuById(id);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void update(Student student) throws SQLException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		try {
			dao.update(student);
		}catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
	}

	public List<Student> search(String name, String sex) throws SQLException, PropertyVetoException {
		// TODO Auto-generated method stub
		StudentDao dao = new StudentDaoImpl();
		List<Student> list = dao.search(name,sex);
		return list;
	}

	public BeanPage findStudentByPage(int currentpage, int listperpage) throws PropertyVetoException, SQLException {
		// TODO Auto-generated method stub
		BeanPage<Student> beanpage = new BeanPage<Student>();
		StudentDao dao = new StudentDaoImpl();
		
		int total_list = dao.findCount();
		beanpage.setTotalList(total_list);
		beanpage.setCurrentpage(currentpage);
		beanpage.setListperpage(listperpage);
		
		List<Student> stu = dao.findPage(currentpage, listperpage);
		beanpage.setList(stu);
		
		beanpage.setTotalpage(total_list % listperpage == 0 ? total_list/listperpage : (total_list/listperpage+1));
		return beanpage;
	}

}
