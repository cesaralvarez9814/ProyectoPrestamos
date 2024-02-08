package com.example.prestamos.dto;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class RespuestaPrestamoDTO {
    private Integer idPrestamo;
    private String nombreCliente;
    private Integer monto;
    private Integer plazo;
}
