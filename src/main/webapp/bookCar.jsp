<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Car</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">
<h2>Book Car</h2>

<form action="bookCar" method="post">
<input type="hidden" name="carId" value="<%=request.getParameter("carId")%>">

<input type="date" name="bookDate" required>
<input type="date" name="returnDate" required>

<input type="submit" value="Confirm Booking">
</form>
</div>
</body>
</html>

