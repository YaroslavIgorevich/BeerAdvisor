package com.beerapp.web;

import javax.servlet.*;
import java.sql.*;

public class BeerServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        String driverClassName = context.getInitParameter("jdbc.driver");
        String dbURL = context.getInitParameter("jdbc.url");
        String dbUsername = context.getInitParameter("jdbc.username");
        String dbPassword = context.getInitParameter("jdbc.password");

        Connection dbConnection = null;

        try {
            Class.forName(driverClassName);
            dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (dbConnection != null)
            context.setAttribute("databaseConnection", dbConnection);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
