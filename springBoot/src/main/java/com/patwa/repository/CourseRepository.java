package com.patwa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.patwa.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	public List<Course>  findByStudentId(int studentId);

}
