package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// db check
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.authenticate(email, password);

		if(userBean == null) {
			request.setAttribute("error", "Invalid Credentials");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}else {
			
			HttpSession session  = request.getSession();
			session.setAttribute("user", userBean);
			
			response.sendRedirect("index.jsp");
		}
		
	}
}
