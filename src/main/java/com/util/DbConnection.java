package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {

		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/exp25";
		String userName = "root";
		String password = "root";

		try {
			// load driver
			Class.forName(driverName);
			Connection con = DriverManager.getConnection(url, userName, password);
			return con;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
