package com.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ExpenseBean;
import com.util.DbConnection;

@WebServlet("/DeleteExpenseController")
public class DeleteExpenseController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer expenseId = Integer.parseInt(request.getParameter("expenseId"));

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from expenses where expenseId = ? ");
			pstmt.setInt(1, expenseId);
			pstmt.executeUpdate();// 3 records
			response.sendRedirect("ListExpenseController");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
