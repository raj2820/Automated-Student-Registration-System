package com.masai.UseCases;


import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.exception.CourseException;
import com.masai.model.Admin;
import com.masai.model.AdminStudentCourseDTO;

public class AdminLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("Welcome to Adminstartor login");

		System.out.println("Enter Admin username :");
		String username= sc.next();
	
		System.out.println("Enter Password :");
		String password= sc.next();
		
		
		
		
		try {
			AdminDao dao = new AdminDaoImpl();
			Admin admin = dao.adminSignin(username, password);
      System.out.println("Welcome "+admin.getAname().toUpperCase());
			
     Adminoptions.main(args);
      
	
		} catch (AdminException e) {
			
		
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
