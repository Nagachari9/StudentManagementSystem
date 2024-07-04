package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Student;

public interface StudentService {
List<Student> getAllStudents();
Student saveStudent(Student student);
Student updateStudent(Student student);
Student getStudentById(Long id);
void deleteStudentById(Long id);
}
