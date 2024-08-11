package com.example.studentcrud.service.impl;

import com.example.studentcrud.dto.StudentDTO;
import com.example.studentcrud.entity.Student;
import com.example.studentcrud.repository.StudentRepository;
import com.example.studentcrud.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()
                        -> new RuntimeException("Student not found"));
        return StudentDTO.builder()
                .fullName(student.getFullName())
                .age(student.getAge())
                .address(student.getAddress())
                .phoneNumber(student.getPhoneNumber())
                .googleAccountId(student.getGoogleAccountId())
                .facebookAccountId(student.getFacebookAccountId())
                .build();
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = Student.builder()
                .fullName(studentDTO.getFullName())
                .age(studentDTO.getAge())
                .address(studentDTO.getAddress())
                .phoneNumber(studentDTO.getPhoneNumber())
                .googleAccountId(studentDTO.getGoogleAccountId())
                .facebookAccountId(studentDTO.getFacebookAccountId())
                .build();

        Student savedStudent = studentRepository.save(student);

        return StudentDTO.builder()
                .fullName(savedStudent.getFullName())
                .age(savedStudent.getAge())
                .address(savedStudent.getAddress())
                .phoneNumber(savedStudent.getPhoneNumber())
                .googleAccountId(savedStudent.getGoogleAccountId())
                .facebookAccountId(savedStudent.getFacebookAccountId())
                .build();
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setFullName(studentDetails.getFullName());
        student.setAge(studentDetails.getAge());
        student.setAddress(studentDetails.getAddress());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setGoogleAccountId(studentDetails.getGoogleAccountId());
        student.setFacebookAccountId(studentDetails.getFacebookAccountId());
        Student updatedStudent = studentRepository.save(student);

        return StudentDTO.builder()
                .fullName(updatedStudent.getFullName())
                .age(updatedStudent.getAge())
                .address(updatedStudent.getAddress())
                .phoneNumber(updatedStudent.getPhoneNumber())
                .googleAccountId(updatedStudent.getGoogleAccountId())
                .facebookAccountId(updatedStudent.getFacebookAccountId())
                .build();
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found");
        }
        studentRepository.deleteById(id);
    }
}
