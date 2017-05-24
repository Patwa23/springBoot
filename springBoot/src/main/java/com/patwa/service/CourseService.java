package com.patwa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.patwa.dao.notused.StudentDao;
import com.patwa.entity.Course;
import com.patwa.repository.CourseRepository;
import com.patwa.repository.StudentRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public Collection<Course> getAllCourses(int studentId) {
		List<Course> courses=new ArrayList<>();
		courseRepository.findByStudentId(studentId)
		.forEach(courses::add);	
		return courses;
	}
	 
	public Course getCourseById(int id) {		
		return courseRepository.findOne(id);
	}

	public Course removeCourseById(int id) {
		 Course deletedCourse=courseRepository.findOne(id);
		 courseRepository.delete(id);
		 return deletedCourse;
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

}
