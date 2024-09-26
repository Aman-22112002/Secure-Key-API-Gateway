<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.ResultSet" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h2>Orders</h2>
    <%
        ResultSet orders = (ResultSet) request.getAttribute("orders");
        if (orders != null) {
            while (orders.next()) {
                out.println("<p>{ <br>{ Order ID : " + orders.getInt("id") + "}" + ", <br>{Order Description : " + orders.getString("description") + "}<br>}</p>");
            }
        } else {
            out.println("<p>No orders found.</p>");
        }
    %>
</body>
</html>