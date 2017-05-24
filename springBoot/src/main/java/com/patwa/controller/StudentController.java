package com.patwa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patwa.entity.Student;
import com.patwa.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	//Get All Student
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Student> getAllStudents(){
		return this.studentService.getAllStudents();
	}
	
	//Get Student by Id
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id){
		return this.studentService.getStudentById(id);
	}
	
	//Delete Student by Id
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public Student removeStudentById(@PathVariable("id") int id){
		return this.studentService.removeStudentById(id);
	}
	
	//Update Student By Id
	@RequestMapping(method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateStudentById(@RequestBody Student student){		
		this.studentService.updateStudentById(student);
	}
	
	//Insert new Student
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addStudent(@RequestBody Student student){		
		this.studentService.addStudent(student);
	}

}
