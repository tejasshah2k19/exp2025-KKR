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
import javax.servlet.http.HttpSession;

import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.util.DbConnection;

@WebServlet("/CategoryWiseChartController")
public class CategoryWiseChartController extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ExpenseBean> list = new ArrayList<ExpenseBean>();

		ArrayList<String> categoryList  = new ArrayList<String>();
		ArrayList<Integer> amountList  = new ArrayList<>();
		
		try {

			HttpSession session = request.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			
			
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt  = con.prepareStatement("select category,sum(amount) as amount from expenses where userId = ? group by category  ");
			pstmt.setInt(1, user.getUserId());
			
			ResultSet rs =  pstmt.executeQuery();
			
			
			
			while(rs.next()) {
				String category = rs.getString("category");
				int amount = rs.getInt("amount");
				
				ExpenseBean bean = new ExpenseBean();
				bean.setCategory(category);
				bean.setAmount(amount);
				
				categoryList.add(category);
				amountList.add(amount);
				
				list.add(bean);
			}
			
		
		} catch (Exception e) {

		}
		
		request.setAttribute("list", list);
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("amountList", amountList);
		
		RequestDispatcher rd = request.getRequestDispatcher("CategoryWiseBarChart.jsp");
		rd.forward(request, response);

	
	}
}
