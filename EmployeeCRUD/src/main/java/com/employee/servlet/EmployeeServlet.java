package com.employee.servlet;

import com.employee.model.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    private List<Employee> empList;

    @Override
    public void init() throws ServletException {
        empList = new ArrayList<>();
        getServletContext().setAttribute("employees", empList);
    }

    // GET – View Employees
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");
        List<Employee> list = (List<Employee>) getServletContext().getAttribute("employees");

        if (list.isEmpty()) {
            resp.getWriter().print("No Employees Found");
        } else {
            for (Employee e : list) {
                resp.getWriter().println(
                    e.getId() + " " + e.getName() + " " + e.getSalary()
                );
            }
        }
    }

    // POST – Add Employee
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));

        empList.add(new Employee(id, name, salary));
        resp.getWriter().print("Employee Added Successfully");
    }

    // PUT – Update Employee
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double salary = Double.parseDouble(req.getParameter("salary"));

        for (Employee e : empList) {
            if (e.getId() == id) {
                e.setName(name);
                e.setSalary(salary);
                resp.getWriter().print("Employee Updated");
                return;
            }
        }
        resp.getWriter().print("Employee Not Found");
    }

    // DELETE – Delete Employee
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Iterator<Employee> it = empList.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                resp.getWriter().print("Employee Deleted");
                return;
            }
        }
        resp.getWriter().print("Employee Not Found");
    }
}
