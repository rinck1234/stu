package com.test.servlet;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.StudentService.StudentService;
import com.test.StudentService.StudentServiceImpl;
import com.test.domain.Student;

public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentService service = new StudentServiceImpl();
		try {
			//查询出所有学生
			List<Student> list = service.findAll();
			
			//把数据存入作用域
			request.setAttribute("list", list);
			
			//跳转
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
