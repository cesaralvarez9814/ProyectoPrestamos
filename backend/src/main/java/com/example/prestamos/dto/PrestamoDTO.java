package com.example.prestamos.dto;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class PrestamoDTO {
    private Integer id;
    private ClienteDTO cliente;
    private PlazoDTO plazo;
    private MontoDTO monto;
    private String fechaPrestamo;
}
