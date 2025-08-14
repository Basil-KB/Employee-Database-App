package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root"; // change if needed
    private static final String PASSWORD = "Basil@2024"; // change if needed

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	//1.load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
