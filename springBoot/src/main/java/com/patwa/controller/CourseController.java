package com.patwa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.patwa.entity.Course;
import com.patwa.entity.Student;
import com.patwa.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	//Get All Course that belong to Student Id
	@RequestMapping(value="/students/{id}/courses",method=RequestMethod.GET)
	public Collection<Course> getAllCourses(@PathVariable("id") int id){
		return this.courseService.getAllCourses(id);
	}
	
	//Get Course by Id
	@RequestMapping(value="/students/{studentId}/courses/{id}",method=RequestMethod.GET)
	public Course getCourseById(@PathVariable("id") int id){
		return this.courseService.getCourseById(id);
	}
	
	//Insert new Course
	@RequestMapping(value="/students/{studentId}/courses" ,method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addCourse(@RequestBody Course course,@PathVariable("studentId") int studentId){
		course.setStudent(new Student(studentId,"",""));
		this.courseService.addCourse(course);
	}	
	
	//Update Course By Id
	@RequestMapping(value="/students/{studentId}/courses/{id}",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateCourseById(@RequestBody Course course,@PathVariable("studentId") int studentId,@PathVariable("id") int id){		
		course.setStudent(new Student(studentId,"",""));
		this.courseService.updateCourse(course);
	}
		
	//Delete Course by Id
	@RequestMapping(value="/students/{studentId}/courses/{id}",method=RequestMethod.DELETE)
	public Course removeStudentById(@PathVariable("id") int id){
		return this.courseService.removeCourseById(id);
	}
	
	
	

}
