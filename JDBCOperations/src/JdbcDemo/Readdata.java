package JdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Readdata {
public static void main(String[] args) {

	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc","root","Tiger");
		
		Statement st= con.createStatement();
		
		ResultSet rs=st.executeQuery("select * from student");
		
		while(rs.next())
		{
			System.out.println("Id:-"+rs.getInt(1)+"  name:- "+rs.getString(2)+" Rollno:- "+rs.getInt(3)+" Address:- "+rs.getString(4));
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
		
	}

}
}
