package com.patwa.dao.notused;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.patwa.entity.Student;
import com.patwa.repository.StudentRepository;

@Repository
@Qualifier("postgresql")
public class PostgresqlStudentDao  implements StudentDao{
	@Autowired
	private StudentRepository studentRepository;

	public Collection<Student> getAllStudents() {
		List<Student> students=new ArrayList<>();
		studentRepository.findAll()
		.forEach(students::add);	
		return students;
	}
	 
	public Student getStudentById(int id) {		
		return studentRepository.findOne(id);
	}

	public Student removeStudentById(int id) {
		 Student deletedStudent=studentRepository.findOne(id);
		 studentRepository.delete(id);
		 return deletedStudent;
	}

	public void updateStudentById(Student student) {
		studentRepository.save(student);
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

}
