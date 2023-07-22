package com.TransportCompany.Manager;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerActions
 */
public class ManagerActions extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		RequestDispatcher rd = request.getRequestDispatcher("ManagerPage.jsp");
		
		String startLocation = request.getParameter("startCity");
		String destination = request.getParameter("destination");
		
		String driverName = request.getParameter("driverName");
		String customerName = request.getParameter("customerName");
		
		String goodsType = request.getParameter("cargoType");
		
		String dateOfLoading = request.getParameter("dateOfLoading");
		String dateOfUnloading = request.getParameter("dateOfUnloading");
		
		if(action.equals("addDelivery")) {
			
			
			try {
				
				int deliveryCode = Integer.parseInt(request.getParameter("deliveryCode"));
				int cargoWeight =Integer.parseInt(request.getParameter("cargoWeight"));
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("Select driverName from availableDrivers where driverName='"+driverName+"'");
				Statement stmnt2 = con.createStatement();
				ResultSet rs2 = stmnt2.executeQuery("Select deliveryCode from PendingDeliveryRequests where deliveryCode='"+deliveryCode+"'");
				
				if(rs.next() && rs2.next()) {
				
				PreparedStatement st = con.prepareStatement("Insert into deliveries values(?,?,?,?,?,?,?,?,?)");
				PreparedStatement st2 = con.prepareStatement("delete from availableDrivers where driverName='"+driverName+"'");
				PreparedStatement st3 = con.prepareStatement("delete from pendingDeliveryRequests where DeliveryCode='"+deliveryCode+"'");						
		
				st.setString(1, startLocation);
				st.setString(2, destination);
				st.setString(3, driverName);
				st.setString(4, customerName);
				st.setString(5, goodsType);
				st.setInt(6, deliveryCode);
				st.setString(7, dateOfLoading);
				st.setString(8, dateOfUnloading);
				st.setInt(9, cargoWeight);
				
				int insertIntoDeliveries = st.executeUpdate();
				int delFromAvailable = st2.executeUpdate();
				int delFromPending = st3.executeUpdate();
				
				rd.forward(request, response);
				
				con.close();
				}else {
					System.out.println("Error,Please make sure that all the information you put in is correct!");
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
					
			
		}
		
		String finishedDeliveryDriver = request.getParameter("driverFinishedDelivery");
		int removeCode = Integer.parseInt(request.getParameter("removeCode"));
		
		if(action.equals("removeDelivery")) {
			
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select deliveryCode from deliveries");
				
				if(rs.next()) {
					
					PreparedStatement stmnt = con.prepareStatement("delete from deliveries where deliveryCode='"+removeCode+"'");
					PreparedStatement stmnt2 = con.prepareStatement("Insert into AvailableDrivers select VehicleOwner,OwnerPhone from AllVehicles where VehicleOwner='"+finishedDeliveryDriver+"'");
					
					int deleteDelivery = stmnt.executeUpdate();
					int setIsAvailable = stmnt2.executeUpdate();
				
				}
				
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			rd.forward(request, response);
			
		}
		
	}

}
