<%--
  Created by IntelliJ IDEA.
  User: Panayiotis
  Date: 29/10/2019
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Panayiotis Yiannoukkos">

	<link rel="stylesheet" href="./css/master.css">

	<title>Log in</title>
</head>
<body>
<div class="sign-up-form">
	<h1>Sign in</h1>
	<form action="LogIn" method="post">
		<input type="text" name="uname" class="input-box"
			   placeholder="Username" required="required"><br> <input
			type="password" name="password" class="input-box"
			placeholder="Password" required="required"><br> <input
			type="submit" class="signup-btn" value="Sign in">
		<hr>
		<p>
			Not a member yet? <a href="./index.jsp">Sign Up</a>
		</p>
	</form>
</div>
</body>
</html>