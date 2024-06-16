package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.student.model.StudentModel;
import com.studentDAOImpl.StudentDAOImpl;

/**
 * Servlet implementation class UpdateStudent
 */
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id =  Integer.parseInt(request.getParameter("id"));
			
			StudentDAOImpl obj = new StudentDAOImpl();
			StudentModel std = obj.getById(id);
			
			if(std !=null) {
				request.setAttribute("obj", std);
				request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
			}
			else {
				response.getWriter().println("sdfg");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			StudentModel std = new StudentModel();
			
			response.getWriter().println(id);
			std.setId(Integer.parseInt(request.getParameter("id")));
			std.setName(request.getParameter("name"));
			std.setMarks(Float.parseFloat(request.getParameter("marks")));
			std.setPhone(Integer.parseInt(request.getParameter("phone")));
			StudentDAOImpl obj = new StudentDAOImpl();
			
			int rs = obj.update(id, std);
			if(rs>0) {
				request.setAttribute("msg", "Student Updated Successfully..");
				request.getRequestDispatcher("form.jsp").forward(request, response);
			}
			else {
				response.getWriter().println("<h2>Failed..</h2>");
			}
			
		} catch (Exception e) {
			response.getWriter().println(id);
			response.getWriter().println("<h2>Something Wrong Here..</h2>");
		}
	}

}
