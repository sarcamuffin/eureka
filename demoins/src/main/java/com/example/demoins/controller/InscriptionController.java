package com.example.demoins.controller;

//import com.example.democours.dto.CoursDTO;
import com.example.democours.dto.CoursDTO;
import com.example.demoins.dto.InscriptionDTO;
import com.example.demoins.entity.InscriptionEntity;
import com.example.demoins.service.InscriptionService;
import com.example.demostudent.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;
    @GetMapping("/cours/{coursId}")
    public List<UserDTO> getEtudiantCours(@PathVariable Long coursId) {
        return inscriptionService.getEtudiantsByCours(coursId);
    }
    @PostMapping
    public InscriptionEntity createInscription(@RequestBody InscriptionDTO inscriptionDTO) {
        // Call InscriptionService to create the inscription
        return inscriptionService.createInscription(inscriptionDTO);
    }
    @GetMapping("/etudiant/{etudiantId}")
    public List<CoursDTO> getCoursEtudiants(@PathVariable Long etudiantId) {
        return inscriptionService.getCoursByEtudiant(etudiantId);
    }

    @GetMapping("/inscription/inscriptions")
    public List<InscriptionDTO> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }


}
