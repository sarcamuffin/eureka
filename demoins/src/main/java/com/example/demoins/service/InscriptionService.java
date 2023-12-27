package com.example.demoins.service;

import com.example.democours.dto.CoursDTO;
import com.example.demoins.dto.InscriptionDTO;
import com.example.demoins.entity.InscriptionEntity;
import com.example.demostudent.dto.UserDTO;

import java.util.List;

public interface InscriptionService {
    List<CoursDTO> getCoursByEtudiant(Long etudiantId);

    List<UserDTO> getEtudiantsByCours(Long coursId);

    List<InscriptionDTO> getAllInscriptions();
    InscriptionEntity createInscription(InscriptionDTO inscriptionDTO);
}
