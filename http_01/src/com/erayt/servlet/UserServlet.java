package com.erayt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erayt.bean.User;
import com.erayt.service.UserService;
import com.erayt.servlet.base.BaseServlet;

public class UserServlet extends BaseServlet{

	/** 
	* @Fields serialVersionUID 
	*/ 
	private static final long serialVersionUID = 1L;

	@Override
	protected void doService(HttpServletRequest request,
			HttpServletResponse response) throws IOException,ServletException{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		UserService userService=new UserService();
		userService.addUser(user);
		request.getRequestDispatcher("user/user_detail.jsp").forward(request, response);
	}
	
	
}
