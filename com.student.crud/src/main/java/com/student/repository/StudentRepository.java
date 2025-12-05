package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.student.entity.Student;

@EnableJpaRepositories
public interface StudentRepository 
						extends JpaRepository<Student, Integer>{

}
