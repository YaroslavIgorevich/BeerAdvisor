package com.beerapp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DatabaseTest extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection dbConnection = (Connection)getServletContext().getAttribute("databaseConnection");
        try (Statement statement = dbConnection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM customers");
            while (result.next())
                out.println(result.getString("id") + " | " + result.getString("name") + " | " + result.getString("address") + "<br>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

