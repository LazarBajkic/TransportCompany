package com.TransportCompany.Login;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.TransportCompany.dao.*;
import java.util.List;
import java.util.ArrayList;
import com.TransportCompany.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class CheckCred
 */
public class CheckCred extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		RequestDispatcher rdUser = request.getRequestDispatcher("UserPage.jsp"); 
		RequestDispatcher rdUser2 = request.getRequestDispatcher("UserLogin.jsp"); 
		
		RequestDispatcher rdAdmin = request.getRequestDispatcher("AdminPage.jsp"); 
		RequestDispatcher rdAdmin2 = request.getRequestDispatcher("AdminLogin.jsp"); 
		
		RequestDispatcher rdManager = request.getRequestDispatcher("ManagerPage.jsp"); 
		RequestDispatcher rdManager2 = request.getRequestDispatcher("ManagerLogin.jsp"); 
		
		RequestDispatcher rdHomePage = request.getRequestDispatcher("index.jsp"); 
		
		HttpSession sess = request.getSession();
		
		
		if(action.equals("User")) {
			
			String uID = request.getParameter("uID");
			String uName= request.getParameter("uName");
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				PreparedStatement st = con.prepareStatement("Select * from users where ID=? and Name=?");
				
				st.setString(1, uID);
				st.setString(2, uName);
				
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					rdUser.forward(request, response);
				}else {
					rdUser2.forward(request, response);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		else if(action.equals("Admin")) {
			
			String aID = request.getParameter("aID");
			String aName= request.getParameter("aName");
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				PreparedStatement st = con.prepareStatement("Select * from admins where ID=? AND Name=?");
				
				st.setString(1, aID);
				st.setString(2,aName);
				
				ResultSet rs= st.executeQuery();
				
				Statement st2 = con.createStatement();
				ResultSet rs2 = st2.executeQuery("Select * from AllVehicles");
				
				Statement st3 = con.createStatement();
				ResultSet rs3 = st3.executeQuery("Select * from managers");
				
			   
				if(rs.next()) {
					if(rs2.next() && rs3.next()){
						
						CompanyDao cDao = new CompanyDao();
						
						List<Vehicles> allVehicles = cDao.getVehicles();
						List<Managers> allManagers = cDao.getManagers();
						
						sess.setAttribute("allVehicles", allVehicles);
						sess.setAttribute("allManagers", allManagers);
						
					}
					rdAdmin.forward(request, response);
				}else {
					rdAdmin2.forward(request, response);
				}
				
				rs.close();
				rs2.close();
				rs3.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(action.equals("Manager")) {
			
			String mID = request.getParameter("mID");
			String mName = request.getParameter("mName");
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				PreparedStatement st = con.prepareStatement("Select * from managers where ID=? and Name=?");
				
				st.setString(1, mID);
				st.setString(2, mName);
				
				ResultSet rs = st.executeQuery();
												
				if(rs.next()) {
						
						CompanyDao cDao = new CompanyDao();
						
						List<Vehicles> allVehicles = cDao.getVehicles();
						List<Deliveries> allDeliveries = cDao.getDeliveries();
						List<AvailableDrivers> allAvailableDrivers = cDao.getAvailableDrivers();
						List<PendingDelivery> allPendingDeliveries = cDao.getPendingDeliveries();
						
						sess.setAttribute("allAvailableDrivers", allAvailableDrivers);
						sess.setAttribute("allDeliveries", allDeliveries);
						sess.setAttribute("allVehicles", allVehicles);
						sess.setAttribute("allPendingDeliveries", allPendingDeliveries);
					
					rdManager.forward(request, response);
				}else {
					rdManager2.forward(request, response);
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		} 
		
		if(action.equals("logoutUser")) {
		
			sess.removeAttribute("uID");
			sess.removeAttribute("uName");
			
			rdHomePage.forward(request, response);
			
		}else if(action.equals("logoutAdmin")) {
			
			sess.removeAttribute("aID");
			sess.removeAttribute("aName");
			
			rdHomePage.forward(request, response);
		
		}else if(action.equals("logoutManager")){
			
			sess.removeAttribute("mID");
			sess.removeAttribute("mName");
			
			rdHomePage.forward(request, response);
		}
		
	}


}
