package com.hikmetsuicmez.spring_data_jpa.repository;

import com.hikmetsuicmez.spring_data_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {

    // HQL
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();

}