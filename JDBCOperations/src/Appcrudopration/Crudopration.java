package Appcrudopration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Jdbc2.InsertEmployee;

public class Crudopration {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("press 1. Enter to Employee Database.");
	System.out.println("press 2. Exit.");
	int i=sc.nextInt();
	
	while(true)
	{
		if(i==1)
		{
			System.out.println("1.Insert Data");
			System.out.println("2. Read Data");
			System.out.println("3.Update Data");
			System.out.println("4. Delete Data");
			
			System.out.println("Enter your Choice");
			int ip1=sc.nextInt();
			
			switch (ip1) {
			case 1:{
				
				System.out.println("Enter Employee Id:-");
				int id=sc.nextInt();
				
				System.out.println("Enter Employee Name ");
				String name=sc.next();
				
				System.out.println("Enter Employee Address");
				String address=sc.next();
				
				System.out.println("Enter Employee sal");
				int sal=sc.nextInt();
				insertemp(id,name,address,sal);
				
				break;
				
			}
			case 3:
			{
				System.out.println("enter a employee id:-");
				int id=sc.nextInt();
				
				System.out.println("enter a employee name:-");
				int name=sc.nextInt();
				
				
			}
		
		
				
			default:
			System.out.println("Invalid Input");
			
			}
		}
		else {
			break;
		}
	}
}


public static void insertemp(int id,String name,String address,int sal)
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setInt(4, sal);
		ps.execute();
		System.out.println("data inserted successfully");
	
		System.out.println("Data Inserted");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public static void Deletedata()
	{
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
			
		}
	
}


