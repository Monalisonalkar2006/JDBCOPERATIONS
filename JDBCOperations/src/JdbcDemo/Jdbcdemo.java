package JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbcdemo {
  public static void main(String []args)
  {
	 
	  try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		PreparedStatement ps= con.prepareStatement("insert into student values(5,'golu',105,'mumbai')");
		ps.execute();
		System.out.println("data inserted");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
  }
}
