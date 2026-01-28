package com.example.Training;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // In-memory storage
    private static ArrayList<Student> slist = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // Read parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");

        // Create Student object
        Student st = new Student(id, name, dept);
        slist.add(st);

        // Response
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().print(
            "{ \"message\": \"Student added successfully\", " +
            "\"totalStudents\": " + slist.size() + " }"
        );
        response.getWriter().flush();
    }
}
