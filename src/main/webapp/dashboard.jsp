<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="com.carrental.db.DBConnection" %>

<html>
<head>
<title>Dashboard</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
<h2>Available Cars</h2>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Model</th>
<th>Price</th>
<th>Action</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM cars");

while(rs.next()) {
%>
<tr>
<td><%=rs.getInt("car_id")%></td>
<td><%=rs.getString("car_name")%></td>
<td><%=rs.getString("model")%></td>
<td>₹ <%=rs.getInt("price")%></td>
<td>
<a href="bookCar.jsp?carId=<%=rs.getInt("car_id")%>">Book</a>
</td>
</tr>
<% } %>

</table>
</body>
</html>

