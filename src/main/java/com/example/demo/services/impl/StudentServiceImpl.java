package com.example.demo.services.impl;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(student -> studentList.add(student));
        return studentList;
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student retrievedStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
        retrievedStudent.setName(student.getName());
        retrievedStudent.setMajor(student.getMajor());
        return studentRepository.save(retrievedStudent);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
