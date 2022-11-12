package com.masai.UseCases;

import java.util.List;
import java.util.Scanner;

import com.masai.Application.AutomatedStudentRegistrationSystem;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.StudentStudentCourseDTO;

public class StudentOptions {
	
static int studentChoices() {
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("\n");
	System.out.println("*********************************Student's main menu***********************");
	System.out.println("Enter 1 for course enrollment ");
	
	System.out.println("Enter 2 for updating password ");
	System.out.println("Enter 3 to see all courses info");
	System.out.println("Enter 4 to log out.....");
	int x=sc.nextInt();
	
	
	
	return x;
}
static void studentSwitches(int x) {
	Scanner sc =new Scanner(System.in);
	StudentDao dao = new StudentDaoImpl();
	switch (x) {
	case 1: {
		System.out.println("Enter Roll : ");
		int roll=sc.nextInt();
			System.out.println("Enter Course Id : ");
			int cid= sc.nextInt();

			System.out.println("Enter date (yyyymmdd) no extra characters");
			String date = sc.next();
			
		
			try {
				String result = dao.enrollStudentInCourse(roll,cid,date);
			System.out.println(result);
			} catch (StudentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CourseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n");
			System.out.println("===================================================");
			System.out.println("\n");
			studentOptionsContainer();
				break;
		
	}
	case 2:{
		System.out.println("Enter your username");
		String username=sc.next();
System.out.println("Enter current password");
		
		String pass=sc.next();
		System.out.println("Enter your new password");
		
		String newPassword=sc.next();
		System.out.println("re-enter new password");
		String newPassword2=sc.next();
		
		if(!newPassword.equals(newPassword2)) {
			System.out.println("Password does not match...!");
			return;
		}
		if(newPassword.equals(pass)) {
		
			System.out.println("New password cannot be your current password...");
			return;
		}
		String result;
		try {
			result = dao.changeStudentPassword(username,pass,newPassword2);
			System.out.println(result);
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //update password method.
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
	studentOptionsContainer();
		break;
	}case 3:{

		try {
			 List<StudentStudentCourseDTO> dtos = dao.getAllCourseInfo();
			 dtos.forEach(s->System.out.println("Course Id : "+s.getCid()+"\n"+"Course name : "+s.getCname()+"\n"+"Course Fee : " +s.getFee()+"\n"+"==================================="));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("\n");
		studentOptionsContainer();
		break;
		
	}case 4:{
		
		
		System.out.println("Logged out sucessfully......");
		AutomatedStudentRegistrationSystem.main(null);
		return;
	}
	
	}
	
}

static void studentOptionsContainer() {
	int z = studentChoices();
	studentSwitches(z);
}

	public static void main(String[] args) {
	
		studentOptionsContainer();

	}

}
