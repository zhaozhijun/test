package com.erayt.decorater.absDeco;

import com.erayt.decorater.UserManager;

public class LogDecorater extends DecoraterUserManager{

	public LogDecorater(UserManager userManager) {
		super(userManager);
	}

	@Override
	public void addUser() {
		userManager.addUser();
		log();
	}
	
	public void log(){
		System.out.println("log......");
	}
}
