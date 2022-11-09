package com.masai.dao;

import java.util.List;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.StudentStudentCourseDTO;
import com.masai.model.Student;

public interface StudentDao {
	public String registerStudent(Student student)throws StudentException;
	
	public Student studentSignIn(String username , String password) throws StudentException;
	
	public String enrollStudentInCourse(int roll ,int cid ) throws StudentException , CourseException;
	
	public String changeStudentPassword(String username ,String password,String newPassword) throws StudentException;
	
	public List<StudentStudentCourseDTO> getAllCourseInfo() throws CourseException;




}
