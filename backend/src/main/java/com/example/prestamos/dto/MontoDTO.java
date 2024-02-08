package com.example.prestamos.dto;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class MontoDTO {
    private Integer id;
    private String valor;
    private String descripcion;
    
}
