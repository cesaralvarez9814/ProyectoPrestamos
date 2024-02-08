package com.example.prestamos.mappers;
import org.modelmapper.ModelMapper;

import com.example.prestamos.dto.PlazoDTO;
import com.example.prestamos.entity.Plazo;

public class PlazoMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    public static PlazoDTO mapPlazo(Plazo m) {
        return MAPPER.map(m, PlazoDTO.class);
    }

    public static Plazo mapPlazoDTO(PlazoDTO m) {
        return MAPPER.map(m, Plazo.class);
    }
}
