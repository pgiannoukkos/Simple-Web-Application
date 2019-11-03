package pgiannoukkos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	static private Connection con = null;
	static private final String CONURL = "jdbc:mysql://localhost:3306/www?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static private final String USERNAME = "user";
	static private final String PASSWORD = "user";

	public static Connection getCon() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CONURL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

		return con;
	}
}
