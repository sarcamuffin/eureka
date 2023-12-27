package com.example.democours.service.Impl;

import com.example.democours.dto.CoursDTO;
import com.example.democours.entity.Cours;
import com.example.democours.repository.CoursRepository;
import com.example.democours.service.CoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public CoursDTO createCours(CoursDTO coursDTO) {
        Cours cours = new Cours();
        cours.setName(coursDTO.getName());
        // Set other fields as needed
        Cours savedCours = coursRepository.save(cours);
        return convertToDTO(savedCours);
    }

    @Override
    public List<CoursDTO> getAllCours() {
        List<Cours> cours = coursRepository.findAll();
        return cours.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CoursDTO getCoursById(Long id) {
        return coursRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public CoursDTO updateCours(Long id, CoursDTO updatedCoursDTO) {
        Cours cours = coursRepository.findById(id).orElse(null);
        if (cours!= null) {
            cours.setName(updatedCoursDTO.getName());
            // Set other fields as needed
            Cours updatedCours = coursRepository.save(cours);
            return convertToDTO(updatedCours);
        }
        return null;
    }

    @Override
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

    private CoursDTO convertToDTO(Cours cours) {
        CoursDTO coursDTO = new CoursDTO();
        coursDTO.setId(cours.getId());
        coursDTO.setName(cours.getName());
        // Set other fields as needed
        return coursDTO;
    }
}
