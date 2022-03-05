package com.jspiders.tmg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseUtils {
	
	private final String url ="jdbc:mysql://localhost:3306/appusers";
	private final String user="root";
	private final String password="Rsb@mysql3909";
	
	Connection cn = null;

	void connect() {
		
		try {
			cn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to MySQL DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void disConnect() {
		try {
			cn.close();
			System.out.println("Disconnected from MySQL DB");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
