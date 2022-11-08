package com.masai.dao;

import com.masai.exception.StudentException;
import com.masai.model.Student;

public interface StudentDao {
	public String registerStudent(Student student)throws StudentException;
	
	
	
}
