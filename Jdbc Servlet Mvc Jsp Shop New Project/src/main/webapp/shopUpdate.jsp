<%@page import="com.app.pojo.Shop"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="adminHea.jsp"%>
<body>
	<center>
		<%
		String user = (String) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("shopLogin.jsp");
		}
		%>
		<%
		Shop s = (Shop)request.getAttribute("SHOP");
		%>
	</center>
	<div class="container">
		<h2 style="color: gray; text-align: center;">~~~Shop Details
			Update Form~~~</h2>
		<form action="ShopUpdate" method="post">
			<div class="form-group">
				<label for="exampleInputId">Shop Id</label> <input type="text"
					name="id" value="<%=s.getId()%>" class="form-control"
					id="exampleInputId" placeholder="Enter Your Id"
					aria-describedby="idHelp" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputName">Shop Name</label> <input type="text"
					name="shopName" value="<%=s.getShopName()%>" class="form-control"
					id="exampleInputName" placeholder="Enter Your Name">
			</div>
			<div class="form-group">
				<label for="exampleInputOwner">Shop Owner</label> <input type="text"
					name="shopOwner" value="<%=s.getShopOwner()%>" class="form-control"
					id="exampleInputOwner" placeholder="Enter Your Owner">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail">Shop Email</label> <input type="text"
					name="shopEmail" value="<%=s.getShopEmail()%>" class="form-control"
					id="exampleInputEmail" placeholder="Enter Your Email">
			</div>
			<div class="form-group">
				<label for="exampleInputAddress">Shop Address</label> <input
					type="text" name="shopAddress" value="<%=s.getShopAddress()%>"
					class="form-control" id="exampleInputAddress"
					placeholder="Enter Your Address">
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
	</div>
</body>
</html>