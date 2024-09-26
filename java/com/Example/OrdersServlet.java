package com.Example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class OrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");

        if (TokenValidator.isValidToken(request, token)) {
            try (Connection connection = DBConnectionManager.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
                ResultSet rs = statement.executeQuery();
                
                request.setAttribute("orders", rs);
                request.getRequestDispatcher("orders.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else {
            response.sendRedirect("index.jsp?error=invalid_token");
        }
    }
	
}
