package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "cdac");
			Statement stmt = conn.createStatement();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String qry = "SELECT * FROM user WHERE username='"+username+"' and password='"+password+"'";
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next()) {
			  HttpSession session =	request.getSession(); // it will create a new session and it will return an object for newly created session
			  session.setAttribute("usernameSession", username); // it will store the data in key value pair in the session
			  response.sendRedirect("ProfileServlet");
			}
			else {
				printWriter.println("<script>alert('Invalid username or password')</script>");
				printWriter.println("<script>location.href='index.html'</script>");
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}


}
