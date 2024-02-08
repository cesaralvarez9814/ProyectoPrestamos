package com.example.prestamos.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ClienteDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
