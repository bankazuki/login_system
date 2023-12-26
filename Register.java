package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/register-form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("text/html");
			
			String name = request.getParameter("userName");
	        String password = request.getParameter("userPassword");
	        String number = request.getParameter("employeeNumber");
	        
	        String message = null;
	        
	        if(name == null || name.trim().isEmpty()|| password == null || password.trim().isEmpty()|| number == null|| number.trim().isEmpty()) {
	        	message = "ユーザー名・パスワード・社員番号の全てを入力してください。";
	        	request.setAttribute("message", message);
	            request.getRequestDispatcher("WEB-INF/register-form.jsp").forward(request, response);
	        } else {
	        	if(checkName(name)) {
	        		message = "このユーザー名は既に使用されています。違う名前を入力してください。";
		        	request.setAttribute("message", message);
		            request.getRequestDispatcher("WEB-INF/register-form.jsp").forward(request, response);
	        	} else {
	        		int number_int = Integer.parseInt(number);
	        		
	        		Class.forName("com.mysql.cj.jdbc.Driver");
	            	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "mysqlpass123?");
		        	Statement stmt = con.createStatement();
		        	stmt.executeUpdate("insert into users values ('" + name + "', '" + password + "', " + number_int + ")");
		        	
		        	request.getRequestDispatcher("WEB-INF/register-result.jsp").forward(request, response);
	        	}
	        	
	        }
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
        }
        
	}
	
	private static boolean checkName(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "mysqlpass123?");
        	PreparedStatement pstmt = con.prepareStatement("SELECT userName FROM users WHERE userName = '" + name + "'");
        	ResultSet rs = pstmt.executeQuery();
        	rs.next();
        	String name_result = rs.getString("userName");
            
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
