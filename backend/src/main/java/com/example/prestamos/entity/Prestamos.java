package com.example.prestamos.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prestamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id", unique = false)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "monto_id", referencedColumnName = "id", unique = false)
    private Monto monto;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plazo_id", referencedColumnName = "id", unique = false)
    private Plazo plazo;
    
    @Basic
    private String fechaPrestamo;

}
