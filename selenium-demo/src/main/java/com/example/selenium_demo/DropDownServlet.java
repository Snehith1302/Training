package com.example.selenium_demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DropDownServlet")
public class DropDownServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		
		if(username!=null && !username.isEmpty())
		{
			response.sendRedirect("success.html");
		}
		else {
			response.getWriter().println("failed");
		}

}
}
