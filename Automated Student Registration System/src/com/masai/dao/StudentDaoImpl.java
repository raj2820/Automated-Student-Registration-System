package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Utility.DBUtil;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.mysql.cj.xdevapi.Result;

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
				result = "Student Registered Sucessfully ! ";
				
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		

		return result;
	}

	@Override
	public Student signIn(String username, String password) throws StudentException {
		Student student =null;
		
		
		try(Connection conn=DBUtil.provideConnection()) {
			
	PreparedStatement ps = conn.prepareStatement("select * from student where username = ? AND password = ?");
	ps.setString(1, username);
		ps.setString(2, password);	 
		
	ResultSet rs =	ps.executeQuery()	;
			
	if(rs.next()) {
		
		
	int r =	rs.getInt("roll");
	String n =rs.getString("name");
	String u = rs.getString("username");
	String p = rs.getString("password");
	student=new Student(r,n,u,p);
	}
	else {
		throw new StudentException("Invalid username or password...");
	}
//			System.out.println(student);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new StudentException(e.getMessage());
		}
		
		
		
		
		return student;
	}

	@Override
	public String enrollStudentInCourse(int roll, int cid) throws StudentException, CourseException {
		String message= "Not enrolled....!";
		
		try (Connection conn =DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");	
		ps.setInt(1,roll);
		ResultSet rs =	ps.executeQuery();
			
		if(rs.next()) {
		PreparedStatement ps2 =	conn.prepareCall("select * from course where cid = ?");
		ps2.setInt(1, cid);	
	ResultSet rs2 =	ps.executeQuery();
			
	if(rs2.next()) {
		
	PreparedStatement ps3 = conn.prepareStatement("insert into student_course values(?,?)");
	ps3.setInt(1, cid);
	ps3.setInt(2,roll);
	
	int x= ps3.executeUpdate();
	
	if(x>0)
		message="student enrolled successfully !";
	else
		message ="student enrollment failed....!";
		
		
	}else {
		throw new CourseException("Invalid course ID...!");
	}
	
			
		}else {
			throw new StudentException("Student not found...! ");
		}
			
			
			
			
			
		} catch (SQLException e) {
			throw new CourseException();
		}
		
		
		
		
		return message;
	}

	@Override
	public String changeStudentPassword( String username,String password ,String newPassword) throws StudentException {
		String message = "Password not updated .";
		boolean flag=false;
		try(Connection conn = DBUtil.provideConnection()) {
		

			PreparedStatement ps1 =conn.prepareStatement("select * from student where password = ? ");
			ps1.setString(1,password);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				flag=true;
			}else {
				message="incorrect password..!";
			}
			if(flag==true) {
				PreparedStatement ps = conn.prepareStatement("update student set password = ?  where username = ?");
				ps.setString(1, newPassword);
				ps.setString(2,username);
						int x =ps.executeUpdate();
						if(x > 0)
							message="Password Updated .....";
						else
							message="Updation failed....";
			}
			
		} catch (SQLException e) {
			throw new StudentException(e.getMessage());
		}
		
		
		
		
		
		return message;
	}

}
