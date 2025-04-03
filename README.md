# HibernateStudentManagement



SQL code<br>
CREATE DATABASE IF NOT EXISTS student_portal;
USE student_portal;

CREATE TABLE IF NOT EXISTS students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    class ENUM('Post Graduate', 'Undergraduate', 'PhD', 'School') NOT NULL,
    marks INT CHECK (marks >= 0 AND marks <= 100),
    gender ENUM('Male', 'Female', 'Other') NOT NULL
);
