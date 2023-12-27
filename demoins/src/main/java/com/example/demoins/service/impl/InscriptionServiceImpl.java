package com.example.demoins.service.impl;

import com.example.democours.dto.CoursDTO;
import com.example.demoins.dto.InscriptionDTO;
import com.example.demoins.entity.InscriptionEntity;
import com.example.demoins.feign.CoursClient;
import com.example.demoins.feign.EtudiantClient;
import com.example.demoins.repository.InscriptionRepository;
import com.example.demoins.service.InscriptionService;
import com.example.demostudent.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EtudiantClient etudiantClient;

    @Autowired
    private CoursClient coursClient;

    @Override
    public List<CoursDTO> getCoursByEtudiant(Long etudiantId) {
        List<InscriptionEntity> inscriptionList = inscriptionRepository.getAllByIdUser(etudiantId);

        return inscriptionList.stream()
                .map(inscription -> coursClient.getCoursById(inscription.getIdCours()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getEtudiantsByCours(Long coursId) {
        List<InscriptionEntity> inscriptionList = inscriptionRepository.getAllByIdCours(coursId);
        return inscriptionList.stream()
                .map(inscription -> etudiantClient.getUserById(inscription.getIdUser()))
                .collect(Collectors.toList());
    }
    @Override
    public InscriptionEntity createInscription(InscriptionDTO inscriptionDTO) {
        UserDTO userDTO = etudiantClient.getUserById(inscriptionDTO.getUserId());
        CoursDTO courseDTO = coursClient.getCoursById(inscriptionDTO.getCoursId());

        InscriptionEntity inscription = new InscriptionEntity(userDTO.getId(), courseDTO.getId(), LocalDate.now().toString());
        InscriptionEntity savedInscription = inscriptionRepository.save(inscription);
        return savedInscription;
    }
    @Override
    public List<InscriptionDTO> getAllInscriptions() {
        return inscriptionRepository.findAll().stream().map(inscription -> {
            InscriptionDTO InscriptionDTO = new InscriptionDTO();
            InscriptionDTO.setId(inscription.getId());
            InscriptionDTO.setUserId(etudiantClient.getUserById(inscription.getIdUser()).getId());
            InscriptionDTO.setCoursId(coursClient.getCoursById(inscription.getIdCours()).getId());
            InscriptionDTO.setDate(inscription.getDate());

            return InscriptionDTO;
        }).collect(Collectors.toList());
    }

    /*private InscriptionDTO convertToDTO(InscriptionEntity inscription, UserDTO userDTO, CoursDTO coursDTO) {
        InscriptionDTO inscriptionDTO = new InscriptionDTO();
        inscriptionDTO.setId(inscription.getId());
        inscriptionDTO.setUserDTO(inscription.getIdUser());
        inscriptionDTO.setCoursDTO(inscription.getIdCours());

        return inscriptionDTO;
    }*/



}
