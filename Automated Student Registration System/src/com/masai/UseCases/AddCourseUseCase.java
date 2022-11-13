package com.masai.UseCases;


import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class AddCourseUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		
		
		System.out.println("Enter course name");
		String cname = sc.next();
		
		System.out.println("Enter course fee");
		int fee=sc.nextInt();
		
		System.out.println("Enter course duration");
		String duration =sc.nextLine();
		duration = sc.nextLine();
		
		AdminDao dao = new AdminDaoImpl();
		
		

		try {
			
		String res = dao.addCourse(cname, fee, duration)	;
		System.out.println(res);
			
		} catch (Exception e) {
			// TODO: handle exception
		
			System.out.println(e.getMessage());
		}
		
		
	}

}
