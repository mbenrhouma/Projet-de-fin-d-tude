package com.cynapsys.Views.controller;


import java.io.IOException;

import javax.faces.application.ViewExpiredException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cynapsys.entities.Utilisateur;


public class LoginFilter implements Filter {

	/**
	 * Checks if user is logged in. If not it redirects to the login.xhtml page.
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Utilisateur user = (Utilisateur) req.getSession().getAttribute(
				ConstantController.SESSION_CONNECTED_USER);
		
			if (user == null && verfierUrl(req.getRequestURI())) {
				String contextPath = ((HttpServletRequest) request)
						.getContextPath();
				((HttpServletResponse) response).sendRedirect(contextPath
						+ "/pageLogin.jsf");
				chain.doFilter(request, response);
				return;
			}

		try {
			chain.doFilter(request, response);
		} catch (ViewExpiredException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// Nothing to do here!
	}

	@Override
	public void destroy() {
		// Nothing to do here!
	}

	public boolean verfierUrl(String url) {
		if (url.contains(".png") || url.contains(".gif")
				|| url.contains(".jpeg") || url.contains(".jpg")
				|| url.contains(".js") || url.contains(".css")
				|| url.contains("pageLogin.jsf"))
			return false;
		return true;
	}

	
	
}
