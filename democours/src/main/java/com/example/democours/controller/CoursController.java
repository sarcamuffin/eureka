package com.example.democours.controller;
import com.example.democours.dto.CoursDTO;
import com.example.democours.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @PostMapping
    public CoursDTO createCours(@RequestBody CoursDTO coursDTO) {
        return coursService.createCours(coursDTO);
    }

    @GetMapping
    public List<CoursDTO> getAllCours() {
        return coursService.getAllCours();
    }

    @GetMapping("/{id}")
    public CoursDTO getCoursById(@PathVariable Long id) {
        return coursService.getCoursById(id);
    }

    @PutMapping("/{id}")
    public CoursDTO updateCours(@PathVariable Long id, @RequestBody CoursDTO updatedCoursDTO) {
        return coursService.updateCours(id, updatedCoursDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }
}
