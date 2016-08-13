package com.beerapp.web;

import com.beerapp.model.BeerExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class BeerSelect extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Beer Selection Advice<br>");
        String selectedColor = request.getParameter("color");
        List suggestions = BeerExpert.getBrands(selectedColor);
        out.println("<br>You may try " + suggestions.toString());
    }
}
