package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class UpdateBatchSizeUSeCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter batch name");
		String bname = sc.next();
		System.out.println(" Enter size");
		int size = sc.nextInt();
		
		
		
		AdminDao dao = new AdminDaoImpl();
		
		try {
	
			String res = dao.updateBatchSize(bname, size);
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}

}
