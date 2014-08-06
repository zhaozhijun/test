package com.erayt.decorater.absDeco;

import com.erayt.decorater.UserManager;

public class TransDecorater extends DecoraterUserManager{

	public TransDecorater(UserManager userManager) {
		super(userManager);
	}

	@Override
	public void addUser() {
		userManager.addUser();
		trans();
	}
	
	public void trans(){
		System.out.println("trans......");
	}
}
