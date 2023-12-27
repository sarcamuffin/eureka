package com.example.demoins.dto;

import com.example.democours.dto.CoursDTO;
import com.example.demostudent.dto.UserDTO;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class InscriptionDTO {

    private Long id;

    private Long userId;
    private Long coursId ;

    private String date;
}
