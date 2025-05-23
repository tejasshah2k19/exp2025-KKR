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

import com.bean.VendorBean;
import com.util.DbConnection;

@WebServlet("/ListVendorController")
public class ListVendorController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// db connection
			Connection con = DbConnection.getConnection();

			// query
			PreparedStatement pstmt = con.prepareStatement("select * from vendor");

			// run
			ResultSet rs = pstmt.executeQuery();// db records

			ArrayList<VendorBean> list = new ArrayList<VendorBean>();
			while (rs.next()) {
				// 1st Record
				int vendorId = rs.getInt("vendorId");
				String vendorName = rs.getString("vendorName");

				VendorBean bean = new VendorBean();
				bean.setVendorId(vendorId);
				bean.setVendorName(vendorName);
				list.add(bean);
			}

			// jsp-> list send
			// servlet ->Data -> next jsp
			request.setAttribute("list", list);

			// jsp -> redirect
			RequestDispatcher rd = request.getRequestDispatcher("ListVendor.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
