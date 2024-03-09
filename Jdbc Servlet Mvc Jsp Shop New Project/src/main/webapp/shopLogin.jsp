<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="header.jsp"%>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null)
		out.println("<h2 style=color:red>" + msg + "</h2>");
	%>
	<div class="container">
		<h2 style="color: gray; text-align: center;">~~~Shop Login~~~</h2>
		<form action="LoginShop" method="post">
			<div class="form-group">
				<label for="exampleInputName">User Name</label> <input type="text"
					name="name" class="form-control" id="exampleInputName"
					aria-describedby="nameHelp">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword">Password</label> <input
					type="text" name="password" class="form-control"
					id="exampleInputPassword">
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>