package com.masai.UseCases;


import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;


public class AssignBatchToStudentUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter course id");
		int cid =sc.nextInt();
		
		System.out.println("Enter Lower limit date");
		String date1=sc.next();
		
		System.out.println("Enter Upper limit date");
		String date2 =sc.next();
		
		System.out.println("Enter batch name ");
		String batchname= sc.next();
		
		AdminDao dao =new AdminDaoImpl();
		
		
		try {
			String res = dao.assignStudentsToBatch(cid, date1, date2, batchname);
			System.out.println(res);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
		
		
		
		
	}

}
