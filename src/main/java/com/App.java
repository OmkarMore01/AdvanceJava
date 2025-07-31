package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
    	try
    	{
    		Scanner sc=new Scanner(System.in);
    		//driver class loading
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		System.out.println("Driver Loaded Successfulyy.. ");
    		
    		//Connection Establishment
    		String url="jdbc:mysql://localhost:3306/samplejdbc";
    		String user="root";
    		String pass="8284";
    		
    		Connection con=DriverManager.getConnection(url,user,pass);
    		System.out.println("connection Established..");
    		
    	//	createTable(con);
    	//	insertByStatement(con);
    	//insertByPreparedStatement(con);
    		//updateStudent(sc, con);
    		
    		//deletestudentById(sc, con);
    	//	deleteAllStudents(con);
    	//getAllRecords(con);
    		//getStudById(sc, con);
    	//	batchProcessing(con);
    		
    	}catch (Exception e) {
			System.out.println(e);
		}
       
    }

	public static void batchProcessing(Connection con) throws SQLException {
		String insertquery="insert into stud values(2,'Priyanka',21)";
		Statement st=con.createStatement();
		st.addBatch(insertquery);
		String insertquery2="insert into stud values(1,'sai',22)";
		st.addBatch(insertquery2);
		st.executeBatch();
		System.out.println("students inserted successfulyy..");
	}

	public static void getStudById(Scanner sc, Connection con) throws SQLException {
		String sql="select *from stud where sid=?";
		PreparedStatement st=con.prepareStatement(sql);
		System.out.println("Enter id to display data");
		st.setInt(1, sc.nextInt());
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			System.out.println("sid==>"+rs.getInt("sid")+" Sname==>"+rs.getString("sname")+" age==> "+rs.getInt("age"));
		}
	}

	public static void getAllRecords(Connection con) throws SQLException {
		String sql="select *from stud";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("sid==>"+rs.getInt("sid")+" Sname==>"+rs.getString("sname")+" age==> "+rs.getInt("age"));
		}
	}

	public static void deleteAllStudents(Connection con) throws SQLException {
		String delQuery="delete from stud";
		Statement st=con.createStatement();
		st.executeUpdate(delQuery);
		System.out.println("All students deleted successfully..");
	}

	public static void deletestudentById(Scanner sc, Connection con) throws SQLException {
		String delQuery="delete from stud where sid=?";
		PreparedStatement pst=con.prepareStatement(delQuery);
		System.out.println("Enter An id of student ?");
		pst.setInt(1, sc.nextInt());
		pst.executeUpdate();
		System.out.println("Student Deleted Successfully....");
	}

	public static void updateStudent(Scanner sc, Connection con) throws SQLException {
		String updquery="update  stud set sname=? where sid=?";
		PreparedStatement pst=con.prepareStatement(updquery);
		System.out.println("Enter An id of student ?");
		pst.setInt(2, sc.nextInt());
		System.out.println("Enter New Name of student ?");
		pst.setString(1, sc.next());
		
		pst.executeUpdate();
		System.out.println("Student Updated Successfully....");
		
	}

	public static void insertByPreparedStatement(Connection con) throws SQLException {
		String insertquery="insert into stud values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(insertquery);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Id:-");
		int sid=sc.nextInt();
		System.out.println("Enter Student Name:-");
		String name=sc.next();
		System.out.println("Enter Student Age:-");
		int age=sc.nextInt();
		
		pst.setInt(1, sid);
		pst.setString(2, name);
		pst.setInt(3, age);
		
		pst.executeUpdate();
		System.out.println("Record inserted successfully.");
	}

	public static void insertByStatement(Connection con) throws SQLException {
		String insertquery="insert into stud values(2,'Priyanka',21)";
		Statement st=con.createStatement();
		st.executeUpdate(insertquery);
		System.out.println("Record inserted successfully.");
	}

	public static void createTable(Connection con) throws SQLException {
		String query="create table stud(sid int primary key,sname varchar(100),age int)";
		Statement st=con.createStatement();
		st.executeUpdate(query);
		System.out.println("Table created Successfully..");
	}
}
