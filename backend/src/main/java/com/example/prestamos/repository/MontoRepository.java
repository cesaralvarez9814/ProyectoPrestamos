package com.example.prestamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestamos.entity.Monto;

public interface MontoRepository extends JpaRepository<Monto,Integer> {

}
