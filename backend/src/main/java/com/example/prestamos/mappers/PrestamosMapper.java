package com.example.prestamos.mappers;
import org.modelmapper.ModelMapper;

import com.example.prestamos.dto.PrestamoDTO;
import com.example.prestamos.entity.Prestamos;

public class PrestamosMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    public static PrestamoDTO mapPrestamos(Prestamos p) {
        return MAPPER.map(p, PrestamoDTO.class);
    }

    public static Prestamos mapPrestamosDTO(PrestamoDTO p) {
        return MAPPER.map(p, Prestamos.class);
    }
}

