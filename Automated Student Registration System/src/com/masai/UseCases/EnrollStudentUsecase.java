package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;

public class EnrollStudentUsecase {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
System.out.println("Enter Roll : ");
	int roll=sc.nextInt();
		System.out.println("Enter Course Id : ");
		int cid= sc.nextInt();

		System.out.println("Enter date (yyyymmdd) ");
		String date = sc.next();
		
		StudentDao dao =new StudentDaoImpl();
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
	}
}
