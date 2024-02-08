package com.example.prestamos.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class TablaDTO {
    private Integer nPago;
    private String fecha;
    private double prestamo;
    private double interes;
    private double abono;
}
