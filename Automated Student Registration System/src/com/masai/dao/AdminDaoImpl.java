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
import com.masai.model.AdminBatchDTO;
import com.masai.model.AdminStudentCourseDTO;
import com.masai.model.Course;
import com.mysql.cj.xdevapi.Result;

public class AdminDaoImpl implements AdminDao{

	@Override
	public List<AdminStudentCourseDTO> getAllStudentsByCourseName(String cname) throws CourseException {
		List<AdminStudentCourseDTO> dtos = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
PreparedStatement ps = conn.prepareStatement("select s.roll,s.name,s.username"
		+ ",c.cname,c.duration from student s INNER JOIN course c INNER JOIN student_cours sc ON s.roll=sc.roll "
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
			throw new CourseException(e.getMessage());
			
		}
		

		
		return dtos;
	}

	@Override
	public String registerAdmin(Admin admin) throws AdminException {
		String message ="Not registered";
		
		
		
		try (Connection conn= DBUtil.provideConnection()){
			
			
			PreparedStatement ps1=conn.prepareStatement("select * from admin where username = ?");
			ps1.setString(1,admin.getUsername());
			
			ResultSet rs =ps1.executeQuery();
			
			if(rs.next()) {
				System.out.println("username already registered");
			
			throw new AdminException("Username already registered");
			
			}
			else {

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

	@Override
	public String updateFee(int cid , int fee) throws CourseException {
		String message = "Fees not updated......";
		
		try(Connection conn = DBUtil.provideConnection()) {
		
			PreparedStatement ps =conn.prepareStatement("update course set fee = ? where cid = ? ");
			ps.setInt(1, fee);
			ps.setInt(2,cid);
			
			int x =ps.executeUpdate();
			if(x > 0) 
				message = "Fees of the course updated to "  + fee ;	
			else
				message = "Failed to update fees for the course";
		}
		
		catch (SQLException e) {
		e.printStackTrace();
		throw new CourseException(e.getMessage());
		}
		

		return message;
	}

	@Override
	public String deleteCourse(int cid) throws CourseException {
	String message = "Course not deleted";
	
	try(Connection conn = DBUtil.provideConnection()) {
		
		PreparedStatement ps = conn.prepareStatement("DELETE from course WHERE cid = ? ");
		
		ps.setInt(1, cid);
		
		int x =ps.executeUpdate();
		
		if(x > 0) 
			message = "Course"+ cid +" deleted from the table" ;
		else
			message="Course not deleted";
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		throw new CourseException(e.getMessage());
	}
	
	return message;
	
	}

	@Override
	public String addCourse(String cname,int fee,String duration) {
		String message ="Course not added";
		
		try(Connection conn =DBUtil.provideConnection()) {
			
			PreparedStatement ps =conn.prepareStatement("insert into course (cname,fee,duration) values(?,?,?)");
			ps.setString(1,cname);
			ps.setInt(2, fee);
			ps.setString(3,duration);
			
			int x =ps.executeUpdate();
			if(x > 0)
				message ="Course added sucessfully";
			else
				message = "Course not added";
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		

		return message;
	}

	@Override
	public String createBatch(String batchname, int cid,  int size) throws CourseException {
		String message = "Batch not created";
		
		try(Connection conn =DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into batch(batchname,cid,seats) values(?,?,?)");
			ps.setString(1,batchname);
			ps.setInt(2, cid);
			ps.setInt(3,size);
			
			int x = ps.executeUpdate(); 
			
			if( x >0)
				message= "Batch created";
			else
				message="Batch creation failed";
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		
		
		
		
		
		
		
		
		return message;
	}

	@Override
	public String updateBatchSize(String batchname , int seats) throws CourseException {
		String message = "Batch Size updated";
			try(Connection conn =DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("update batch set seats = ? where batchname = ?");
			ps.setInt(1,seats);	
		ps.setString(2,batchname);
		int x =ps.executeUpdate();
		if(x > 0)
			message = "Size updated";
		else
			message = "Size not updated";		
		} catch (SQLException e) {

			e.printStackTrace();
			throw new CourseException(e.getMessage());
		}
		return message;
	}

	@Override
	public String assignStudentsToBatch(int cid, String date1, String date2,String batchname) throws CourseException {
	String message = "Student not assigned";
	
	try(Connection conn =DBUtil.provideConnection()) {
		
		
		PreparedStatement ps2 =conn.prepareStatement("select bid from batch where batchname = ? ");
		ps2.setString(1,batchname);
		
		ResultSet rs1 =ps2.executeQuery();
		if(rs1.next()) {
			
		
			
			PreparedStatement ps1 =conn.prepareStatement("select roll  from student_cours where cid = ? AND enrollmentDate >= ? AND enrollmentDate <= ?");
			ps1.setInt(1, cid);
			ps1.setString(2,date1);
			ps1.setString(3,date2);
			ResultSet rs =ps1.executeQuery();
			List<Integer> li1=new ArrayList<>();
			while(rs.next()) {
				
				List<Integer> li=new ArrayList<>();
				li.add(rs.getInt("roll"));
				li1.addAll(li);
			}
	int k=	li1.size();
		for(int i=0;i<k;i++) {
			PreparedStatement ps =conn.prepareStatement(" insert into student_batch (roll,cid,bid) values (?,?,?)");
			ps.setInt(1,li1.get(i));
			ps.setInt(2, cid);
			ps.setInt(3, rs1.getInt("bid"));
			
		
			
				
				
				
				int x= ps.executeUpdate();
				if(x > 0) {
				message = "Student assigned to the batch ";
				
			}else
			message = "Student not assigned";

		}
			
		}
		
		
	

		
		
		


	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new CourseException();
	}
	
	
	
	return message;
	}

	@Override
	public List<AdminBatchDTO> getStudentsInAllBatches()  {
		List<AdminBatchDTO> dtos = new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()) {
		PreparedStatement ps =conn.prepareStatement("select s.name,s.roll,c.cid,c.cname,b.batchname,b.seats,b.bid FROM student s INNER JOIN course c INNER JOIN batch b INNER JOIN student_batch sc where sc.cid = c.cid AND s.roll=sc.roll AND b.bid=sc.bid");	
			
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			AdminBatchDTO dto =new AdminBatchDTO();
			dto.setSname(rs.getString("name"));
			dto.setRoll(rs.getInt("roll"));
dto.setCid(rs.getInt("cid"));
dto.setCname(rs.getString("cname"));
dto.setBatchname(rs.getString("batchname"));
dto.setSeats(rs.getInt("seats"));
dto.setBid(rs.getInt("bid"));

dtos.add(dto);
		}
//		if(dtos.size()==0) {
//			throw new CourseException("No student in that course");
//		}
		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return dtos;
	}

	
}
