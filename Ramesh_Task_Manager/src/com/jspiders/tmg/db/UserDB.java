package com.jspiders.tmg.db;

import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jspiders.tmg.entities.User;
import com.jspiders.tmg.request.UpdateRequest;

public class UserDB extends DatabaseUtils implements Database {
	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public int insert(Object obj) {
		System.out.println("inserting data to database");
		
		User u1 = (User)obj;  // downcast object class(super class) ref to User(sub class) ref
		
		
		String sql = "insert into appusers.users values(0,?,?,?,?,?)";
		int rowCount =0;
		connect();
		
		try {
			PreparedStatement psm = cn.prepareStatement(sql);
			psm.setString(1, u1.getName()); // get the data from userEntity class and SET it to placeholders.
			psm.setString(2, u1.getEmail());
			psm.setString(3, u1.getPassword());
			psm.setString(4, u1.getMob());
			psm.setString(5, u1.getGender());
			
			System.out.println(psm);
			                  
			rowCount = psm.executeUpdate();
			
			System.out.println("data inserted to database successfully");
			
		} catch (SQLException e) {
			System.out.println(e);
			
		}
		
		disConnect();
		
		return rowCount;
	}

	@Override
	public int update(Object obj) {
		
		UpdateRequest req = (UpdateRequest)obj;// Downcasting
		
		int code = req.getCode();
		int rowCount =0;
		
		connect();
		
		try {
		
		
		if(code==1) {
			String updateEmail = "update appusers.users set email= ? where email= ? ";
			
			PreparedStatement psm = cn.prepareStatement(updateEmail);
			psm.setString(1, req.getNewValue());
			psm.setString(2, req.getOldValue());
			rowCount = psm.executeUpdate();
		}
		else if(code==2) {
			
			System.out.println(" Enter your Email-id to update password ");
			String email = scan.next();
			
			String updatePassword = "update appusers.users set password = ? where password = ? and email = ?";
			
			PreparedStatement psm = cn.prepareStatement(updatePassword);
			psm.setString(1, req.getNewValue());
			psm.setString(2, req.getOldValue());
			psm.setString(3, email);
			
			rowCount = psm.executeUpdate();
			System.out.println(psm);
			
		}
		else {
			String updateMobile = "update appusers.users set mobile = ? where mobile = ? ";
			
			PreparedStatement psm = cn.prepareStatement(updateMobile);
			
			psm.setString(1, req.getNewValue());
			psm.setString(2, req.getOldValue());
			rowCount = psm.executeUpdate();
			
		}
		
		} catch (SQLException e) {
		System.out.println(e);
		}
		disConnect();
		return rowCount;

	}

	@Override
	public int delete(Object obj) {
		String DeleteQuery = "delete from appusers.users where email = ? ";
		
		int rowCount=0;
		connect();
		try {
			PreparedStatement psm = cn.prepareStatement(DeleteQuery);
			
			String email = (String)obj;
			psm.setString(1, email);
		
			rowCount = psm.executeUpdate();
			
//			System.out.println("user data deleted successfully.");
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		disConnect();
		
		return rowCount;
	}

	@Override
	public Object selectOne(Object obj) {
		
		String email_id = (String)obj;
		
		User u1 = new User();
		
		String selectOneQuery = "select name,email,mobile,gender from appusers.users where email = ?";
		connect();
		try {
			PreparedStatement psm = cn.prepareStatement(selectOneQuery);
			
			
			psm.setString(1, email_id);
			
//			System.out.println(psm);
			
			ResultSet rs = psm.executeQuery();
			
			rs.next();
			
			String name   = rs.getString(1);
			String email  = rs.getString(2);
			String mob    = rs.getString(3);
			String gender = rs.getString(4);
			
			
			
			u1.setName(name);
			u1.setEmail(email);
			u1.setMob(mob);
			u1.setGender(gender);

		
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disConnect();
		
		return u1;
	}

	@Override
	public List<Object> selectMultiple(Object obj) {
		
		return null;
	}

	@Override
	public List<Object> selectAll() {
		
		
		return null;
	}

}
