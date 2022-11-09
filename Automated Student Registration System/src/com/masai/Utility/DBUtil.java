package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public static Connection provideConnection() {
		
		Connection conn =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//loading driver related main class into the memory.
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}	
String url ="jdbc:mysql://localhost:3306/asmsdb"; //connecting string.

//asmsdb:- abbreviation for Automated student management system database;



try {
	conn = DriverManager.getConnection(url, "root","root");//establishing connection , username="root" and password="root" for MySQL database .
} catch (SQLException e) {

	e.printStackTrace();
}
		return conn;
		
	}

	
	
	
	
	
}
