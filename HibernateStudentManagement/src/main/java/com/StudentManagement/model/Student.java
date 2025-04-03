package com.StudentManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "class")
    private String studentClass;

    @Column(name = "marks")
    private int marks;

    @Column(name = "gender")
    private String gender;

    public Student() {}

    public Student(String name, String studentClass, int marks, String gender) {
        this.name = name;
        this.studentClass = studentClass;
        this.marks = marks;
        this.gender = gender;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getStudentClass() { return studentClass; }
    public int getMarks() { return marks; }
    public String getGender() { return gender; }

    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setStudentClass(String studentClass) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setMarks(int marks) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setGender(String gender) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
