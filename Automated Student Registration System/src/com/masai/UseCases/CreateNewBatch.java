package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class CreateNewBatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter course-id ");
		int cid = sc.nextInt();
		
		System.out.println("Enter batch name");
		String bname= sc.next();
		
		System.out.println("Enter batch size");
		
		int size = sc.nextInt();
		
		
		
		
		AdminDao dao = new AdminDaoImpl();
		
		
		
		try {
			
			String res = dao.createBatch(bname, cid, size);
			System.out.println(res);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
