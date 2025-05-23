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

@WebServlet("/CategoryWiseSumController")
public class CategoryWiseSumController extends HttpServlet {

	// service
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ExpenseBean> list = new ArrayList<ExpenseBean>();
		try {

			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt  = con.prepareStatement("select category,sum(amount) as amount from expenses group by category");

			ResultSet rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				String category = rs.getString("category");
				int amount = rs.getInt("amount");
				
				ExpenseBean bean = new ExpenseBean();
				bean.setCategory(category);
				bean.setAmount(amount);
				
				list.add(bean);
			}
			
		
		} catch (Exception e) {

		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("CategoryWiseSum.jsp");
		rd.forward(request, response);
		
		
	}

}
