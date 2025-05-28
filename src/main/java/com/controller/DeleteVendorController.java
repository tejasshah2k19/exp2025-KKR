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

@WebServlet("/DeleteVendorController")
public class DeleteVendorController extends HttpServlet{

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int vendorId = Integer.parseInt( request.getParameter("vendorId"));
		
		try
		{
				Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from vendor where vendorId = ? ");
				pstmt.setInt(1, vendorId);
				pstmt.executeUpdate(); 
				response.sendRedirect("ListVendorController");
				
		}catch(Exception e) {
			
		}
		
		
	}
}
