package Inputfromuser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Inputfromuser {
public static void main(String[] args) {
	
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter the id ");
	int id=sc.nextInt();
	
	System.out.println("Enter the name");
	String name=sc.next();
	
	System.out.println("Enter the Address");
	String address=sc.next();
	
	System.out.println("Enter the salary");
	int sal=sc.nextInt();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setInt(4, sal);
		ps.execute();
		System.out.println("data inserted");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
