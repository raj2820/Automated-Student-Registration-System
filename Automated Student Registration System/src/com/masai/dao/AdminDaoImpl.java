package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Utility.DBUtil;
import com.masai.exception.AdminException;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Admin;
import com.masai.model.AdminStudentCourseDTO;

public class AdminDaoImpl implements AdminDao{

	@Override
	public List<AdminStudentCourseDTO> getAllStudentsByCourseName(String cname) throws CourseException {
		List<AdminStudentCourseDTO> dtos = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
PreparedStatement ps = conn.prepareStatement("select s.roll,s.name,s.username"
		+ ",c.cname,c.duration from student s INNER JOIN course c INNER JOIN student_course sc ON s.roll=sc.roll "
		+ "AND c.cid=sc.cid AND c.cname = ?");
			
			ps.setString(1, cname);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			AdminStudentCourseDTO dto = new AdminStudentCourseDTO();
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

	@Override
	public String registerAdmin(Admin admin) throws AdminException {
		String message ="Not registered";
		
		
		
		try (Connection conn= DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into admin(aname,username,password) values(?,?,?)");
			ps.setString(1,admin.getAname());
			ps.setString(2,admin.getUsername());
			ps.setString(3,admin.getPassword());
			
			
			int x =ps.executeUpdate();
			if(x>0) {
				message = "admin registered sucessfully";
			}else {
				message = "Registration failed";
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		

		return message;
	}

	@Override
	public Admin adminSignin(String username, String password) throws AdminException {
		Admin admin = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps =conn.prepareStatement("select * from admin where username = ? AND password = ?");
			ps.setString(1, username);
			ps.setString(2,password);
			
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				int aid = rs.getInt("aid");
				String n= rs.getString("aname");
				String u =rs.getString("username");
				String p=rs.getString("password");
				 admin =new Admin(aid, n,u, p);
			}else {
				
				throw new AdminException("Invalid username or password");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new AdminException(e.getMessage());
		}
		

		return admin;
	}

	
}
