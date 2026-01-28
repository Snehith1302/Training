package com.example.Training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CarServlet() {
        super();
    }

    // Initialize data when server starts
    @Override
    public void init() {
        ServletContext context = getServletContext();

        ArrayList<Car> carList = new ArrayList<>();
        Car c1 = new Car(1, "Swift", "6 Lakhs");
        carList.add(c1);

        context.setAttribute("data", carList);
    }

    // Display all cars
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        ArrayList<Car> carList =
                (ArrayList<Car>) context.getAttribute("data");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        out.println("ID\tNAME\tPRICE");
        for (Car c : carList) {
            out.println(c.getId() + "\t" + c.getName() + "\t" + c.getPrice());
        }
    }

    // Add new car
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();
        ArrayList<Car> carList =
                (ArrayList<Car>) context.getAttribute("data");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        Car c = new Car(id, name, price);
        carList.add(c);

        context.setAttribute("data", carList);

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Car added successfully");
    }

    @Override
    protected void doPut(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest request,
                            HttpServletResponse response)
            throws ServletException, IOException {
    }
}
