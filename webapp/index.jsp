<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Enter API Key</h2>
    <form action="authenticate" method="post">
        <label for="apiKey">API Key:</label>
        <input type="text" id="apiKey" name="apiKey" required>
        <button type="submit">Submit</button>
    </form>
    <%
        String error = request.getParameter("error");
        if ("invalid_api_key".equals(error)) {
            out.println("<p style='color:red;'>Invalid API Key. Please try again.</p>");
        }
    %>
</body>
</html>