package AppCrudOperation;
	

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class CrudOperation {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        while (true) {
	            System.out.println(" CRUD Operations");
	            System.out.println("1. Insert Data");
	            System.out.println("2. Read Data");
	            System.out.println("3. Update Data");
	            System.out.println("4. Delete Data");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = sc.nextInt();
	            
	            switch (choice) {
	                case 1:
	                    
	                    insertEmployee(sc);
	                    break;
	                case 2:
	                    
	                    readEmployee(sc);
	                    break;
	                case 3:
	                    
	                    updateEmployee(sc);
	                    break;
	                case 4:
	                   
	                    deleteEmployee(sc);
	                    break;
	                case 5:{
	                    System.out.println("Thank you visit again!");
	                    break;
	                }
	            	default:
	        			System.out.println("Invalid Input");
	        			
	        			 {
	        			break;
	        		
	            }
	            }
	        }
	    }
	        
	    

	   
	    public static void insertEmployee(Scanner sc) {
	        System.out.println(" Insert Employee");
	        System.out.print("Enter Employee ID: ");
	        int id = sc.nextInt();
	        sc.nextLine(); 
	        System.out.print("Enter Employee Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter Employee Address: ");
	        String address = sc.nextLine();
	        System.out.print("Enter Employee Salary: ");
	        int salary = sc.nextInt();

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement("INSERT INTO emp (id, name, address, salary) VALUES (?, ?, ?, ?)")) {
	            ps.setInt(1, id);
	            ps.setString(2, name);
	            ps.setString(3, address);
	            ps.setInt(4, salary);
	            ps.executeUpdate();
	            System.out.println("Employee data inserted successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static void readEmployee(Scanner sc) {
	        System.out.println(" Read Employee");
	        System.out.print("Enter Employee ID to view: ");
	        int id = sc.nextInt();

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement("SELECT * FROM emp WHERE id = ?")) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                System.out.println("Employee ID: " + rs.getInt("id"));
	                System.out.println("Employee Name: " + rs.getString("name"));
	                System.out.println("Employee Address: " + rs.getString("address"));
	                System.out.println("Employee Salary: " + rs.getInt("salary"));
	            } else {
	                System.out.println("Employee not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    
	    public static void updateEmployee(Scanner sc) {
	        System.out.println(" Update Employee ");
	        System.out.print("Enter Employee ID to update: ");
	        int id = sc.nextInt();
	        sc.nextLine(); 
	        System.out.print("Enter New Employee Name: ");
	        String name = sc.nextLine();
	        System.out.print("Enter New Employee Address: ");
	        String address = sc.nextLine();
	        System.out.print("Enter New Employee Salary: ");
	        int salary = sc.nextInt();

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement("UPDATE emp SET name = ?, address = ?, salary = ? WHERE id = ?")) {
	            ps.setString(1, name);
	            ps.setString(2, address);
	            ps.setInt(3, salary);
	            ps.setInt(4, id);
	            int rowsUpdated = ps.executeUpdate();
	            if (rowsUpdated != 0) {
	                System.out.println("Employee data updated successfully.");
	            } else {
	                System.out.println("Employee not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	   
	    public static void deleteEmployee(Scanner sc) {
	        System.out.println(" Delete Employee");
	        System.out.print("Enter Employee ID to delete: ");
	        int id = sc.nextInt();

	        try (Connection con = getConnection();
	             PreparedStatement ps = con.prepareStatement("DELETE FROM emp WHERE id = ?")) {
	            ps.setInt(1, id);
	            int rowsDeleted = ps.executeUpdate();
	            if (rowsDeleted > 0) {
	                System.out.println("Employee deleted successfully.");
	            } else {
	                System.out.println("Employee not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	   
	    public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mona_jdbc", "root", "Tiger");
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	}


