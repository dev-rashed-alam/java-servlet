package com.pondit.b4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * Forward use for redirect to new jsp file
         * **/

        /**resp.getOutputStream().print("Hello");
         req.getRequestDispatcher("/Hello.jsp").forward(req, resp);**/

        /**
         * Include use for concat two or more jsp file
         * **/

        resp.setContentType("text/html");
        resp.getWriter().print("Concatenating...");
        req.getRequestDispatcher("/Hello.jsp").include(req, resp);
        req.getRequestDispatcher("/Hello.jsp").include(req, resp);
    }
}
