package com.test.servlet;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.StudentService.StudentService;
import com.test.StudentService.StudentServiceImpl;
import com.test.domain.BeanPage;

/**
 * Servlet implementation class StudentPageListServlet
 */
public class StudentPageListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int currentpage = Integer.parseInt(request.getParameter("currentpage"));
			int listperpage = Integer.parseInt(request.getParameter("listperpage"));
			
		StudentService service = new StudentServiceImpl();
		BeanPage beanpage = new BeanPage();
			beanpage = service.findStudentByPage(currentpage, listperpage);
			request.setAttribute("beanpage", beanpage);
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			//e.printStackTrace();
		} catch (Exception e){
			
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
