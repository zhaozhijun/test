package com.erayt.decorater;

public class UserManagerBean implements UserManager{

	@Override
	public void addUser() {
		System.out.println("origin add user......");
	}

}
