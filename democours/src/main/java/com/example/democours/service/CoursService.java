package com.example.democours.service;

import com.example.democours.dto.CoursDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CoursService {
    CoursDTO createCours(CoursDTO coursDTO);
    List<CoursDTO> getAllCours();
    CoursDTO getCoursById(Long id);
    CoursDTO updateCours(Long id, CoursDTO updatedCoursDTO);
    void deleteCours(Long id);
}
