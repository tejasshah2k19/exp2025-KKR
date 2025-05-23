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

@WebServlet("/ListExpenseController")
public class ListExpenseController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ExpenseBean> list = new ArrayList<>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from expenses");

			ResultSet rs = pstmt.executeQuery();// 3 records
			
			
			while(rs.next())//1st record 
			{
				int expenseId = rs.getInt("expenseId");
				String title = rs.getString("title");
				int amount  = rs.getInt("amount");
				String category = rs.getString("category"); 
				String expenseDate =rs.getString("expenseDate");
		
				System.out.println(title+" "+amount +" "+category+" "+expenseDate);
				
				ExpenseBean bean= new ExpenseBean();
				bean.setAmount(amount);
				bean.setCategory(category);
				bean.setExpenseDate(expenseDate);
				bean.setTitle(title);
				bean.setExpenseId(expenseId);
				
				list.add(bean);
				 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListExpense.jsp");
		rd.forward(request, response);

	}
}
