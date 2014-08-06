package com.erayt.decorater.absDeco;

import com.erayt.decorater.UserManager;

public abstract class DecoraterUserManager implements UserManager{
	
	protected UserManager userManager;
	
	public DecoraterUserManager(UserManager userManager){
		this.userManager=userManager;
	}

	@Override
	public void addUser() {
		userManager.addUser();
	}
	
}
