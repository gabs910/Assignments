package com.ssa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssa.entity.Student;
import com.ssa.service.IStudentService;


@CrossOrigin
@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> student = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@RequestMapping(value= "/del/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id) {
	studentService.deleteStudent(id);
	return new ResponseEntity<Student>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id) {
		
		return new ResponseEntity<Student>(HttpStatus.OK);
	}
}