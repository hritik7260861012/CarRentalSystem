<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="style.css">

</head>

<body>
<div class="container">
<h2>Login</h2>

<form action="login" method="post">
Email:<input type="email" name="email" placeholder="Email" required><br/><br/>
Password:<input type="password" name="password" placeholder="Password" required><br/><br/>

<input type="submit" value="Login">
</form>
</div>
</body>
</html>
