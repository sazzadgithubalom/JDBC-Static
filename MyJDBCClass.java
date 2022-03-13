package com.sazzad.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyJDBCClass extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,
	IOException{
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter(); 
		
		String driverClass = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sazzaddb";
		String userName = "root";
		String password = "root";
		String sql = "insert into employee values(103,'Sakila',63520.33)";
		
		try {
			Class.forName(driverClass);
			Connection con = DriverManager.getConnection(url, userName, password); 
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			con.close();
			out.println("<h1>Update Data</h1>");
			}catch(ClassNotFoundException e) {
				out.println("<h1>Driver Class not Loaded</h1>");
			}catch(SQLException e) {
				out.println("<h1>Connection is not Stablised</h1>");
			}
		out.println("<a href='index.html'>Click here for more update</a>");
		
	}

}
