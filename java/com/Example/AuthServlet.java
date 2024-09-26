package com.Example;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AuthServlet extends HttpServlet {
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String apiKey = request.getParameter("apiKey");

	        if (isValidApiKey(apiKey)) {
	            String token = UUID.randomUUID().toString();
	            request.getSession().setAttribute("token", token);
	            response.sendRedirect("data.jsp?token=" + token);
	        } else {
	            response.sendRedirect("index.jsp?error=invalid_api_key");
	        }
	    }

	    private boolean isValidApiKey(String apiKey) {
	        String sql = "SELECT COUNT(*) AS count FROM api_keys WHERE api_key = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql)) {
	        	System.out.println("connection made");
	            statement.setString(1, apiKey);
	            ResultSet rs = statement.executeQuery();
	            if (rs.next()) {
	                int count = rs.getInt("count");
	                return count > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace(); // Handle this more gracefully in a real application
	        }
	        return false;
	    }
}