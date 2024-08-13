package com.connecction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionInstnace {
	
	public  static Connection getConnection() throws SQLException {
		Connection conn=null;
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/velocitye-comm", "root", "admin");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		return conn;
	}

}
