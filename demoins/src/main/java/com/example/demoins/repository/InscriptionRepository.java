package com.example.demoins.repository;

import com.example.demoins.entity.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
    public List<InscriptionEntity> getAllByIdUser(Long IdUser);
    public List<InscriptionEntity> getAllByIdCours(Long IdCours);


}
