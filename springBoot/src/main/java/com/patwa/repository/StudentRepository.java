package com.patwa.repository;

import org.springframework.data.repository.CrudRepository;

import com.patwa.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
