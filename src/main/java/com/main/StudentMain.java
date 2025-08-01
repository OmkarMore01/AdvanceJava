package com.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.dao.StudentDao;
import com.model.Student;

public class StudentMain {
	
public static void main(String[] args) throws SQLException {
	Scanner sc=new Scanner(System.in);
	
//	Student st=new Student();
//	System.out.println("Enter Student Id");
//	st.setSid(sc.nextInt());
//	
//	System.out.println("Enter Student Name");
//	st.setSname(sc.next());
//	
//	System.out.println("Enter Student Age");
//	st.setAge(sc.nextInt());
//	System.out.println(st);
//	
	StudentDao sd=new StudentDao();

//	int row=sd.insertStudent(st);
//	System.out.println("Record inserted "+row+" row affected");
//	int row=sd.updateStudent(st);
//	System.out.println("Record Updated "+row+" row affected");
//	int row=sd.deleteStudent(st);
//	System.out.println("Record Deleted "+row+" row affected");
	sd.getAllstudent();
	
}
}
