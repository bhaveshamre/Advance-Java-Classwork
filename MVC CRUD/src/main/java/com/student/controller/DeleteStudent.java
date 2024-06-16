package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.studentDAOImpl.StudentDAOImpl;

/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			StudentDAOImpl obj = new StudentDAOImpl();
			int rs = obj.remove(id);
			
			if (rs>0) {
				request.setAttribute("msg", "Delete Succesfully");
				request.getRequestDispatcher("form.jsp").forward(request, response);
				
				
			}
			else {
				request.setAttribute("msg", "Error");
				request.getRequestDispatcher("form.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			}
		
	}

}
