package com.example.prestamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.prestamos.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
 
}
