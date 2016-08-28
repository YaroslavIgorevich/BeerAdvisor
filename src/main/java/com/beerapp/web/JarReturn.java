package com.beerapp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class JarReturn extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/jar");
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream("ANY RESOURSE!!!");

        int read;
        byte[] buffer = new byte[2048];

        try (OutputStream os = response.getOutputStream()) {
            while ((read = is.read(buffer)) != -1) {
                os.write(buffer, 0, read);
            }
        }
//        response.sendRedirect("http://www.ietf.org/rfc/rfc3986.txt");
    }
}