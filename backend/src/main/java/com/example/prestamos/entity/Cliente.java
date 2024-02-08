package com.example.prestamos.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    @Column(nullable = false)
    private String firstName;
    @Basic
    @Column(nullable = false)
    private String lastName;
    @Basic
    private String email;
    

}
