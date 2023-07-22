<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CenteredContentOneRow.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>
	
	<div class="center-container">
	<div class="center-div">
	
<h1>List of Services</h1>

<ol>

<li>Express delivery</li>
<li>Standard delivery</li>
<li>Passenger transport</li>
<li>Insurance</li>

</ol>

<h2>Delivery</h2>

<p>Our company offers express next-day delivery to our customers,keep in mind the limit for packages that can be sent in this way is a <b>maximum of 30kg or 66lbs</b>,this weight limit is valid for <b>individual parcels</b></p>

</div>
</div>

	
	<div class="center-container">
	<div class="center-div">
	

<form action="registerDelivery" method="post"> 

Enter the starting point of the package:
<br>
<input type="text" name="startLocation">

<br>
<br>

Enter the destination of the package:
<br>
<input type="text" name="destination">

<br>
<br>

What kind of cargo are you shipping?

<Select name="cargoType">

<option value="Special">
Special goods
</option>

<option value="Frozen">
Frozen goods
</option> 

<option value="Chemical">
Chemical goods
</option> 

<option value="TempControlled">
Temperature controlled goods
</option> 

<option value="Liquid or powder">
Liquid or powder in jars
</option> 

<option value="Bulk">
Bulk goods
</option> 

<option value="Dangerous">
Dangerous goods
</option> 

</Select>

<br>
<br>

<input type="checkbox" name="nextDayShip">   
Next day delivery
<br>

<br>
How heavy is the shipment?
<br>
<input type="number" name="cargoWeight"> 

<br>
<br>

<input type="submit" value="confirm">

<br>
<br>

</form>

<form action="checkCred?action=logoutAdmin"  method="post">
	
	<input type="submit" value="logout">
	
	</form>

</div>
</div>
	

</body>
</html>