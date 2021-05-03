package com.example.demo.services;

import com.example.demo.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

    Student getStudent(int id);

    Student addStudent(Student student);

    Student updateStudent(int id, Student student);

    void deleteStudent(int id);
}
