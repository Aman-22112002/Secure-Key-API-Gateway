package com.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TokenValidator {
	public static boolean isValidToken(HttpServletRequest request, String token) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String sessionToken = (String) session.getAttribute("token");
            return token.equals(sessionToken);
        }
        return false;
    }
}
