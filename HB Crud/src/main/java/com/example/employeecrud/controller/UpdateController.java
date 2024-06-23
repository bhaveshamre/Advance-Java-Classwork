package com.example.employeecrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.employeecrud.daoimpl.EmployeeDAOImpl;
import com.example.employeecrud.model.Employee;


public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateController() {
        super();
    }

    // Handles the display of the update form with existing employee details
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            EmployeeDAOImpl dao = new EmployeeDAOImpl();
            Employee employee = dao.getById(id);
            
            if (employee != null) {
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("controller").forward(request, response);
            } else {
                request.setAttribute("msg", "Employee not found");
                request.getRequestDispatcher("controller").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while fetching the employee details.");
        }
    }

    // Handles the update of the employee details
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            float salary = Float.parseFloat(request.getParameter("salary"));
            String phone = request.getParameter("phone");

            EmployeeDAOImpl dao = new EmployeeDAOImpl();
            int result = dao.update(id, name, phone, salary);

            if (result > 0) {
                request.setAttribute("msg", "Employee updated successfully.");
                

            } else {
                request.setAttribute("msg", "Failed to update employee.");
            }
			/* request.getRequestDispatcher("controller").forward(request, response); */
            response.sendRedirect("controller");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while updating the employee.");
        }
    }
}
