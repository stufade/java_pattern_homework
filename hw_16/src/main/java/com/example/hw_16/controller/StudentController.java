package com.example.hw_16.controller;

import com.example.hw_16.model.Student;
import com.example.hw_16.model.University;
import com.example.hw_16.repository.StudentRepository;
import com.example.hw_16.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

class UniversityIdRequest {
    private Long universityId;
    private Student student;

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    public StudentController(StudentRepository studentRepository, UniversityRepository universityRepository) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody UniversityIdRequest universityIdRequest) {
        Long universityId = universityIdRequest.getUniversityId();
        Student student = universityIdRequest.getStudent();

        University university = universityRepository.findById(universityId)
                .orElseThrow(() -> new RuntimeException("University not found with id: " + universityId));

        student.setUniversity(university);
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
