package com.beerapp.web;

import com.beerapp.model.BeerExpert;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BeerSelect extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("Beer Selection Advice<br>");

        HttpSession session = request.getSession();
        String adminEmail = getServletContext().getInitParameter("adminEmail");
        String selectedColor = request.getParameter("color");
        String[] chosenSizes = request.getParameterValues("sizes");
        List suggestions = BeerExpert.getBrands(selectedColor);
        request.setAttribute("adminEmail", adminEmail);
        request.setAttribute("styles", suggestions);
        request.setAttribute("sizes", chosenSizes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
