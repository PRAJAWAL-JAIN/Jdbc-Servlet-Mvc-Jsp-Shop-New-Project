<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
response.setHeader("pragma", "no-cache");
response.setHeader("cache-control", "no-store");
response.setHeader("expire", "0");
%>

<%@include file="adminHea.jsp"%>
<body>
	<center>
		<div class=container>
			<%
			String msg = (String) session.getAttribute("msg");
			String user = (String) session.getAttribute("user");
			if (user != null) {
				out.println("<h2 style=color:green>" + user + "</h2>");
				out.println("<h2 style=color:black>" + msg + "</h2>");
			} else {
				response.sendRedirect("shopLogin.jsp");
			}
			%>
		</div>
	</center>
</body>
</html>