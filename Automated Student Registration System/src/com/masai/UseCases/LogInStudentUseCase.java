package com.masai.UseCases;
import java.util.Scanner;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;

public class LogInStudentUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);

		System.out.println("Enter Student username :");
		String username= sc.next();
	
		System.out.println("Enter Password :");
		String password= sc.next();
		
		StudentDao dao=	new StudentDaoImpl();
		try {
			Student student = dao.signIn(username, password);
			System.out.println("Welcome "+student.getName().toUpperCase());
			
			
			System.out.println("Enter 1 for course enrollment ");
			
			System.out.println("Enter 2 for updating password ");
			int x=sc.nextInt();
			
			
			if(x == 1) {
				System.out.println("Enter Roll : ");
				int roll= sc.nextInt();
					
						System.out.println("Enter Course Id : ");
						int cid= sc.nextInt();
						
						try {
							String result = dao.enrollStudentInCourse(roll,cid);
						System.out.println(result);
						} catch (StudentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CourseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}else if(x == 2) {
	System.out.println("Enter current password");
				
				String pass=sc.next();
				System.out.println("Enter your new password");
				
				String newPassword=sc.next();
				System.out.println("re-enter new password");
				String newPassword2=sc.next();
				if(!newPassword.equals(newPassword2)) {
					System.out.println("Password does not match...!");
					return;
				}
				if(newPassword.equals(password)) {
				
					System.out.println("New password cannot be your current password...");
					return;
				}
				String result =dao.changeStudentPassword(username,pass,newPassword2);
				System.out.println(result);
			}
				
		} catch (StudentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.println(e.getMessage());
		}
	}

}
