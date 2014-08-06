package com.erayt.service;

import java.util.ArrayList;
import java.util.List;

import com.erayt.bean.User;
import com.erayt.dao.user.UserDao;
import com.erayt.dao.user.impl.UserDaoImpl;

public class UserService {
	private UserDao userDao;
	public User login(User user) {
		if (user.getName().equals("admin")
				&& user.getPassword().equals("admin")) {
			return user;
		}
		return null;
	}

	public void addUser(User user) {
		userDao=new UserDaoImpl();
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		System.out.println(user);
	}

	public void deleteUser(User user) {
		System.out.println(user);
	}

	public List<User> getUsers() {
		List<User> list = new ArrayList<User>(16);
		User user1 = new User(1, "admin", "admin");
		User user2 = new User(2, "system", "system");
		User user3 = new User(3, "sys", "change");
		User user4 = new User(4, "oscenter", "oscenter");
		User user5 = new User(5, "liuliuq", "liliuh");
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		list.add(user5);
		return list;
	}
}
