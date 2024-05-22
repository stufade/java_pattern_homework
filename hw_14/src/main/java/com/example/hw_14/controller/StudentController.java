package com.example.hw_14.controller;

import com.example.hw_14.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final Map<Integer, Student> students = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public Collection<Student> getAllStudents() {
        return students.values();
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        int id = counter.incrementAndGet();
        students.put(id, student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        students.remove(id);
        return ResponseEntity.ok().build();
    }
}
