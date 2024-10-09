package com.hikmetsuicmez.spring_data_jpa.service.impl;

import com.hikmetsuicmez.spring_data_jpa.dto.DtoStudent;
import com.hikmetsuicmez.spring_data_jpa.dto.DtoStudentIU;
import com.hikmetsuicmez.spring_data_jpa.entity.Student;
import com.hikmetsuicmez.spring_data_jpa.repository.StudentRepository;
import com.hikmetsuicmez.spring_data_jpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public DtoStudent addStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU,student);
        Student savedStudent = studentRepository.save(student);

        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(savedStudent,dtoStudent);
        return dtoStudent;
    }

    @Override
    public List<DtoStudent> retrieveAllStudents() {
        List<DtoStudent> dtoStudents = new ArrayList<>();
        List<Student> students = studentRepository.findAllStudents();
        for (Student student : students) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student,dtoStudent);
            dtoStudents.add(dtoStudent);
        }
        return dtoStudents;
    }

    @Override
    public DtoStudent retrieveStudentById(Long id) {
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student dbStudent = optionalStudent.get();
            BeanUtils.copyProperties(dbStudent,dtoStudent);
        }
        return dtoStudent;
    }

    @Override
    public void deleteStudentById(Long id) {
        DtoStudent dtoStudent = retrieveStudentById(id);
        if (dtoStudent != null) {
            studentRepository.deleteById(id);
        }

    }

    @Override
    public DtoStudent updateStudent(Long id, DtoStudentIU dtoStudentIU) {
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            Student dbStudent = optional.get();

            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setDateOfBirth(dtoStudentIU.getDateOfBirth());
            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent,dtoStudent);
            return dtoStudent;
        }
        return null;
    }
}
