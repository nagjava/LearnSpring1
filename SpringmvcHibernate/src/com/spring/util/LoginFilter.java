package com.spring.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/login")
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("=====doFilter=====Loginfilter============");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		RequestDispatcher dispatcher;
		String username = (String) session.getAttribute("username");
		// 查询是否已登陆
		if (username == null ) {
			dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		System.out.println("=====destroy=====Loginfilter============");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("====init======Loginfilter=========");
	}

}
