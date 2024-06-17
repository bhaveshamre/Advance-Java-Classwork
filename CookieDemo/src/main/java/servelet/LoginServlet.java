package servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.Cookie;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(username.equals("admin") && password.equals("admin123")) {
				Cookie ck = new Cookie("usernameCookie", username);
				ck.setMaxAge(60);
				response.addCookie(ck);
				response.sendRedirect("ProfileServlet");
			}
			else {
				printWriter.println("<script>alert('Invalid Username or password'); location.href='index.html';</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
