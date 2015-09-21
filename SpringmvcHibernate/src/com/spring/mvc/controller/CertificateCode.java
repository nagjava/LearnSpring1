package com.spring.mvc.controller;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.util.CertificationGenerator;

@Controller
public class CertificateCode {
	@RequestMapping(value = "/certificate")
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		String code = CertificationGenerator.getCode();
		HttpSession session = ((HttpServletRequest) request).getSession();
		session.setAttribute("code", code );
		((HttpServletResponse) response).setHeader("Pragma", "no-cache");
		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
		response.setContentType("image/jpeg");
		ServletOutputStream s= null;
		try {
			s = response.getOutputStream();
			ImageIO.write(CertificationGenerator.getGraphics(code), "jpeg", s);
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
