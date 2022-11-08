package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.Utility.DBUtil;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String registerStudent(Student student) throws StudentException {
String result = "Not Inserted..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("insert into student(name,username,password) values(?,?,?)");
			
			ps.setString(1, student.getName());
		
			ps.setString(2, student.getUserName());
			ps.setString(3, student.getPassword());
			
			
			int x= ps.executeUpdate();
			
			if(x >0)
				result = "Student Registered Sucessfully..";
				
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		

		return result;
	}

}
