package com.example.employeecrud.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.example.employeecrud.daoimpl.EmployeeDAOImpl;

public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAOImpl dao = new EmployeeDAOImpl();

    public DeleteController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int result = dao.remove(id);
            
            if (result > 0) {
                request.setAttribute("msg", "Employee deleted successfully.");
            } else {
                request.setAttribute("msg", "Error: Could not delete employee.");
            }
            
            // Forward to the list page to refresh the list of employees
            request.getRequestDispatcher("controller").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "Exception occurred: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
