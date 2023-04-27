package First_program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) {
		// load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/my_first_project";
			String user = "root";
			String password = "Arpit@123";
			
			// establish Connection
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connect");
			
			//create Statement
			Statement statement = conn.createStatement();
			 
			//Excute Query
			String insert= "insert into employee values(32, 'Arpit', 51153)";
			
			System.out.println(" Data inserted");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
