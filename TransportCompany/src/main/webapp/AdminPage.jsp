<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
	<%@page import="com.TransportCompany.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CenteredContentOneColumn.css">
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body>

	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>

	<div class="center-container">
	<div class="center-div">
	
	<form action="adminActions?action=addManager" method="post">
	
	<h2>Add a new manager</h2>
		
	To add a manager,input the id of the manager,name and the branch they are in.
	<br>
	
	Enter ID:
	<br>
	<input type="number" name="mID">
	<br>
	
	Enter name:
	<br>
	<input type="text" name="mName">
	<br>
	
	Enter branch name:
	<br>
	<input type="text" name="branchName">
	<br>
	
	<br>
	<input type="submit" value="Confirm">
	<br>
	
	
	</form>
	
	<br>
	
	<form action="adminActions?action=removeManager" method="post">
	
	<h2>Remove a new manager</h2>
	
	To remove a manager,input the id of the manager and the  manager's name.
	
	Enter ID:
	<br>
	<input type="number" name="removeMID">
	<br>
	
	Enter name:
	<br>
	<input type="text" name="removeMName">
	<br>
	
	<br>
	<input type="submit" value="Confirm"> 
	<br>
	
	</form>
	
	</div>
	</div>
	
	<div class="center-container">
	<div class="center-div">
	
	<h2>Menager List</h2>
	
	<table>
	
	<tr>
	
	<th>Manager ID</th>
	<th>Manager Name</th>
	<th>Branch</th>
	
	</tr>
	
	<%
	
	List<Managers> allManagers = (List<Managers>) session.getAttribute("allManagers");
	for(Managers manager : allManagers){
	
	%>
	
	<tr bgcolor="yellow">
	
	<td><%=manager.getID()%></td>
	<td><%=manager.getName()%></td>
	<td><%=manager.getBranch()%></td>
	
	<%
	
	}
	
	%>
	
	</table>

	</div>
	</div>
	
	<div class="center-container">
	<div class="center-div">

	<h2>List of all vehicles</h2>
	
	<table>
	
	<tr>
	
	<th>Vehicle Type</th>
	<th>Vehicle Model</th>
	<th>Vehicle Owner</th>
	<th>Owner Phone</th>
	<th>Is Available</th>
	
	</tr>
	
	<%
	
	List<Vehicles> allVehicles = (List<Vehicles>) session.getAttribute("allVehicles");
	for(Vehicles vehicle : allVehicles){
	
	%>
	
	<tr bgcolor=Yellow>
	
	<td><%=vehicle.getVehicleType() %></td>
	<td><%=vehicle.getVehicleModel() %></td>
	<td><%=vehicle.getVehicleOwner() %></td>
	<td><%=vehicle.getOwnerNumber() %></td>
	
	
	
	<%
	
	}
	
	%>
	
	</table>
	
	<form action="checkCred?action=logoutAdmin"  method="post">
	
	<input type="submit" value="logout">
	
	</form>
	
	</div>
	</div>
	

</body>
</html>