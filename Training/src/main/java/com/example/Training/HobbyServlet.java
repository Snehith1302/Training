package com.example.Training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HobbyServlet")
public class HobbyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Read multiple checkbox values
    	PrintWriter out=response.getWriter();
    	String[] hobbies = request.getParameterValues("hobby");

            for (String st : hobbies) {
                out.println(st+" :hobby");
            }
        } 
    }

