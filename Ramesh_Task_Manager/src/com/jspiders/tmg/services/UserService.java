package com.jspiders.tmg.services;


import java.util.Scanner;

import com.jspiders.tmg.db.UserDB;
import com.jspiders.tmg.entities.User;
import com.jspiders.tmg.request.UpdateRequest;

public class UserService {
	UserDB usdb = new UserDB();
	Scanner scan = new Scanner(System.in);
	
	public void signUp() {
		System.out.println("User signUp()"+"\n");
		
		System.out.println("Enter your name");
		String name = scan.next();
		
		System.out.println("Enter your Email-id");
		String email = scan.next();
		
		System.out.println("Enter your password");
		String password = scan.next();
		
		System.out.println("Enter your mobile no.");
		String mobile = scan.next();
		
		System.out.println("Enter your Gender");
		String gender = scan.next();
		
		User u1 = new User();
		
		// set inputs to the user entity object using setter methods.
		u1.setName(name);
		u1.setEmail(email);
		u1.setPassword(password);
		u1.setMob(mobile);
		u1.setGender(gender);
		
		int rowCount = usdb.insert(u1);
		if(rowCount>0) {
			System.out.println("User account created successfully ");
		}
		else {
			System.out.println("User data already exists!");
		}
		
		
		
	}
	public void viewProfile() {
		
		System.out.println("Enter your Email-id: ");
		String email = scan.next();
		
		
		Object obj = usdb.selectOne(email);
		User u1 = (User)obj;
		
		System.out.println(u1.getName());
		System.out.println(u1.getEmail());
		System.out.println(u1.getMob());
		System.out.println(u1.getGender());
	}
	
	public void updateProfile() {
		
		UpdateRequest req = new UpdateRequest();
		
		System.out.println("SELECT the choice what you want to Update: ");
		
		System.out.println(" 1 -> to Update Email-id");
		System.out.println(" 2 -> to Update password");
		System.out.println(" 3 -> to Update Mobile number");
		
		int choice = scan.nextInt();
		int rowCount =0;
		
		if(choice == 1) {
			System.out.println("Enter your old Email-id : ");
			String oldEmail=scan.next();
			
			System.out.println("Enter your New Email-id");
			String newEmail = scan.next();
			
			req.setCode(choice);
			req.setOldValue(oldEmail);
			req.setNewValue(newEmail);
		}
		else if(choice == 2) {
			System.out.println("Enter your old password");
			String oldPassword = scan.next();
			
			System.out.println("Enter your new password");
			String newPassword = scan.next();
			
			req.setCode(choice);
			req.setOldValue(oldPassword);
			req.setNewValue(newPassword);
		}
		else if(choice == 3) {
			System.out.println("Enter your old mobile.no");
			String oldMob = scan.next();
			
			System.out.println("Enter your new mobile.no");
			String newMob = scan.next();
			
			req.setCode(choice);
			req.setOldValue(oldMob);
			req.setNewValue(newMob);
		}
		else {
			System.out.println("INVALID CHOICE");
		}
		
		rowCount = usdb.update(req);
	
		if(rowCount>0) {
			System.out.println("User profile updated.");
		}
		else {
			System.out.println("User data already exist");
		}
	
	}
	
	public void deleteProfile() {
		System.out.println("Enter Email-id : ");
		String email = scan.next();
		
		int rowCount = usdb.delete(email);
		
		if(rowCount>0) {
			System.out.println("user data deleted successfully ");
		}
		else {
			System.out.println("cannot find the user Email-id account.");
		}
	}
}
