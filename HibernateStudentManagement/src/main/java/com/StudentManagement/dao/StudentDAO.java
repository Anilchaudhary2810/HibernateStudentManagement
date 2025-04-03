package com.StudentManagement.dao;

import com.StudentManagement.model.Student;
import com.StudentManagement.util.DBUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        Transaction transaction = null;
        try (Session session = DBUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = DBUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    public Student getStudentById(int id) {
        try (Session session = DBUtil.getSessionFactory().openSession()) {
            return session.get(Student.class, id);
        }
    }

    public boolean updateStudent(Student student) {
    Transaction transaction = null;
    try (Session session = DBUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        return true; 
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        return false; 
    }
}


    public boolean deleteStudent(int id) {
    Transaction transaction = null;
    try (Session session = DBUtil.getSessionFactory().openSession()) {
        transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        
        if (student != null) {
            session.delete(student);
            transaction.commit();
            return true;  
        } else {
            transaction.rollback();
            return false; 
        }
    } catch (Exception e) {
        if (transaction != null) transaction.rollback();
        return false;
    }
}

}
