package com.example.prestamos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.prestamos.dto.ClienteDTO;
import com.example.prestamos.entity.Cliente;
import com.example.prestamos.services.PrestamosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@RequestMapping("/clientes" )
public class ClienteController {
    @Autowired
    private PrestamosService service;
    @PostMapping
    public void createCliente(@RequestBody ClienteDTO c){
        service.createCliente(c);
    }
    @GetMapping
    @CrossOrigin(origins = "*")
    public @ResponseBody List<Cliente> getClientes(){
        return service.getClientes();
    }
}
