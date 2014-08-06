package com.erayt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erayt.bean.User;
import com.erayt.service.UserService;

public class LoginServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		System.out.println(name + "=====" + password);
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		UserService userService = new UserService();
		User loginUser = userService.login(user);
		if (null == loginUser) {
			req.setAttribute("loginValiMessage", "用户名或者密码不正确");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		HttpSession session = req.getSession();
		session.setAttribute("user", loginUser);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
