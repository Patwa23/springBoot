package com.patwa.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.patwa.dao.notused.StudentDao;
import com.patwa.entity.Student;
import com.patwa.repository.StudentRepository;

@Service
public class StudentService {
	/*@Autowired	
	@Qualifier("postgresql") //Points to specified Data (dao)
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents(){
		return this.studentDao.getAllStudents();
	}
	
	public Student getStudentById(int id){
		return this.studentDao.getStudentById(id);
	}
	
	public Student removeStudentById(int id){
		return this.studentDao.removeStudentById(id);
	}
	
	public void updateStudentById(Student student){		
		this.studentDao.updateStudentById(student);
	}

	public void addStudent(Student student) {
		this.studentDao.addStudent(student);
		
	}*/
	
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
