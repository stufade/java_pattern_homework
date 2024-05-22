package com.example.hw_15.controller;

import com.example.hw_15.model.University;
import com.example.hw_15.repository.UniversityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityRepository universityRepository;

    public UniversityController(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    // Получение списка всех университетов
    @GetMapping
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    // Создание нового университета
    @PostMapping
    public University createUniversity(@RequestBody University university) {
        return universityRepository.save(university);
    }

    // Удаление университета по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
