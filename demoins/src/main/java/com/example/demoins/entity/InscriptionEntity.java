package com.example.demoins.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="inscriptions")
public class InscriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private Long idUser;
    @Column(nullable=false)
    private Long idCours;

    private String date;

    public InscriptionEntity(Long idUser, Long idCours, String date) {
        this.idUser = idUser;
        this.idCours = idCours;
        this.date = date;
    }
}
