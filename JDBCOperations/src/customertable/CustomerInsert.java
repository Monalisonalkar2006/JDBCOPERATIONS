package customertable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerInsert {
public static void main(String[] args) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		PreparedStatement ps= con.prepareStatement("insert into customer values(3,'sona','rani',23447,8574982345)");
		ps.execute();
		System.out.println("data inserted");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
}
}
