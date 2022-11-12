package com.masai.UseCases;

import java.util.Scanner;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;

import com.masai.exception.StudentException;
import com.masai.model.Student;


public class LogInStudentUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);

		System.out.println("Enter Student username :");
		String username= sc.next();
	
		System.out.println("Enter Password :");
		String password= sc.next();
		
		StudentDao dao=	new StudentDaoImpl();
		try {
			Student student = dao.studentSignIn(username, password); //login method
			System.out.println("Welcome "+student.getName().toUpperCase());
			
			//Options to choose enrollment method and updating password method.
	StudentOptions.main(args);
			
				
		} catch (StudentException e) {
		
		System.out.println(e.getMessage());
		System.out.println("Try again");
		System.out.println("\n");
		LogInStudentUseCase.main(args);
		}
	}
	
}
