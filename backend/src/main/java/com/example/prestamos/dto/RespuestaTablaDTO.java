package com.example.prestamos.dto;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class RespuestaTablaDTO {
    private String nombreCliente;
    private Integer numPagos;
    private List<TablaDTO> valores;
    private Integer sumPrestamo;
    private Double sumInteres;
    private Double sumAbono;
}
