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
		String msg = (String) request.getAttribute("msg");
		if (msg != null)
			out.println("<h2 style=color:green>" + msg + "</h2>");
		String user = (String) request.getAttribute("user");
		if (user == null) {
			response.sendRedirect("shopLogin.jsp");
		}
		%>
	</center>
	<div class="container">
		<h2 style="color: gray; text-align: center;">~~~Shop Registration
			Form~~~</h2>
		<form action="ShopIns" method="post">
			<div class="form-group">
				<label for="exampleInputId">Shop Id</label> <input type="text"
					name="id" class="form-control" id="exampleInputId"
					placeholder="Enter Your Id" aria-describedby="idHelp">
			</div>
			<div class="form-group">
				<label for="exampleInputName">Shop Name</label> <input type="text"
					name="shopName" class="form-control" id="exampleInputName"
					placeholder="Enter Your Name">
			</div>
			<div class="form-group">
				<label for="exampleInputOwner">Shop Owner</label> <input type="text"
					name="shopOwner" class="form-control" id="exampleInputOwner"
					placeholder="Enter Your Owner">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail">Shop Email</label> <input type="text"
					name="shopEmail" class="form-control" id="exampleInputEmail"
					placeholder="Enter Your Email">
			</div>
			<div class="form-group">
				<label for="exampleInputAddress">Shop Address</label> <input
					type="text" name="shopAddress" class="form-control"
					id="exampleInputAddress" placeholder="Enter Your Address">
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form>
	</div>
	</div>
</body>
</html>