package com.StudentManagement.javaservlet;

import com.StudentManagement.dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String studentIdParam = request.getParameter("student_id");

            if (studentIdParam == null || studentIdParam.isEmpty()) {
                response.sendRedirect("AdminDashboardServlet?error=Student ID is missing");
                return;
            }

            int studentId = Integer.parseInt(studentIdParam);
            StudentDAO studentDAO = new StudentDAO();

            boolean isDeleted = studentDAO.deleteStudent(studentId);

            if (isDeleted) {
                response.sendRedirect("AdminDashboardServlet?message=Student Deleted Successfully");
            } else {
                response.sendRedirect("AdminDashboardServlet?error=Student not found");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("AdminDashboardServlet?error=Invalid student ID format");
        } catch (IOException e) {
            response.sendRedirect("AdminDashboardServlet?error=Something went wrong");
        }
    }
}
