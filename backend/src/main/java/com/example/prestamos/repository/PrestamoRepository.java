package com.example.prestamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.prestamos.entity.Prestamos;

public interface PrestamoRepository extends JpaRepository<Prestamos,Integer> {

}
