package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Admin;

public class AdminLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);

		System.out.println("Enter Admin username :");
		String username= sc.next();
	
		System.out.println("Enter Password :");
		String password= sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			Admin admin = dao.adminSignin(username, password);
      System.out.println("Welcome "+admin.getAname().toUpperCase());
			
			
	
			
			
		} catch (AdminException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
