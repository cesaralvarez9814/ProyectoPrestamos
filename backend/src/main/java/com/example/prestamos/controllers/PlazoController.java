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


import com.example.prestamos.dto.PlazoDTO;
import com.example.prestamos.entity.Plazo;
import com.example.prestamos.services.PrestamosService;

@RestController
@RequestMapping("/plazos" )
public class PlazoController {
    @Autowired
    private PrestamosService service;
    @PostMapping
    public void createPlazos(@RequestBody PlazoDTO p){
        service.createPlazo(p);
    }
    @GetMapping
    @CrossOrigin(origins = "*")
    public @ResponseBody List<Plazo> obtenerPlazos(){
        return service.getPlazos();
    }

    
}
