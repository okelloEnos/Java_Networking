package okelloSoftwarez.Database;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBasics {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load the JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver has Started ...");

        // Connect the Database
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/javaBook","root","");
        System.out.println("Database Connected Successfully");

        // Create statement
        Statement statement = connection.createStatement();
        // Adding records to the database
//        statement.executeUpdate("INSERT INTO Student VALUES ('115','Bijuma','Jamal','Okello','Java 1','C')");

        //Execute Statement
//        ResultSet resultSet = statement.executeQuery("SELECT fName,mName,lName,courseName,Grade FROM Student WHERE courseName "+" = 'CALCULUS'");
        String query = "SELECT fName, mName, lName, courseName, Grade FROM Student WHERE courseName = 'CALCULUS' ";
        ResultSet resultSet = statement.executeQuery(query);

        //Iterate through the results and print student names
        while (resultSet.next()){
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5));
        }
        connection.close();
    }
}
