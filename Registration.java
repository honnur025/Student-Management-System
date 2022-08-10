package SDBMS;

import java.util.Scanner;

public class Registration {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		System.out.println("Welcome to SDBMS\n --------------");

		StudentManagementSystem sms= new StudentManagementSystemImpl();

		while(true) {
			System.out.println("1:ADD STUDENT\n2:REMOVE STUDENT\n3:REMOVE ALL STUDENTS");
			System.out.println("4:DISPLAY STUDENT\n5:DISPLAY ALL STUDENTS\n6:UPDATE STUDENT");
			System.out.println("7:COUNT STUDENT\n8:SORT STUDENTS\n9:Exit\n");

			System.out.println("Enter Your Choice :");
			int choice= sc.nextInt();

			switch (choice) {

			case 1: 
				sms.addStudent();
				break;
			case 2:
				sms.removeStudent();
				break;
			case 3:
				sms.removeAllStudents();
				break;
			case 4:
				sms.displayStudent();
				break;
			case 5:
				sms.displayAllStudents();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudents();
				break;
			case 8 :
				sms.sortStudents();
				break;
			case 9:
				System.out.println("Thank You...!");
				System.exit(0);
			default :
				System.err.println("Invalid Choice\n");
			}
		}
	}
}
