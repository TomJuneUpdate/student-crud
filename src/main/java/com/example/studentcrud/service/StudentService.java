package com.example.studentcrud.service;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO createStudent(StudentDTO studentDTO);
    void deleteStudent(Long id);

    StudentDTO updateStudent(Long id, StudentDTO studentDetails);
}
