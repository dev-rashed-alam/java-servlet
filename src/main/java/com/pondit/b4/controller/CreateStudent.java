package com.pondit.b4.controller;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schema.StudentSchema;

import java.io.IOException;

public class CreateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentSchema schema = new StudentSchema();
        schema.setFirstName(req.getParameter("firstName"));
        schema.setLastName(req.getParameter("lastName"));
        schema.setEmail(req.getParameter("email"));
        schema.setPhoneNumber(req.getParameter("phoneNumber"));
        int status = StudentDao.save(schema);
        if (status > 0) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            System.out.println("Something went wrong!");
        }
    }
}
