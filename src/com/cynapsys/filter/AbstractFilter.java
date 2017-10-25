package com.cynapsys.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AbstractFilter  {
	public AbstractFilter() {
		super();
	}

	protected void doLogin(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("/pageLogin.jsf").forward(request, response);
		
	}
}