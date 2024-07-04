package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@Controller
public class StudentController {
private StudentService studentService;

public StudentController(StudentService studentService) {
	super();
	this.studentService = studentService;
}
//handler method to handle list students and return mode and view
@GetMapping("/Student")
public String listStudent(Model model)
{
	model.addAttribute("Student",studentService.getAllStudents());
	return "Student";
}
@GetMapping("/Student/new")
public String createStudentform(Model model)
{
	Student student=new Student();
	model.addAttribute("student",student);
	return "create_student";
}
@PostMapping("/Student")
public String saveStudent(@ModelAttribute("student") Student student)
{
studentService.saveStudent(student);
return "redirect:/Student";
}
@GetMapping("/Student/edit/{id}")
public String editStudentform(@PathVariable Long id,Model model)
{
	model.addAttribute("student",studentService.getStudentById(id));
	return "edit_student";
	
}
@PostMapping("/Student/{id}")
public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model)
{
	Student existingStudent=studentService.getStudentById(id);
	existingStudent.setId(id);
	existingStudent.setFirstname(student.getFirstname());
	existingStudent.setLastname(student.getLastname());
	existingStudent.setEmail(student.getEmail());	
  studentService.updateStudent(existingStudent);
  return "redirect:/Student";
	
}
@GetMapping("/Student/{id}")
public String deleteStudent(@PathVariable Long id)
{
	studentService.deleteStudentById(id);
	return "redirect:/Student";
	
}
}
