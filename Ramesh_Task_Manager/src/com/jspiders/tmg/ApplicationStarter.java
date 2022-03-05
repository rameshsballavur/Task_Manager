package com.jspiders.tmg;

import com.jspiders.tmg.services.UserService;

public class ApplicationStarter {

	public static void main(String[] args) {
		UserService us = new UserService();
		
//		us.signUp();
		us.viewProfile();
//		us.updateProfile();
//		us.deleteProfile();
	}

}
