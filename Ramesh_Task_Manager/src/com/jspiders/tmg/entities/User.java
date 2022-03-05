package com.jspiders.tmg.entities;

public class User extends Object {
	private int UID;
	private String name;
	private String email;
	private String password;
	private String mob;
	private String gender;
	
	public User() {
		super();
	}
	
	public User(int uID, String name, String email, String password, String mob, String gender) {
		super();
		UID = uID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mob = mob;
		this.gender = gender;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
