package com.patwa.dao.notused;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.patwa.entity.Student;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImp implements StudentDao{
	
	private static Map<Integer,Student> students;
	
	static{
		students=new HashMap<Integer, Student>(){
			{
			put(1,new Student(1,"Prakash","Inforation Technology"));
			put(2,new Student(2,"Akash","Inforation Technology"));
			put(3,new Student(3,"Vikash","Inforation Technology"));
			put(4,new Student(4,"Varsha","Computer Science"));
			}
		};
	}
	
	public Collection<Student> getAllStudents(){
		return this.students.values();
	}
	
	public Student getStudentById(int id){
		return this.students.get(id);
	}
	
	public Student removeStudentById(int id){
		return this.students.remove(id);
	}
	
	public void updateStudentById(Student student){
		this.students.put(student.getId(),student);
	}

	public void addStudent(Student student) {
		this.students.put(student.getId(), student);
		
	}

}
