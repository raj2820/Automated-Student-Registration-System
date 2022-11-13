package com.masai.UseCases;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;
import com.masai.model.StudentStudentCourseDTO;

public class GetCourseInformationForStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDao dao=new StudentDaoImpl();
		
		
		
		try {
			 List<StudentStudentCourseDTO> dtos = dao.getAllCourseInfo();
			 dtos.forEach(s->System.out.println("Course Id : "+s.getCid()+"\n"+"Course name : "+s.getCname()+"\n"+"Course Fee : " +s.getFee()+"\n"+"==================================="));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
