package com.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordEncrypt {

	public static void main(String[] args) {

		String password = "royal";
		
		String encPwd = BCrypt.withDefaults().hashToString(10, password.toCharArray());
		System.out.println(encPwd);
		
		
	}
}
