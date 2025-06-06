package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class UserCounterListener implements HttpSessionListener {

	int userCounter = 0;

	public void sessionCreated(HttpSessionEvent se) {
		userCounter++;
		System.out.println("IN " + userCounter);
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		userCounter--;
		System.out.println("OUT " + userCounter);
	}
}
