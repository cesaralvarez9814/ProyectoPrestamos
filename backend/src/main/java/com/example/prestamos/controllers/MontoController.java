package com.example.prestamos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prestamos.dto.MontoDTO;
import com.example.prestamos.services.PrestamosService;

import com.example.prestamos.entity.Monto;

@RestController
@RequestMapping("/montos" )
public class MontoController {
    @Autowired
    private PrestamosService service;
    @PostMapping
    public void createMontos(@RequestBody MontoDTO m){
        service.createMonto(m);
    }
    @GetMapping
    @CrossOrigin(origins = "*")
    public @ResponseBody List<Monto> obtenerMontos(){
        return service.getMontos();
    }
}
