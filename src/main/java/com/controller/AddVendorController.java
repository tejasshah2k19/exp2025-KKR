package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DbConnection;

@WebServlet("/AddVendorController")
public class AddVendorController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// read
		String vendorName = request.getParameter("vendorName");

		try {
			// open db connection
			Connection con = DbConnection.getConnection();

			// query run
			PreparedStatement pstmt = con.prepareStatement("insert into vendor (vendorName) values (?) ");
			pstmt.setString(1, vendorName);
			
			//run 
			pstmt.executeUpdate();//insert update delete 
			
			//response
			response.sendRedirect("ListVendorController"); 
			
			
	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
