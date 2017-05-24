package com.patwa.dao.notused;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.patwa.entity.Student;

@Repository
@Qualifier("mangoData")
public class MangoStudentDaoImp implements StudentDao {

	public Collection<Student> getAllStudents() {
		
		return new ArrayList<Student>(){
			{
				add(new Student(1,"Rajan","Statistics"));
			}
		};
	}

	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student removeStudentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStudentById(Student student) {
		// TODO Auto-generated method stub

	}

	public void addStudent(Student student) {
		// TODO Auto-generated method stub

	}

}
