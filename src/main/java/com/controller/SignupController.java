package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName =request.getParameter("firstName");
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		

		UserBean userBean = new UserBean();
		userBean.setEmail(email);
		userBean.setFirstName(firstName);
		userBean.setPassword(password);
		
		
		UserDao userDao = new UserDao();
		userDao.addUser(userBean);
		
		
		//login 
		response.sendRedirect("Login.jsp");
		
	
	}
	
}
