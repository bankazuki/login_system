package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLtest {
	public static void main(String[] args) {
        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "mysqlpass123?");
        	PreparedStatement stmt = con.prepareStatement("SELECT * FROM users");
        	ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println(rs.getString("username"));
                System.out.println(rs.getInt("password"));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
	}

}
