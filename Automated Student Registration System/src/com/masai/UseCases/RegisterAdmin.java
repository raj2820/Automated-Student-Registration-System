package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.model.Admin;

public class RegisterAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter your name");
	String aname=sc.next();
	
	System.out.println("Enter username(email)");
	String username=sc.next();
	
	System.out.println("Enter password");
		String password = sc.next();
		
		Admin admin=new Admin();
		
		admin.setAname(aname);
		admin.setUsername(username);
		admin.setPassword(password);
		
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			String res = dao.registerAdmin(admin);
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
