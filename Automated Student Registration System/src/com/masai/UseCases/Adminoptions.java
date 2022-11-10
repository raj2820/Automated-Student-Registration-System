package com.masai.UseCases;

import java.util.List;
import java.util.Scanner;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;
import com.masai.model.AdminStudentCourseDTO;

public class Adminoptions {
static int adminChoices() {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter 1 to see Students enrolled in a course ");
	System.out.println("Enter 2  to update fee of a course");
	System.out.println("Enter 3 to Delete a course");
	System.out.println("Enter 4 to Add a new course");
	System.out.println("Enter 5 to Create a new Batch");
	System.out.println("Enter 6 to Update batch size");
	System.out.println("Enter 7 to log out");
	int z=sc.nextInt();
	return z;
}

static void adminSwitches(int z,AdminDao dao) {
	Scanner sc =new Scanner(System.in);

	
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
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		AdminoptionContainer();
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
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		
		AdminoptionContainer();
		
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
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		
		AdminoptionContainer();
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
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		AdminoptionContainer();
		break;
	}
	case 5:{
	
		
		System.out.println("Enter course-id ");
		int cid = sc.nextInt();
		
		System.out.println("Enter batch name");
		String bname= sc.next();
		
		System.out.println("Enter batch size");
		
		int size = sc.nextInt();

		try {
			
			String res = dao.createBatch(bname, cid, size);
			System.out.println(res);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		AdminoptionContainer();
		
		break;				
	}
	case 6:{

		System.out.println("Enter batch name");
		String bname = sc.next();
		System.out.println(" Enter size");
		int size = sc.nextInt();
		try {
	
			String res = dao.updateBatchSize(bname, size);
			System.out.println(res);
			
			int d=0;
			
			if(d == 1) {
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		AdminoptionContainer();
		break;
	}
	case 7 :{
		
		System.out.println("Logged out sucessfully.....!");
	
		return;
		
	}
	

	
	}
	

}
static void	AdminoptionContainer(){
	AdminDao dao = new AdminDaoImpl();
				int z =	adminChoices();
	 			adminSwitches(z,dao);
	 			
	}
	public static void main(String[] args) {
	
		AdminoptionContainer();
	}
	


	
	

}
