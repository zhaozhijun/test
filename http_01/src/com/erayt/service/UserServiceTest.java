package com.erayt.service;

import org.junit.Before;
import org.junit.Test;

import com.erayt.bean.User;

public class UserServiceTest {
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		userService=new UserService();
	}

	@Test
	public void testAddUser() {
		for (int i = 0; i < 1000000; i++) {
			User user=new User();
			user.setId(i);
			user.setName("zhaozj"+i);
			user.setPassword("admin"+i);
			userService.addUser(user);
		}
	}

}
