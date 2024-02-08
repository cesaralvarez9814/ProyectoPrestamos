package com.example.prestamos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.prestamos.dto.ClienteDTO;
import com.example.prestamos.dto.MontoDTO;
import com.example.prestamos.dto.PlazoDTO;
import com.example.prestamos.dto.RespuestaPrestamoDTO;
import com.example.prestamos.dto.RespuestaTablaDTO;
import com.example.prestamos.entity.Cliente;
import com.example.prestamos.entity.Monto;
import com.example.prestamos.entity.Plazo;
import com.example.prestamos.entity.Prestamos;

@Service
public interface PrestamosService {
    public void createCliente(ClienteDTO c);
    public List<Cliente> getClientes();
    public void createMonto(MontoDTO m);
    public List<Monto> getMontos();
    public void createPlazo(PlazoDTO p);
    public List<Plazo> getPlazos();
    public void createPrestamo(Prestamos p);
    public List<RespuestaPrestamoDTO> getPrestamos();
    public RespuestaTablaDTO getTablaAmortizacion(Integer id);
}
