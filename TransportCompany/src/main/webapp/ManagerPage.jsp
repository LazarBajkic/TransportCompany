<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
	<%@page import="com.TransportCompany.*" %>	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CenteredContentOneColumn.css">
<meta charset="UTF-8">
<title>Manager Page</title>
</head>
<body>
	
	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>
	
	<div class="center-container">
	<div class="center-div">
	
	Welcome manager,here you will be managing,all the drivers,their availability,where are they currently<br>you will also be keeping track of all deliveries
	as well as register pending deliveries<br>as well as finalize finished deliveries,we wish you the best of luck!
	
	</div>
	</div>
	
<div class="center-container">
<div class="center-div">
	
<h2>List of vehicles</h2>

<table>

<tr bgcolor="orange">

	<th>Vehicle Type</th>
	<th>Vehicle Model</th>
	<th>Vehicle Owner</th>
	<th>Owner Phone</th>

</tr>

<%

	List<Vehicles> allVehicles = (List<Vehicles>) session.getAttribute("allVehicles");
	for(Vehicles vehicle : allVehicles){
%>

<tr bgcolor="yellow">

<td><%=vehicle.getVehicleType()%></td>
<td><%=vehicle.getVehicleModel()%></td>
<td><%=vehicle.getVehicleOwner()%></td>
<td><%=vehicle.getOwnerNumber()%></td>

<%

	}

%>

</table>
	
	</div>
	</div>

	<div class="center-container">
    <div class="centered-div">
	

<h2>All deliveries</h2>

<table>

<tr bgcolor="orange">

<th>Starting city</th>
<th>Destination</th>
<th>Driver</th>
<th>Customer</th>
<th>Delivery code</th>
<th>Cargo type</th>
<th>Date of loading</th>
<th>Date of unloading</th>
<th>Weight</th>

</tr>

<%

List<Deliveries> allDeliveries = (List<Deliveries>) session.getAttribute("allDeliveries");
for(Deliveries delivery : allDeliveries){

%>

	<tr bgcolor="yellow">

	<td><%=delivery.getStartLocation() %></td>
	<td><%=delivery.getDestination() %></td>
	<td><%=delivery.getDriver() %></td>
	<td><%=delivery.getCustomer() %></td>
	<td><%=delivery.getDeliveryCode()%></td>
	<td><%=delivery.getCargoType()%></td>
	<td><%=delivery.getDateOfLoading()%></td>
	<td><%=delivery.getDateOfUnloading()%></td>
	<td><%=delivery.getWeight()%> KG</td>
	
<%

}

%>

</table>
	
	</div>
	</div>
	
	<div class="center-container">
    <div class="centered-div">

<h2>All available drivers</h2>

<table>

<tr bgcolor="orange">

<th>Driver name</th>
<th>Phone number</th>

</tr>

<%

	List<AvailableDrivers> allAvailableDrivers = (List<AvailableDrivers>) session.getAttribute("allAvailableDrivers");
	for(AvailableDrivers availableDriver : allAvailableDrivers){

%>
	
	<tr bgcolor="yellow">
	
	<td><%=availableDriver.getDriverName()%></td>
	<td><%=availableDriver.getDriverPhone()%></td>
	
<%

	}

%>

</table>

</div>
</div>

    <div class="center-container">
    <div class="centered-div">
	

<h2>Pending delivery requests</h2>

<table>

	<tr bgcolor="orange">
	
	<th>Delivery code</th>
	<th>Starting location</th>
	<th>Destination</th>
	<th>Goods type</th>
	<th>Date issued</th>
	<th>Cargo weight</th>
	
	</tr>
	
	<%
	
	List<PendingDelivery> pendingDeliveries = (List<PendingDelivery>) session.getAttribute("allPendingDeliveries");
	
	for(PendingDelivery pendingDelivery : pendingDeliveries){
	
	%>

	<tr bgcolor="yellow">
	
	<td><%=pendingDelivery.getDeliveryCode()%></td>
	<td><%=pendingDelivery.getStartLocation()%></td>
	<td><%=pendingDelivery.getDestination()%></td>
	<td><%=pendingDelivery.getCargoType()%></td>
	<td><%=pendingDelivery.getDateIssued()%></td>
	<td><%=pendingDelivery.getWeight()%> KG</td>
	
	<%
	
	}
	
	%>
</table>

	</div>
	</div>
	
	<div class="center-container">
    <div class="centered-div">
	
	
To register the new delivery input the delivery code,name of the driver,the date of loading,the date of unloading

<form action="managerActions?action=addDelivery" method = "post">

Enter delivery code:
<br>
<input type="number" name="deliveryCode">
<br>

Enter the starting city:
<br>
<input type="text" name="startCity">
<br>

Enter the destination:
<br>
<input type="text" name="destination">
<br>

Enter the full name of driver:
<br>
<input type="text" name="driverName">
<br>

Enter the full name of the customer:
<br>
<input type="text" name="customerName">
<br>

Enter the cargo type:
<br>
<input type="text" name="cargoType">
<br>

Enter the cargo weight:
<br>
<input type="number" name="cargoWeight">
<br>

Enter date of loading:
<br>
<input type="text" name="dateOfLoading">
<br>

Enter date of unloading:
<br>
<input type="text" name="dateOfUnloading">
<br>

<br>
<input type="submit" value="confirm">
<br>

</form>

</div>
</div>

	<div class="center-container">
    <div class="centered-div">
	

<form action="managerActions?action=removeDelivery" method="post">

Insert the name of the driver and the delivery code to finalize the delivery:

Delivery code:
<br>
<input type="number" name="removeCode">
<br>

Driver name:
<br>
<input type="text" name="driverFinishedDelivery">

<br>
<br>
	
<input type="submit">

</form>

<br>

<form action="checkCred?action=logoutManager"  method="post">
	
	<input type="submit" value="logout">
	
	</form>

</div>
</div>

</body>
</html>