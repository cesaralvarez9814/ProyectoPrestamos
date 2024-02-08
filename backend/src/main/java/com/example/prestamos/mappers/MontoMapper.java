package com.example.prestamos.mappers;
import org.modelmapper.ModelMapper;

import com.example.prestamos.dto.MontoDTO;
import com.example.prestamos.entity.Monto;

public class MontoMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    public static MontoDTO mapMonto(Monto m) {
        return MAPPER.map(m, MontoDTO.class);
    }

    public static Monto mapMontoDTO(MontoDTO m) {
        return MAPPER.map(m, Monto.class);
    }
}
