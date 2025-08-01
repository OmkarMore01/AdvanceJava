package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Student;

//DAO class=> Data Access Object ==> All Database Connectivity writes here..
public class StudentDao {

	public Connection con;
	
	public  StudentDao() {
		
		connectDB();
	}
	
	public void connectDB()
	{
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded Successfully..");
		String url="jdbc:mysql://localhost:3306/samplejdbc";
		String user="root";
		String pass="8284";
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connection Established..");		
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int insertStudent(Student st) throws SQLException
	{
		String sql="insert into stud values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, st.getSid());
		ps.setString(2, st.getSname());
		ps.setInt(3, st.getAge());
		return ps.executeUpdate();
		
	}
	
	
	public int updateStudent(Student st) throws SQLException
	{
		String sql=" update stud set sname=?,age=? where sid=?;";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, st.getSname());
		ps.setInt(2, st.getAge());
		ps.setInt(3, st.getSid());
		
		return ps.executeUpdate();
		
	}
	
	
	public int deleteStudent(Student st) throws SQLException
	{
		String sql="delete from stud where sid=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, st.getSid());
		return ps.executeUpdate();
		
	}
	
	public void getAllstudent() throws SQLException
	{
		String sql="select * from stud ";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("Sid=>"+rs.getInt(1)+" Sname=>"+rs.getString(2)+" Age=>"+rs.getInt(3));
		}
	}
	
}
