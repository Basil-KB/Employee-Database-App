package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	public void addEmployee(String name, String position, double salary) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("✅ Employee added.");
        }
    }
	  public void viewEmployees() throws SQLException, ClassNotFoundException {
	        String sql = "SELECT * FROM employees";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                System.out.printf("%d | %s | %s | %.2f%n",
	                        rs.getInt("id"),
	                        rs.getString("name"),
	                        rs.getString("position"),
	                        rs.getDouble("salary"));
	            }
	        }
	    }
	  public void updateEmployee(int id, String position, double salary) throws SQLException, ClassNotFoundException {
	        String sql = "UPDATE employees SET position=?, salary=? WHERE id=?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, position);
	            stmt.setDouble(2, salary);
	            stmt.setInt(3, id);
	            int rows = stmt.executeUpdate();
	            System.out.println(rows > 0 ? "✅ Employee updated." : "⚠ No record found.");
	        }
	    }
	  public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
	        String sql = "DELETE FROM employees WHERE id=?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            int rows = stmt.executeUpdate();
	            System.out.println(rows > 0 ? "🗑 Employee deleted." : "⚠ No record found.");
	        }
	    }
}
