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
	 <h2>Products</h2>
    <%
        ResultSet products = (ResultSet) request.getAttribute("products");
        if (products != null) {
            while (products.next()) {
                out.println("<p>{<br>{ Product ID : " + products.getInt("id")+"}" + ", Product Name : " + products.getString("name") + "}<br>}</p>");
            }
        } else {
            out.println("<p>No products found.</p>");
        }
    %>
</body>
</html>