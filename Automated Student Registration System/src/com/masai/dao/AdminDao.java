package com.masai.dao;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.CourseException;
import com.masai.model.Admin;
import com.masai.model.AdminStudentCourseDTO;

public interface AdminDao {
	
	
	public String registerAdmin(Admin admin) throws AdminException ;
	public Admin adminSignin(String username , String password) throws AdminException;
	public List<AdminStudentCourseDTO> getAllStudentsByCourseName(String cname)throws CourseException;
	public String updateFee(int cid , int fee) throws CourseException;
	public String deleteCourse(int cid) throws CourseException;
	public String addCourse(String cname,int fee,String duration);
	public String createBatch(String batchname , int cid , int size) throws CourseException;
	public String updateBatchSize(String batchname,int size) throws CourseException;
	
	
	
}
