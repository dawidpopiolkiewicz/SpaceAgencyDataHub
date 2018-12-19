package com.spaceagencydatahub.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		PrintWriter pw = response.getWriter();

		String user = "sa";
		String password = "";

		String jdbcURL = "jdbc:h2:C:/database/h2/spaceagencydatahub";
		String driver = "org.h2.Driver";

		try {
			pw.println("Connection to database: " + jdbcURL);

			Class.forName(driver);
			DriverManager.getConnection(jdbcURL, user, password);
			pw.println("CONNECTED");
		} catch (Exception e) {
			pw.println("CONNECTION FAILED");
	
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
