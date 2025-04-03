package com.StudentManagement.javaservlet;

import com.StudentManagement.dao.StudentDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteStudent(studentId);

        response.sendRedirect("AdminDashboardServlet?message=Student Deleted Successfully");
    }
}
