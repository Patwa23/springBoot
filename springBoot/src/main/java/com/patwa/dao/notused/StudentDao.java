package com.patwa.dao.notused;

import java.util.Collection;

import com.patwa.entity.Student;

public interface StudentDao {


	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	Student removeStudentById(int id);

	void updateStudentById(Student student);

	void addStudent(Student student);

}