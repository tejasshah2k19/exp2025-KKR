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
public class AddExpenseFilterB implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String amount = request.getParameter("amount");
		String vendor = request.getParameter("title");
		boolean isError = false;

		String digitRegex = "[0-9]+";
		String alphaRegex = "[a-zA-Z]+";
		if (amount.matches(digitRegex) == false) {
			isError = true;
			request.setAttribute("amountError", "Please Enter Valid Amount");
		}
		if (vendor.matches(alphaRegex) == false) {
			isError = true;
			request.setAttribute("titleError", "Please Enter Valid Title name");
		}
		
		if(isError) {
			RequestDispatcher rd = request.getRequestDispatcher("AddExpense.jsp");
			rd.forward(request, response);
		}else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {

	}
}
