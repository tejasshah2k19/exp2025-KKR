package com.controller;

import java.io.IOException;
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

@WebServlet("/ViewExpenseController")
public class ViewExpenseController extends HttpServlet {

	// doGet doPost{form}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer expenseId = Integer.parseInt(request.getParameter("expenseId"));

		// select * from expenses where expenseId = ?

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from expenses where expenseId = ?");
			pstmt.setInt(1, expenseId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ExpenseBean expenseBean = new ExpenseBean();

				expenseBean.setTitle(rs.getString("title"));
				expenseBean.setAmount(rs.getInt("amount"));
				expenseBean.setCategory(rs.getString("category"));
				expenseBean.setExpenseDate(rs.getString("expenseDate"));
				expenseBean.setExpenseId(rs.getInt("expenseId"));

				request.setAttribute("bean", expenseBean);
				request.getRequestDispatcher("ViewExpense.jsp").forward(request, response);
			} else {

				request.getRequestDispatcher("ListExpenseController").forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
