package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.util.DbConnection;

@WebServlet("/AddExpenseController")
public class AddExpenseController extends HttpServlet {

	// service
	// doGet
	// doPost
	@Override

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read form data
		String title = request.getParameter("title");
		String expenseDate = request.getParameter("expenseDate");
		String category = request.getParameter("category");
		int amount = Integer.parseInt(request.getParameter("amount"));

		HttpSession session = request.getSession(); 
		UserBean user = (UserBean) session.getAttribute("user");
		
		
		
		
		// validation
		 
		// db save
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into expenses (title,expenseDate,category,amount,userId) values (?,?,?,?,?) ");
			pstmt.setString(1,title);
			pstmt.setString(2, expenseDate);
			pstmt.setString(3, category);
			pstmt.setInt(4, amount);
			pstmt.setInt(5, user.getUserId());
			
			
			pstmt.executeUpdate();// sql query run
			
			response.sendRedirect("index.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
