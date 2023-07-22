<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CenteredStyle.css">
<meta charset="UTF-8">
<title>Manager Login</title>
</head>
<body>

	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	%>
	
	<div class="center-container">
    <div class="centered-div">
		
	<form action="checkCred?action=Manager" method="post">
	
	Enter ID:
	<br>
	<input type="number" name="mID">
	<br>
	
	Enter Name:
	<br>
	<input type="text" name="mName">
	<br>
	
	<br>
	<input type="submit" value="login">
	
	</form>
	
	</div>
	</div>
	
</body>
</html>