package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;

public class DeleteCourseUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the course id to be deleted");
		int cid =sc.nextInt();
		
		
		AdminDao dao = new AdminDaoImpl();
		

		
		try {
			String res = dao.deleteCourse(cid);
			System.out.println(res);
		} catch (CourseException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		
	}

}
