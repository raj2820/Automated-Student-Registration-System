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

		System.out.println("Enter Admin username :");
		String username= sc.next();
	
		System.out.println("Enter Password :");
		String password= sc.next();
		
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
			Admin admin = dao.adminSignin(username, password);
      System.out.println("Welcome "+admin.getAname().toUpperCase());
			
			System.out.println("Enter 1 to see Students enrolled in a course ");
			System.out.println("Enter 2  to update fee of a course");
			System.out.println("Enter 3 to Delete a course");
			System.out.println("Enter 4 to Add a new course");
			System.out.println("Enter 5 to log out");
	int z=sc.nextInt();
			switch (z) {
			case 1: {
				
				System.out.println("Enetr course name to Get details of students :");
				String cname = sc.next()	;


				try {
					List<AdminStudentCourseDTO> dtos = dao.getAllStudentsByCourseName(cname);


				dtos.forEach(s->System.out.println(s));

				} catch (CourseException e) {

					e.printStackTrace();
				}
				
				break;
			}
			case 2:{
			
				
				
				System.out.println("Enter course id");
				int cid=sc.nextInt();
				
				System.out.println("Enter fee to be updated");
				int fee = sc.nextInt();
		
			
				try {
				String res = dao.updateFee(cid, fee);
				System.out.println(res);
					
					
				} catch (CourseException e) {
					e.printStackTrace();
			
				}
				break;
			}
			case 3 :{
				System.out.println("Enter the course id to be deleted");
				int cid =sc.nextInt();
				
				
			
				
				
				try {
					String res = dao.deleteCourse(cid);
					System.out.println(res);
				} catch (CourseException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				
				break;
				
			}
			case 4:{
				System.out.println("Enter course name");
				String cname = sc.next();
				
				System.out.println("Enter course fee");
				int fee=sc.nextInt();
				
				System.out.println("Enter course duration");
				String duration =sc.next();
	
				try {
					
				String res = dao.addCourse(cname, fee, duration)	;
				System.out.println(res);
					
				} catch (Exception e) {
					// TODO: handle exception
				
					System.out.println(e.getMessage());
				}

			}
			case 5:{
				System.out.println("Logged out sucessfully.....!");
				return;
			}
			}
		} catch (AdminException e) {
			
		
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
