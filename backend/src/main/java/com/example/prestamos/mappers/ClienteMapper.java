package com.example.prestamos.mappers;
import org.modelmapper.ModelMapper;

import com.example.prestamos.dto.ClienteDTO;
import com.example.prestamos.entity.Cliente;

public class ClienteMapper {
    private static final ModelMapper MAPPER = new ModelMapper();

    public static ClienteDTO mapCliente(Cliente c) {
        return MAPPER.map(c, ClienteDTO.class);
    }

    public static Cliente mapClienteDTO(ClienteDTO c) {
        return MAPPER.map(c, Cliente.class);
    }
}
