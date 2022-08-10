package SDBMS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImpl implements StudentManagementSystem{

	Scanner sc= new Scanner(System.in);
	LinkedHashMap<Integer,Student> db= new LinkedHashMap<Integer, Student>();

	@Override
	public void addStudent() {
		System.out.println("Enter id, name,age and marks");
		int id=sc.nextInt();
		String name=sc.next();
		int age= sc.nextInt();
		Double marks= sc.nextDouble();

		Student s1=new Student(id, name, age, marks);
		db.put(id, s1);

		// db.put(s1.getId(), new Student(id, name, age, marks));

		System.out.println("Student Data Recorded.....!\n");
	}

	@Override
	public void removeStudent() {
		System.out.println("Enter Student Id :");
		int id=sc.nextInt();

		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student data Removed..!\n");
		}else {
			try {
				throw new StudentNotFoundException("Student Data Not Fount..!\n");
			}
			catch(StudentNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void removeAllStudents() {
		db.clear();
		System.out.println("All Records Are Deleted\n");
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id :");
		int id=sc.nextInt();
		if(db.containsKey(id)) {
			System.out.println("\nStudent Info :"+db.get(id));
		}
		else {
			try {
				throw new StudentNotFoundException("Student Not Found..!\n");
			}
			catch(StudentNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void displayAllStudents() {
		Set<Integer> s= db.keySet();
		for(Integer id : s) {
			System.out.println("Student Info\n"+db.get(id)+"\n");
		}
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id :");
		int id=sc.nextInt();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks\n");
			System.out.println("Enter Choice :");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Student Age :");
				int age=sc.nextInt();
				std.setAge(age);
				System.out.println("Age Is Updated\n");
				break;
			case 2:
				System.out.println("Enter Student Name :");
				String name=sc.next();
				std.setName(name);
				System.out.println("Name Is Updated\n");
				break;
			case 3:
				System.out.println("Enter Student Marks :");
				double marks=sc.nextInt();
				std.setMarks(marks);
				System.out.println("Marks Is Updated\n");
				break;
			default :
				System.err.println("Invalid Choice\n");
			}
			System.out.println("Student Data Updated Successfully");
		}else {
			try {
				throw new StudentNotFoundException("Student Id Not Fount");
			}
			catch(StudentNotFoundException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@Override
	public void countStudents() {
		System.out.println("Count of Student :"+db.size()+"\n");
	}

	private static void display(List<Student> l) {
		for(Student s1:l) {
			System.out.println(s1);
		}
	}
	@Override
	public void sortStudents() {
		ArrayList<Student> al= new ArrayList<Student>();
		Set<Integer> s=db.keySet();
		for(Integer i:s) {
			al.add(db.get(i));
		}
		System.out.println("\n1:Sort By Id\n2:Sort By Name\n3:Sort By Age\n4:Sort By Marks\n");
		System.out.println("Enter Choice ");
		int choice=sc.nextInt();

		switch(choice) {
		case 1:
			System.out.println("Sort By Student Id");
			Collections.sort(al,new SortByStudentId());
			display(al);
//			for(Student std:al) {
//				System.out.println(std);
//			}
			break;
		case 2:
			System.out.println("Sort By Student Name");
			Collections.sort(al,new SortByStudentName());
			display(al);
//			for(Student std:al) {
//				System.out.println(std);
//			}
			break;
		case 3:
			System.out.println("Sort By Student Age");
			Collections.sort(al,new SortByStudentAge());
			display(al);
//			for(Student std:al) {
//				System.out.println(std);
//			}
			break;
		case 4:
			System.out.println("Sort By Student Marks");
			Collections.sort(al,new SortByStudentMarks());
			display(al);
//			for(Student std:al) {
//				System.out.println(std);
//			}
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
}
