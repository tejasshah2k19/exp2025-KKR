package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/AddExpenseController")
public class AddExpenseFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("AddExpenseFilter :: doFilter ");
		// validation
		// goahead
		String title = request.getParameter("title");
		String amount  = request.getParameter("amount");
		
		boolean isError = false;

		if (title == null || title.isBlank()) {
			isError = true;
			request.setAttribute("titleError", "Please Enter Title");
		}
		
		if(amount == null || amount.isBlank()) {
			isError  = true;
			request.setAttribute("amountError", "Please Enter Amount"); 
		}
		
		if (isError == true) {
			// go back
			RequestDispatcher rd = request.getRequestDispatcher("AddExpense.jsp");
			rd.forward(request, response);

		} else {

			chain.doFilter(request, response);// goahead
		}

	}

	public void destroy() {

	}

}
