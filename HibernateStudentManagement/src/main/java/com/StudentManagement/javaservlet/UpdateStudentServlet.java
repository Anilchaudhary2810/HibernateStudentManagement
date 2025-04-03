package com.StudentManagement.javaservlet;

import com.StudentManagement.dao.StudentDAO;
import com.StudentManagement.model.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(studentId);

        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
        } else {
            response.sendRedirect("AdminDashboardServlet?error=Student not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String name = request.getParameter("name");
        String studentClass = request.getParameter("class");
        int marks = Integer.parseInt(request.getParameter("marks"));
        String gender = request.getParameter("gender");

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(studentId);

        if (student != null) {
            student.setName(name);
            student.setStudentClass(studentClass);
            student.setMarks(marks);
            student.setGender(gender);

            studentDAO.updateStudent(student);
            response.sendRedirect("AdminDashboardServlet?message=Student Updated Successfully");
        } else {
            response.sendRedirect("UpdateStudentServlet?student_id=" + studentId + "&error=Student not found");
        }
    }
}
