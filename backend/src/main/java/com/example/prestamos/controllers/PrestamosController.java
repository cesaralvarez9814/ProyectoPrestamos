package com.example.prestamos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.prestamos.dto.RespuestaPrestamoDTO;
import com.example.prestamos.dto.RespuestaTablaDTO;
import com.example.prestamos.entity.Prestamos;
import com.example.prestamos.services.PrestamosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@RestController
@RequestMapping("/prestamos" )
public class PrestamosController {
    @Autowired
    private PrestamosService service;
    @PostMapping
    @CrossOrigin(origins = "*")
    public void createPrestamo(@RequestBody Prestamos p){
        service.createPrestamo(p);
    }
    @GetMapping
    @CrossOrigin(origins = "*")
    public @ResponseBody List<RespuestaPrestamoDTO> getPrestamos(){
        return service.getPrestamos();
    }

    @GetMapping("/tabla/{idPrestamo}")
    @CrossOrigin(origins = "*")
    public @ResponseBody RespuestaTablaDTO getTabla(@PathVariable("idPrestamo") Integer id) {
        return service.getTablaAmortizacion(id);
    }
    
}
