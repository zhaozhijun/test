package com.erayt.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.erayt.bean.User;
import com.erayt.service.UserService;

public class UserServlet extends HttpServlet {

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
		Integer id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		String url = req.getRequestURL().toString();
		String method = url.substring(url.indexOf("!") + 1, url.indexOf(".do"));
		System.out.println(method);
		UserService userService = new UserService();
		if ("add".equals(method)) {
			userService.addUser(user);
			resp.getWriter().print("add success");
		} else if ("update".equals(method)) {
			userService.updateUser(user);
			resp.getWriter().print("udpate success");
		} else if ("delete".equals(method)) {
			userService.deleteUser(user);
			resp.getWriter().print("delete success");
		} else if ("query".equals(method)) {
			resp.getWriter().println(
					JSONArray.fromObject(userService.getUsers()));
		}
	}

}
