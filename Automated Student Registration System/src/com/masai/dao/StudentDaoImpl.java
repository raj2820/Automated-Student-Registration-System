package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.Utility.DBUtil;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.model.StudentStudentCourseDTO;
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
	public Student studentSignIn(String username, String password) throws StudentException {
		Student student =null;
		
		
		try(Connection conn=DBUtil.provideConnection()) {
			
	PreparedStatement ps = conn.prepareStatement("select * from student where username = ? AND password = ?"); //SQL query to validate username and password.
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
			
		PreparedStatement ps = conn.prepareStatement("select * from student where roll = ?");	//SQL query to validate roll.
		ps.setInt(1,roll);
		ResultSet rs =	ps.executeQuery();
			
		if(rs.next()) {
		PreparedStatement ps2 =	conn.prepareCall("select * from course where cid = ?"); //SQL query to validate cid.
		ps2.setInt(1, cid);	
	ResultSet rs2 =	ps.executeQuery();
			
	if(rs2.next()) {
		
	PreparedStatement ps3 = conn.prepareStatement("insert into student_course values(?,?)");//SQL query to insert values into the table student_course.
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

			PreparedStatement ps1 =conn.prepareStatement("select * from student where password = ? ");//SQL query to validate password.
			ps1.setString(1,password);
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				flag=true;  // Flag is needed because we cannot use excuteUpdate() inside ResultSet object variable;
			}else {
				message="incorrect password..!";
			}
			if(flag==true) {
				PreparedStatement ps = conn.prepareStatement("update student set password = ?  where username = ?");//SQL query to update password.
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

	@Override
	public List<StudentStudentCourseDTO> getAllCourseInfo() throws CourseException {
		 List<StudentStudentCourseDTO> dtos = new ArrayList<>();
		 
		 
		 try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement(" select c.cid,c.cname,c.fee ,c.duration,"
					+ " count(s.roll) Total_Students from course c INNER JOIN student s INNER JOIN student_course sc where "
					+ "s.roll=sc.roll AND c.cid=sc.cid group by c.cid;"); 
			 
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
			StudentStudentCourseDTO dto =new StudentStudentCourseDTO();
			dto.setCid(rs.getInt("cid"));
			dto.setCname(rs.getString("cname"));
			dto.setDuration(rs.getString("duration"));
			dto.setFee(rs.getInt("fee"));
			dto.setTotal_students(rs.getInt("total_students"));
			
			
			dtos.add(dto);
			}
			if(dtos.size()==0) {
				throw new CourseException("No student in that course");
			}
			 
			 
		} catch (SQLException e) {
			// TODO: handle exception
			throw new CourseException(e.getMessage());
		}
		 
		 
		 return dtos;
	}

}
