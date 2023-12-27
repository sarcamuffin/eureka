package com.example.demoins.feign;

import com.example.demostudent.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service")
public interface EtudiantClient {
    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id);
}
