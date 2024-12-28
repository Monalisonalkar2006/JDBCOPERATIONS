package customertable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cdatadelete {
public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		PreparedStatement ps=con.prepareStatement("delete from customer where c_id=1");
		ps.execute();
		System.out.println("Delete data");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
