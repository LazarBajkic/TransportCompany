package com.TransportCompany.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminActions
 */
public class AdminActions extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("addManager")) {
			
			String mID = request.getParameter("mID");
			String mName = request.getParameter("mName");
			String branch = request.getParameter("branchName");
			
			try {
					
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				PreparedStatement st = con.prepareStatement("Insert into managers values(?,?,?)");
				
				st.setString(1, mID);
				st.setString(2, mName);
				st.setString(3, branch);
				
				int execute = st.executeUpdate();
	
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("removeManager")) {
			
			String removeMID = request.getParameter("removeMID");
			String removeMName = request.getParameter("removeMName");
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				PreparedStatement st = con.prepareStatement("Delete from managers where ID=? and Name=?");
				
				st.setString(1, removeMID);
				st.setString(2, removeMName);
				
				int execute = st.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("AdminPage.jsp");
		rd.forward(request, response);
		
	}
	
	

}
