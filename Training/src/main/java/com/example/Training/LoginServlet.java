package com.example.Training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Read input from Postman
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("application/json");

        // Dummy validation (replace with DB later)
        if ("admin".equals(username) && "1234".equals(password)) {
            response.getWriter()
                    .write("{\"status\":\"success\",\"message\":\"Login successful\"}");
        } else {
            response.getWriter()
                    .write("{\"status\":\"failure\",\"message\":\"Invalid credentials\"}");
        }
    }
}
