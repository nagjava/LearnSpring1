package com.spring.util;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CertificateFilter implements Filter {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("===doFilter======CertificateFilter====");
//		String code = CertificationGenerator.getCode();
//		HttpSession session = ((HttpServletRequest) request).getSession();
//		session.setAttribute("code", code );
//		((HttpServletResponse) response).setHeader("Pragma", "no-cache");
//		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
//		response.setContentType("image/jpeg");
//		ServletOutputStream s= response.getOutputStream();;
//		try {
//				s = response.getOutputStream();
//			ImageIO.write(CertificationGenerator.getGraphics(code), "jpeg", s);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			s.close();
//		}
//		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	
	}
}
