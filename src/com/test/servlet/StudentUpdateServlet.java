package com.test.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.StudentService.StudentService;
import com.test.StudentService.StudentServiceImpl;
import com.test.domain.Student;

/**
 * Servlet implementation class StudentUpdateServlet
 */
public class StudentUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		
		String [] h = request.getParameterValues("hobby");
		String hobby = Arrays.toString(h);
		hobby = hobby.substring(1, hobby.length()-1);
		
		String info = request.getParameter("info");
		
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		
		Student student = new Student(id,name,sex,phone,info,hobby,date);
		StudentService service = new StudentServiceImpl();
		service.update(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
