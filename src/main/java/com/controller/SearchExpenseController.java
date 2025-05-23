package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ExpenseBean;
import com.util.DbConnection;

@WebServlet("/SearchExpenseController")//SearchExpenseController
public class SearchExpenseController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String category = request.getParameter("category");// read

		// db
		// select * from expenses where category = ?

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from expenses where category = ?");
			pstmt.setString(1, category);
			ResultSet rs = pstmt.executeQuery(); // select
			
			//expenseId	title	category amount 
			//1			XX			XX	 XX 
			//2			XX			XX	 XX 
			

			ArrayList<ExpenseBean> list = new ArrayList<ExpenseBean>();
			
			while(rs.next()) {

				int expenseId = rs.getInt("expenseId");
				String title = rs.getString("title");
				int amount = rs.getInt("amount");
				String expenseDate = rs.getString("expenseDate");
				
				ExpenseBean bean = new ExpenseBean();
				bean.setExpenseId(expenseId);
				bean.setAmount(amount);
				bean.setCategory(category);
				bean.setExpenseDate(expenseDate);
				bean.setTitle(title);
				
				list.add(bean);
			}
			
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ListExpense.jsp");
		rd.forward(request, response);

	}
}
