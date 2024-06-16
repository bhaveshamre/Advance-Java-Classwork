package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.student.model.StudentModel;
import com.studentDAOImpl.StudentDAOImpl;

/**
 * Servlet implementation class StudentSave
 */
public class StudentSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			StudentDAOImpl obj = new StudentDAOImpl();
			List<StudentModel> stdList = obj.getAll();
			if(!stdList.isEmpty()) {
				request.setAttribute("list", stdList);
				request.getRequestDispatcher("form.jsp").forward(request, response);
			}else {
				response.getWriter().println("<h2>Failed..</h2>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("<h2>Something Wrong Here..</h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			StudentModel std = new StudentModel();
			std.setId(Integer.parseInt(request.getParameter("id")));
			std.setName(request.getParameter("name"));
			std.setMarks(Float.parseFloat(request.getParameter("marks")));
			std.setPhone(Integer.parseInt(request.getParameter("phone")));
			StudentDAOImpl obj = new StudentDAOImpl();
			
			int rs = obj.save(std);
			if(rs>0) {
				request.setAttribute("msg", "Student Registered Successfully..");
				request.getRequestDispatcher("form.jsp").forward(request, response);
			}
			else {
				response.getWriter().println("<h2>Failed..</h2>");
			}
			
		} catch (Exception e) {
			response.getWriter().println("<h2>Something Wrong Here..</h2>");
		}
	}

}
