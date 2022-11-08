package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public class RegisterStudentUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Student Name :");
		String name= sc.next();

		

		System.out.println("Enter Student email/username :");
		String email= sc.next();
		
		System.out.println("Enter Password :");
		String password= sc.next();

		
		Student student= new Student();
		student.setName(name);
		
		student.setEmail(email);
		student.setPassword(password);
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
		String result= dao.registerStudent(student);
		
		System.out.println(result);
		
		
		}catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
