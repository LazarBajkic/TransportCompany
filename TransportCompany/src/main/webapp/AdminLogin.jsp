<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CenteredStyle.css">
<meta charset="UTF-8">
<title>Admin login</title>
</head>
<body>

    <%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>
	
	<div class="center-container">
    <div class="centered-div">
	
	<form action="checkCred?action=Admin" method="post">
	
	Enter ID:
	<br>
	<input type="number" name="aID">
	
	<br>
	
	Enter User name:
	<br>
	<input type="text" name="aName">
	
	<br>
	<br>
	
		
	<input type="submit" value="login">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>