package com.masai.UseCases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;
import com.masai.model.AdminStudentCourseDTO;

public class GetStudentsInCourseForAdminUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc =new Scanner(System.in);
AdminDao dao =new AdminDaoImpl();
		System.out.println("Enetr course name to Get details of students :");
		String cname = sc.next()	;


		try {
			List<AdminStudentCourseDTO> dtos = dao.getAllStudentsByCourseName(cname);


		dtos.forEach(s->System.out.println("Student Name : "+s.getSname()+"\n"+"Roll number : "+s.getRoll()+"\n"+"Course Name"+s.getCname()+"\n"+"Course duration : "+s.getDuration()+"\n"+"========================================================"));

		} catch (CourseException e) {

			e.printStackTrace();
		}


		
		
		
		
		
		

		
		
	}

}
