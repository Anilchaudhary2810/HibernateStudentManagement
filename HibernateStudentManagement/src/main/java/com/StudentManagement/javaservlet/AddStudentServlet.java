package com.StudentManagement.javaservlet;

import com.StudentManagement.dao.StudentDAO;
import com.StudentManagement.model.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String studentClass = request.getParameter("class").trim();
        String gender = request.getParameter("gender").trim();
        int marks = Integer.parseInt(request.getParameter("marks").trim());

        if (name.isEmpty() || studentClass.isEmpty() || gender.isEmpty()) {
            response.sendRedirect("addStudent.html?error=empty_fields");
            return;
        }

        Student student = new Student(name, studentClass, marks, gender);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);

        response.sendRedirect("AdminDashboardServlet");
    }
}
