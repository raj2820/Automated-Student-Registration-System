package com.masai.UseCases;

import java.util.Scanner;

import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;

public class FeeUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter course id");
		int cid=sc.nextInt();
		
		System.out.println("Enter fee to be updated");
		int fee = sc.nextInt();
		AdminDao dao =new AdminDaoImpl();
		
		
		try {
		String res = dao.updateFee(cid, fee);
		System.out.println(res);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
