package pgiannoukkos;

import java.io.IOException;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class SignUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		try {
			Connection c = ConnectionProvider.getCon();

			PreparedStatement stmt = c.prepareStatement("SELECT uname, email FROM users");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (rs.getString("uname").equals(uname) || rs.getString("email").equals(email)) {
					response.sendRedirect("./error.jsp");
					return;
				}
			}

			String query = "INSERT INTO users(uname, password, email) VALUES('" + uname + "', '" + password + "', '" + email + "')";
			stmt = c.prepareStatement(query);
			stmt.executeUpdate();

			stmt.close();
			c.close();
			response.sendRedirect("./success.jsp");
		} catch (SQLException e) {
			response.getWriter().append(e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
