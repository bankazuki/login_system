package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginProcess {
	public boolean execute(User user) {
		String name = user.getName();
		String password = user.getPassword();
		
		return checkUser(name, password);
    }
	
	private static boolean checkUser(String name, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "mysqlpass123?");
        	PreparedStatement pstmt = con.prepareStatement("SELECT userName FROM users WHERE userName = '" + name + "' AND userPassword = '" + password + "'");
        	ResultSet rs = pstmt.executeQuery();

        	rs.next();
        	String name_result = rs.getString("userName");
        	//System.out.println(name_result);
            
            return name_result.equals(name);
        } catch (SQLException | ClassNotFoundException e) {
        	System.out.println(e);
            return false;
        } catch(Exception e) {
        	System.out.println(e);
            return false;
        }
	}
}
