package com.TransportCompany.User;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserActions
 */
public class UserActions extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random r = new Random();
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		RequestDispatcher rd = request.getRequestDispatcher("UserPage.jsp");
		
		String date = simpleDateFormat.format(new Date());
		String startingPoint = request.getParameter("startLocation");
		String destination = request.getParameter("destination");
		String cargoType = request.getParameter("cargoType");
		int cargoWeight =Integer.parseInt(request.getParameter("cargoWeight"));
		String nextDayShip = request.getParameter("nextDayShip");
		int deliveryCode = r.nextInt(1000,20000);
		
		HttpSession sess = request.getSession();
		
	   if(cargoWeight <= 30 || cargoWeight <= 30 && nextDayShip != null || cargoWeight > 30 && nextDayShip == null) {
		   
		   try {
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
				PreparedStatement st = con.prepareStatement("Insert into pendingDeliveryRequests values(?,?,?,?,?,?)");
				
				st.setInt(1, deliveryCode);
				st.setString(2, startingPoint);
				st.setString(3, destination);
				st.setString(4, cargoType);
				st.setString(5, date);
				st.setInt(6, cargoWeight);
				
				int insertValues = st.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		   
	   }else {
		   System.out.println("Error cant have NDD if the weight of the package is over 30kg!");
	   }
		
	   rd.forward(request, response);
		
	}

}
