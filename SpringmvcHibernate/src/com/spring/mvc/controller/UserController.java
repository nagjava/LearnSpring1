package com.spring.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.spring.mvc.bean.User;
import com.spring.mvc.dao.daoImpl.UserDaoImpl;
import com.spring.mvc.service.IUserService;
import com.spring.util.CertificationGenerator;
import com.spring.util.Message;

@Controller
public class UserController {
	private Logger logger = Logger.getLogger(UserController.class);
	private IUserService helloSevice;

	public IUserService getHelloSevice() {
		return helloSevice;
	}

	@Resource
	public void setHelloSevice(IUserService helloSevice) {
		this.helloSevice = helloSevice;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "hello");
		return "hello";
	}

	@RequestMapping(value = "/dispatchAdd")
	public String dispatchAddJsp() {
		return "user";
	}

	@RequestMapping(value = "/dispatchLogin")
	public String dispatchLogin(HttpServletRequest request,
			HttpServletResponse response) {
		return "login";
	}

	@RequestMapping(value = "login")
	public String login(@ModelAttribute("User") User user,
			@RequestParam("checkCode") String checkCode,
			HttpServletRequest request) {
		List list;
		String code=(String) request.getSession().getAttribute("code");
		if (!checkCode.equalsIgnoreCase(code)) {
			return "login";
		}
		if (helloSevice.login(user)) {
			list = helloSevice.getAll();
			request.setAttribute("list", list);
			request.setAttribute("user", user);
			request.getSession().setAttribute("username", user.getUsername());
			return "main";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/addUser")
	public String add(@ModelAttribute("User") User user,
			HttpServletResponse response) {
		logger.info("addUser");
		String result = helloSevice.addUser(user);
		if (Message.SUCCESS.equals(result)) {
			return "login";
		}
		return "user";
	}

	@RequestMapping(value = "delete")
	public String deleteUser(@RequestParam(value = "id") int id,
			HttpServletRequest req, HttpServletResponse response)
			throws IOException {
		logger.info("delete");
		helloSevice.deleteUser(id);
		List list = helloSevice.getAll();
		req.setAttribute("list", list);
		return "redirect:getAll.do";
		// response.sendRedirect("redirect:/getAll.do");
	}

	@RequestMapping(value = "delete1")
	public String delete(@ModelAttribute("User") User user,
			HttpServletRequest req) {
		helloSevice.deleteUser(user);
		List list = helloSevice.getAll();
		req.setAttribute("list", list);
		return "main";
	}

	@RequestMapping(value = "getAll")
	public String getAll(HttpServletRequest request, ModelMap map) {
		if (null==request.getSession().getAttribute("username")) {
				return "login";
		}
		List list = helloSevice.getAll();
		map.addAttribute("list", list);
		return "main";
	}
}