package com.erayt.servlet.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erayt.bean.User;

/**
 * 
 * @ClassName: BaseServlet
 * @Description: 简单的登录权限验证（没登录，不能访问其他的资源）
 * @author zhaozj
 * @date 2014-4-30 上午9:55:02
 * 
 */
public abstract class BaseServlet extends HttpServlet {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (null == user) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		doService(req, resp);
	}

	protected abstract void doService(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException;
}
