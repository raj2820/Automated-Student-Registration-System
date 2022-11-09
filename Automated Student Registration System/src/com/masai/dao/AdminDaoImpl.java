package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Utility.DBUtil;
import com.masai.exception.CourseException;

import com.masai.model.StudentCourseDTO;

public class AdminDaoImpl implements AdminDao{

	@Override
	public List<StudentCourseDTO> getAllStudentsByCourseName(String cname) throws CourseException {
		List<StudentCourseDTO> dtos = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
PreparedStatement ps = conn.prepareStatement("select s.roll,s.name,s.username"
		+ ",c.cname,c.duration from student s INNER JOIN course c INNER JOIN student_course sc ON s.roll=sc.roll "
		+ "AND c.cid=sc.cid AND c.cname = ?");
			
			ps.setString(1, cname);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			StudentCourseDTO dto = new StudentCourseDTO();
		dto.setRoll(rs.getInt("roll"));
			dto.setSname(rs.getString("name"));	
		dto.setusername(rs.getString("username"));
				dto.setCname(rs.getString("cname"));
			dto.setDuration(rs.getString("duration"));
			dtos.add(dto);
			
			
			}
			
			if(dtos.size()==0) {
				throw new CourseException("No student in that course");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CourseException();
			
		}
		

		
		return dtos;
	}

	
}
