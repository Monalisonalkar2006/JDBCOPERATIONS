package Jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		
		PreparedStatement ps=con.prepareStatement("insert into emp values (2,'sona','rajuri',2599)");
		ps.execute();
		System.out.println("data Inserted");
	} catch (ClassNotFoundException | SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
