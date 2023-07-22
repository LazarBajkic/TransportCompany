package com.TransportCompany.dao;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.TransportCompany.*;

public class CompanyDao {
	
	
	//List all the vehicles
	
	public List<Vehicles> getVehicles(){
		
		List<Vehicles> allVehicles = new ArrayList<Vehicles>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from AllVehicles");
			
			while(rs.next()) {
				
				Vehicles vehicle = new Vehicles();
				
				vehicle.setVehicleType(rs.getString("VehicleType"));
				vehicle.setVehicleModel(rs.getString("VehicleModel"));
				vehicle.setVehicleOwner(rs.getString("VehicleOwner"));
				vehicle.setOwnerNumber(rs.getString("OwnerPhone"));
				
				allVehicles.add(vehicle);
				
			}
			
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allVehicles;
		
	}
	
	//List all the managers
	
	public List<Managers> getManagers(){
		
		List<Managers> managersList = new ArrayList<Managers>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from managers");
			
			while(rs.next()) {
				
				Managers manager = new Managers();
				
				manager.setID(rs.getInt("ID"));
				manager.setName(rs.getString("Name"));
				manager.setBranch(rs.getString("Branch"));
				
				managersList.add(manager);
				
			}
			
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return managersList;
		
	}
	
	//list all the deliveries
	
	public List<Deliveries> getDeliveries(){
		
		List<Deliveries> allDeliveries = new ArrayList<Deliveries>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from deliveries");
			
			while(rs.next()) {
				
				Deliveries delivery = new Deliveries();
				
				delivery.setStartLocation(rs.getString("startLocation"));
				delivery.setDestination(rs.getString("destination"));
				delivery.setDriver(rs.getString("driver"));
				delivery.setCustomer(rs.getString("customer"));
				delivery.setCargoType(rs.getString("goodsType"));
				delivery.setDeliveryCode(rs.getInt("deliveryCode"));
				delivery.setDateOfLoading(rs.getString("dateOfLoading"));
				delivery.setDateOfUnloading(rs.getString("dateOfUnloading"));
				delivery.setWeight(rs.getInt("cargoWeight"));
				
				allDeliveries.add(delivery);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allDeliveries;
		
	}
	
	//List of all available drivers
	
	public List<AvailableDrivers> getAvailableDrivers(){
		
		List<AvailableDrivers> allAvailableDrivers = new ArrayList<AvailableDrivers>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from AvailableDrivers");
			
			while(rs.next()) {
				
				AvailableDrivers availableDriver = new AvailableDrivers();
				
				availableDriver.setDriverName(rs.getString("driverName"));
				availableDriver.setDriverPhone(rs.getString("phoneNumber"));
				
				allAvailableDrivers.add(availableDriver);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allAvailableDrivers;
		
	}
	
	public List<PendingDelivery> getPendingDeliveries(){
		
		List<PendingDelivery> allPendingDeliveries = new ArrayList<PendingDelivery>();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TransportComp","root","Ceramida");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from pendingDeliveryRequests");
			
			while(rs.next()) {
				
				PendingDelivery pendingDelivery = new PendingDelivery();
				
				pendingDelivery.setDeliveryCode(rs.getInt("DeliveryCode"));
				pendingDelivery.setStartLocation(rs.getString("StartLocation"));
				pendingDelivery.setDestination(rs.getString("Destination"));
				pendingDelivery.setCargoType(rs.getString("GoodsType"));
				pendingDelivery.setDateIssued(rs.getString("DateRecevied"));
				pendingDelivery.setWeight(rs.getInt("ShipmentWeight"));
				
				allPendingDeliveries.add(pendingDelivery);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return allPendingDeliveries;
		
	}
	
}
