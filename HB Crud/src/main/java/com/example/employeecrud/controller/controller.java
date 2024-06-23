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


public class controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAOImpl dao = new EmployeeDAOImpl();

    public controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        try {
            List<Employee> employeeList = dao.getAll();
            if (!employeeList.isEmpty()) {
                request.setAttribute("list", employeeList);
                request.getRequestDispatcher("list.jsp").forward(request, response);
            } else {
                pw.println("<h2>No employees found.</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h2>Something went wrong while retrieving the employees.</h2>");
        } finally {
            pw.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 PrintWriter pw = response.getWriter();
    	try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            float salary = Float.parseFloat(request.getParameter("salary"));
            String phone = request.getParameter("phone");

            Employee emp = new Employee(id, name, salary, phone);
            Integer savedId = dao.save(emp);
            
            if (savedId != null) {
                request.setAttribute("msg", "Employee successfully added with ID: " + savedId);
                List<Employee> employeeList = dao.getAll();
                if (!employeeList.isEmpty()) {
                    request.setAttribute("list", employeeList);
                    request.getRequestDispatcher("list.jsp").forward(request, response);
                    pw.close();
                } else {
                    pw.println("<h2>No employees found.</h2>");
                }
     
                
            } else {
                request.setAttribute("msg", "Failed to add the employee.");
            }

            request.getRequestDispatcher("list.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("msg", "Invalid input format. Please check your inputs.");
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "Something went wrong while adding the employee.");
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }
}
