// StudentService.java
package com.example.sample.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sample.demo.Entity.Student;
import com.example.sample.demo.Repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Long> getAllRollNumbers() {
        return studentRepository.findAllRollNumbers();
    }

    public String getStudentNameByRollNumber(Long rollNumber) {
        Student student = studentRepository.findByRollNumber(rollNumber);
        return (student != null) ? student.getName() : null;
    }
}
