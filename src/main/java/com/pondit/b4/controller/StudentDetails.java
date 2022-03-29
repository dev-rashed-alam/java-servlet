package com.pondit.b4.controller;

import dao.StudentDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schema.StudentSchema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<StudentSchema> studentSchemaList = StudentDao.findAll();
        List<StudentSchema> studentSchemaList= new ArrayList<>();

        StudentSchema st = new StudentSchema();
        st.setPhoneNumber("111");
        st.setEmail("a@gmail.com");
        st.setFirstName("Rashed");
        st.setLastName("Alam");

        StudentSchema st1 = new StudentSchema();
        st1.setPhoneNumber("111");
        st1.setEmail("a@gmail.com");
        st1.setFirstName("Rashed");
        st1.setLastName("Alam");

        StudentSchema st2 = new StudentSchema();
        st2.setPhoneNumber("111");
        st2.setEmail("a@gmail.com");
        st2.setFirstName("Rashed");
        st2.setLastName("Alam");

        studentSchemaList.addAll(List.of(st, st1, st2));
//        req.setAttribute("studentList", studentSchemaList);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
