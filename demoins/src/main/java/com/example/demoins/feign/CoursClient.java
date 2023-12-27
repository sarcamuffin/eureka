package com.example.demoins.feign;

import com.example.democours.dto.CoursDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="cours-service")
public interface CoursClient {
    @GetMapping("/cours/{idCours}")
    CoursDTO getCoursById(@PathVariable Long idCours);
}
