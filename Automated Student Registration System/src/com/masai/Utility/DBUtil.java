package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    
    
    private static String url;
    private static String driverName;
    private static String username;
    private static String password;
    
    static {
        
        ResourceBundle rb= ResourceBundle.getBundle("dbdetails");
        
        url= rb.getString("db.url");
        driverName= rb.getString("db.drivername");
        username= rb.getString("db.username");
        password= rb.getString("db.password");
        
        
        
    }
    
    
    
    public static Connection provideConnection() {
        
        Connection conn = null;
        
        
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        
        
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
        return conn;
    }
}



//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBUtil {
//
//	public static Connection provideConnection() {
//		
//		Connection conn =null;
//		
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");//loading driver related main class into the memory.
//			
//		} catch (ClassNotFoundException e) {
//		
//			e.printStackTrace();
//		}	
//String url ="jdbc:mysql://localhost:3306/asmsdb"; //connecting string.
//
////asmsdb:- abbreviation for Automated student management system database;
//
//
//
//try {
//	conn = DriverManager.getConnection(url, "root","root");//establishing connection , username="root" and password="root" for MySQL database .
//} catch (SQLException e) {
//
//	e.printStackTrace();
//}
//		return conn;
//		
//	}
//
//	
//	
//	
//	
//	
//}
