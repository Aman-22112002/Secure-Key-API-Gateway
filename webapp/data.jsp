<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h2>Data Access</h2>
    <%
        String token = request.getParameter("token");
    %>
    <form action="orders" method="get">
        <input type="hidden" name="token" value="<%= token %>">
        <button type="submit">View Orders</button>
    </form>
    <form action="products" method="get">
        <input type="hidden" name="token" value="<%= token %>">
        <button type="submit">View Products</button>
    </form>
    <form action="clients" method="get">
        <input type="hidden" name="token" value="<%= token %>">
        <button type="submit">View Clients</button>
    </form>
</body>
</html>