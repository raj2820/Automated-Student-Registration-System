package com.masai.UseCases;
import java.util.List;
import java.util.Scanner;
import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImpl;
import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentStudentCourseDTO;

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
			Student student = dao.studentSignIn(username, password); //login method
			System.out.println("Welcome "+student.getName().toUpperCase());
			
			//Options to choose enrollment method and updating password method.
			System.out.println("Enter 1 for course enrollment ");
			
			System.out.println("Enter 2 for updating password ");
			System.out.println("Enter 3 to see all courses info");
			System.out.println("Enter 4 to log out.....");
			int x=sc.nextInt();
			
			switch (x) {
			case 1: {
				System.out.println("Enter Roll : ");
				int roll=sc.nextInt();
					System.out.println("Enter Course Id : ");
					int cid= sc.nextInt();

					System.out.println("Enter date (yyyymmdd) no extra characters");
					String date = sc.next();
					
				
					try {
						String result = dao.enrollStudentInCourse(roll,cid,date);
					System.out.println(result);
					} catch (StudentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (CourseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						break;
				
			}
			case 2:{
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
				String result =dao.changeStudentPassword(username,pass,newPassword2); //update password method.
				System.out.println(result);
				break;
			}case 3:{

				try {
					 List<StudentStudentCourseDTO> dtos = dao.getAllCourseInfo();
					 dtos.forEach(s->System.out.println(s));
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				break;
				
			}case 4:{
				
				
				System.out.println("Logged out sucessfully......");
				return;
			}
			
			}
			
				
		} catch (StudentException e) {
		
		System.out.println(e.getMessage());
		}
	}

}
