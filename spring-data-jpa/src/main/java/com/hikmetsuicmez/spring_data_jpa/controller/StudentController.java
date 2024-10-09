package com.hikmetsuicmez.spring_data_jpa.controller;

import com.hikmetsuicmez.spring_data_jpa.dto.DtoStudent;
import com.hikmetsuicmez.spring_data_jpa.dto.DtoStudentIU;
import com.hikmetsuicmez.spring_data_jpa.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/save")
    public DtoStudent addStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentService.addStudent(dtoStudentIU);
    }

    @GetMapping("/list")
    public List<DtoStudent> getAllStudents() {
        return studentService.retrieveAllStudents();
    }

    @GetMapping("/{id}")
    public DtoStudent getStudentById(@PathVariable Long id) {
        return studentService.retrieveStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/{id}")
    public DtoStudent updateStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU, @PathVariable Long id) {
        return studentService.updateStudent(id, dtoStudentIU);
    }
}
