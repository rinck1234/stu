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

/**
 * Servlet implementation class StudentSearchServlet
 */
public class StudentSearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("search_name");
		String sex = request.getParameter("search_sex");
		System.out.println(name+sex);
		StudentService service = new StudentServiceImpl();
		try {
			List<Student> stu = service.search(name,sex);
			request.setAttribute("list", stu);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
