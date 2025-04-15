package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnectTest {

    public static void main(String[] args) {
        // Change these details as per your setup
        String jdbcURL = "jdbc:mysql://localhost:3306/project"; // testdb is your database name
        String username = "root";
        String password = "P@ssw0rd"; // or "root" if you set one

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
          
            //Insert Query
            String query= "INSERT INTO Employee (empcode, empname, empage, esalary ) VALUES (?, ?, ?,?)";
            PreparedStatement pst = connection.prepareStatement(query);
            
            //Sample Data
            Object[][] data = {
            		{101, "Jenny", 25, 10000},
            		{102, "Jacky", 30, 20000},
                    {103, "Joe", 20, 40000},
                    {104, "John", 40, 80000},
                    {105, "Shameer", 25, 90000}
                };
            
            for(Object[] row:data) {
            	pst.setInt(1, (Integer) row[0]);
            	pst.setString(2, (String) row[1]);
            	pst.setInt(3, (Integer) row[2]);
            	pst.setInt(4, (Integer) row[3]);
            	pst.executeUpdate();
            }
            
            System.out.println("Data inserted successfully");
            connection.close();
         
            
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
            
    }
}
