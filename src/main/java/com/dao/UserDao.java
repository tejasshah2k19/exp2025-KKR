package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	// db -> input
	// db -> output

	// signup
	public void addUser(UserBean userBean) {

		// db connection
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("insert into users (firstName,email,password) values (?,?,?)");
			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getEmail());
			pstmt.setString(3, userBean.getPassword());

			pstmt.executeUpdate(); //

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public UserBean authenticate(String email, String password) {
		UserBean user = null;
		try (Connection con = DbConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select * from users where email = ? and password = ? ");) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				user  = new UserBean(); 
				String fn = rs.getString("firstName");
				int userId = rs.getInt("userId");
				
				user.setFirstName(fn);
				user.setEmail(email);
				user.setPassword(password);
				user.setUserId(userId);
				
			}

		} catch (Exception e) {

		}

		return user;
	}

}
