package com.masai.UseCases;

import java.util.List;
import java.util.Scanner;

import com.masai.Application.AutomatedStudentRegistrationSystem;
import com.masai.dao.AdminDao;
import com.masai.dao.AdminDaoImpl;
import com.masai.exception.CourseException;
import com.masai.model.AdminBatchDTO;
import com.masai.model.AdminStudentCourseDTO;

public class Adminoptions {
static int adminChoices() {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter 1 to see Students enrolled in a course ");
	System.out.println("Enter 2  to update fee of a course");
	System.out.println("Enter 3 to Delete a course");
	System.out.println("Enter 4 to Add a new course");
	System.out.println("Enter 5 to Create a new Batch");
	System.out.println("Enter 6 to Update batch size");
	System.out.println("Enter 7 to assign a batch to the student");
	System.out.println("Enter 8 to see Students assigned in all batches");
	System.out.println("Enter 9 to log out");
	int z=sc.nextInt();
	return z;
}

static void adminSwitches(int z,AdminDao dao) {
	Scanner sc =new Scanner(System.in);

	
	switch (z) {
	case 1: {
		
		GetStudentsInCourseForAdminUseCase.main(null);
		
		System.out.println("\n");
		
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		break;
	}
	case 2:{
	
		
		
		FeeUpdateUseCase.main(null);
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		
		break;
	}
	case 3 :{
		DeleteCourseUseCase.main(null);
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		break;
		
	}
	case 4:{
		AddCourseUseCase.main(null);
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		break;
	}
	case 5:{
	
		
		CreateNewBatchUseCase.main(null);
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		
		break;				
	}
	case 6:{
		UpdateBatchSizeUSeCase.main(null);
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		break;
	}
	case 7 :{
		
		AssignBatchToStudentUseCase.main(null);
		
		System.out.println("\n");
		System.out.println("===================================================");
		System.out.println("\n");
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		break;
		
	}
	case 8: {
		GetAllBatchDetails.main(null);
		
		System.out.println("\n");

		
		System.out.println("Enter 1 to go main menu");
		System.out.println("Enter 2 to log out");
		int g =sc.nextInt();
		switch(g) {
		case 1 :{
			AdminoptionContainer();
			break;
		}
		case 2:{
			System.out.println("Logged out sucessfully.....!");
			AutomatedStudentRegistrationSystem.main(null);
			return;
		}
		}
		AdminoptionContainer();
		break;
	}
	case 9 :{
		
		System.out.println("Logged out sucessfully.....!");
	AutomatedStudentRegistrationSystem.main(null);
		return;
		
	}

	
	}
	

}
static void	AdminoptionContainer(){
	AdminDao dao = new AdminDaoImpl();
				int z =	adminChoices();
	 			adminSwitches(z,dao);
	 			
	}
	public static void main(String[] args) {
	
		AdminoptionContainer();
	}
	


	
	

}
