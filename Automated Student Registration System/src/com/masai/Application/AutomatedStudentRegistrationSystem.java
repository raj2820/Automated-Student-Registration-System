package com.masai.Application;


import java.util.Scanner;

import com.masai.UseCases.AdminLogin;
import com.masai.UseCases.LogInStudentUseCase;
import com.masai.UseCases.RegisterAdmin;
import com.masai.UseCases.RegisterStudentUseCase;


public class AutomatedStudentRegistrationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc =new Scanner(System.in);
System.out.println("\n");
System.out.println("**********************************Home Page**************************************");
System.out.println("\n");
System.out.println("Enter 1 for Admin login");
System.out.println("Enter 2 for register as a Admin");
System.out.println("Enter 3 to for student login");
	System.out.println("Enter 4 to register as student");	
		
		int x =sc.nextInt();
		
		switch (x) {
		case 1: {

			AdminLogin.main(args);
			break;
		}
		case 2:{
			RegisterAdmin.main(args);
			break;
		}
		case 3:{

			LogInStudentUseCase.main(args);
			break;
			
		}
		case 4:{

			RegisterStudentUseCase.main(args);
			break;
		}
		}
		
	}

}
