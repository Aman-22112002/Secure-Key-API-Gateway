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
	<h2>Clients</h2>
    <%
        ResultSet clients = (ResultSet) request.getAttribute("clients");
        if (clients != null) {
            while (clients.next()) {
                out.println("<p>{<br>{Client ID : " + clients.getInt("id")+"}" + ", Client Name : " + clients.getString("name") + "}<br>}</p>");
            }
        } else {
            out.println("<p>No clients found.</p>");
        }
    %>
</body>
</html>