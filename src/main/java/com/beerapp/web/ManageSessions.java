package com.beerapp.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ManageSessions extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        //The example of URL-rewriting in case of client disabled cookies
        out.println("<html><body>");
        out.println("<p>");
        if (session.isNew()) {
            out.println("This is a new session");
        } else {
            out.println("Hello again!");
        }
        out.println("</p>");
        out.println("<a href=\"" + response.encodeURL("/BeerAdvisor/SessionsTest.do") + "\">click DAT link!!!</a>");
        out.println("</body></html>");
        out.close();
    }
}