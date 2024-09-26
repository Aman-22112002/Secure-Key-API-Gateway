package com.Example;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsServlet extends HttpServlet {
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");

        if (TokenValidator.isValidToken(request, token)) {
            try (Connection connection = DBConnectionManager.getConnection()) {
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM products");
                ResultSet rs = statement.executeQuery();

                request.setAttribute("products", rs);
                request.getRequestDispatcher("products.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        } else {
            response.sendRedirect("index.jsp?error=invalid_token");
        }
    }
}