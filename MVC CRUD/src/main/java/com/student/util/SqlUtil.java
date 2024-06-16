package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {
    
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "cdac";
    private static final String DB_NAME = "school";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    
    // Declare static variables
    private static Statement stmt = null;
    private static Connection con = null;
    
	/*
	 * mysql> CREATE TABLE student ( id INT NOT NULL PRIMARY KEY, name VARCHAR(20)
	 * NOT NULL, marks FLOAT NOT NULL, phone INT NOT NULL UNIQUE, gender VARCHAR(10)
	 * NOT NULL, city VARCHAR(50) NOT NULL); Query OK, 0 rows affected (2.09 sec)
	 * 
	 * mysql> INSERT INTO student (id, name, marks, phone, gender, city) VALUES ->
	 * (1, 'John Doe', 85.5, 1234567890, 'Male', 'Mumbai'), -> (2, 'Jane Smith',
	 * 92.0, 1987654321, 'Female', 'Pune'); Query OK, 2 rows affected (0.26 sec)
	 */

    // Static method to connect to the database
    public static void Connect() {
        try {
            Class.forName(DRIVER_CLASS);  // Load MySQL JDBC driver
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);  // Establish connection
            stmt = con.createStatement();  // Create statement object
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }

    // Insert method
    public static int insert(String qry) throws SQLException {
        checkConnection();
        int rs = -1;
        if (qry != null && !qry.isEmpty()) {
            rs = stmt.executeUpdate(qry);
        }
        return rs;
    }

    // Update method
    public static int update(String qry) throws SQLException {
        checkConnection();
        int rs = -1;
        if (qry != null && !qry.isEmpty()) {
            rs = stmt.executeUpdate(qry);
        }
        return rs;
    } 

    // Delete method
    public static int delete(String qry) throws SQLException {
        checkConnection();
        int rs = -1;
        if (qry != null && !qry.isEmpty()) {
            rs = stmt.executeUpdate(qry);
        }
        return rs;
    }
    
    // Fetch method
    public static ResultSet fetch(String qry) throws SQLException {
        checkConnection();
        ResultSet rs = null;
        if (qry != null && !qry.isEmpty()) {
            rs = stmt.executeQuery(qry);
        }
        return rs;
    }
    
    // Close resources
    public static void close() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    // Check if connection and statement are initialized
    private static void checkConnection() throws SQLException {
        if (con == null || stmt == null) {
            throw new SQLException("Database connection is not established. Call Connect() first.");
        }
    }
}
