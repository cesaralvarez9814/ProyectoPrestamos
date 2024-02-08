package com.example.prestamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestamos.entity.Plazo;

public interface PlazoRepository extends JpaRepository<Plazo,Integer> {

}
