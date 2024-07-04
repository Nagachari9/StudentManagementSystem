package com.example.demo.ServiceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repositary.StudentRepositary;
import com.example.demo.Service.StudentService;
@Service
public class StudentServiceImp implements StudentService {
private StudentRepositary studentRepositary;

	public StudentServiceImp(StudentRepositary studentRepositary) {
	super();
	this.studentRepositary = studentRepositary;
}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepositary.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepositary.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepositary.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepositary.findById(id).get();
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepositary.deleteById(id);
	}

}
