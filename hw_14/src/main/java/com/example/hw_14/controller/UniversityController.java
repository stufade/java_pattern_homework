package com.example.hw_14.controller;

import com.example.hw_14.model.University;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final Map<Integer, University> universities = new HashMap<>();
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public Collection<University> getAllUniversities() {
        return universities.values();
    }

    @PostMapping
    public ResponseEntity<University> createUniversity(@RequestBody University university) {
        int id = counter.incrementAndGet();
        universities.put(id, university);
        return ResponseEntity.ok(university);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Integer id) {
        universities.remove(id);
        return ResponseEntity.ok().build();
    }
}
