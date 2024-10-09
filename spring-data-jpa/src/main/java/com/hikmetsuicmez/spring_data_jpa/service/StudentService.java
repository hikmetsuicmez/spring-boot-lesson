package com.hikmetsuicmez.spring_data_jpa.service;

import com.hikmetsuicmez.spring_data_jpa.dto.DtoStudent;
import com.hikmetsuicmez.spring_data_jpa.dto.DtoStudentIU;

import java.util.List;

public interface StudentService {

    DtoStudent addStudent(DtoStudentIU dtoStudentIU);
    List<DtoStudent> retrieveAllStudents();
    DtoStudent retrieveStudentById(Long id);
    void deleteStudentById(Long id);
    DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU);
}
