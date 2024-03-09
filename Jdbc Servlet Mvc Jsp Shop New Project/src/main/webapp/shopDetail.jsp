<%@page import="com.app.pojo.Shop"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
</head>
<%@include file="adminHea.jsp"%>
<%
response.setHeader("pragma", "no-cache");
response.setHeader("cache-control", "no-store");
response.setHeader("expire", "0");
%>
<body>
	<center>
		<%
		String user = (String) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("shopLogin.jsp");
		}
		%>
		<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.println("<h2 style=color:green>" + msg + "</h2>");
		}
		%>
	</center>
	<%
	ArrayList<Shop> s = (ArrayList<Shop>) request.getAttribute("SHOP");
	%>
	<div class="container">
		<table border="1" class="table table-striped">
			<thead>
				<tr class="table-primary">
					<th>ID</th>
					<th>SHOP NAME</th>
					<th>SHOP OWNER</th>
					<th>SHOP EMAIL</th>
					<th>SHOP ADDRESS</th>
					<th>DELETE</th>
					<th>UPDATE</th>
				</tr>
			</thead>
			<%
			for (Shop sh : s) {
			%>
			<tr>
				<td><%=sh.getId()%></td>
				<td><%=sh.getShopName()%></td>
				<td><%=sh.getShopOwner()%></td>
				<td><%=sh.getShopEmail()%></td>
				<td><%=sh.getShopAddress()%></td>
				<td><a href="ShopDelete?id=<%=sh.getId()%>"
					class='btn btn-primary'
					onclick="return confirm('Are you relly want to Delete?')">Delete</a></td>
				<td><a href="ShopUpdate?id=<%=sh.getId()%>"
					class='btn btn-primary'>Update</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>