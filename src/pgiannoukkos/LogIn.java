package pgiannoukkos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class LogIn extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname").toLowerCase();
		String password = request.getParameter("password");

		try {
			Connection c = ConnectionProvider.getCon();

			String query = "SELECT uname, password FROM users WHERE uname = '" + uname + "';";
			PreparedStatement stmt = c.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();

			if (!rs.next()) {
				stmt.close();
				c.close();
				response.sendRedirect("./error_login.jsp");
				return;
			} else {
				if (rs.getString("password").equals(password)) {
					stmt.close();
					c.close();
					request.setAttribute("username", uname);
					getServletContext().getRequestDispatcher("/hello.jsp").forward(request, response);
				} else {
					stmt.close();
					c.close();
					response.sendRedirect("./error_login.jsp");
					return;
				}
			}

		} catch (SQLException e) {
			response.getWriter().append(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
