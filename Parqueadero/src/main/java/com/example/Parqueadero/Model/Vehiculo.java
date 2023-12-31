package com.example.Parqueadero.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoVehiculo tipo; // AUTOMOVIL, BUS, MOTO
    private String descripcion;

    @ManyToOne
    private Piso piso;

    public Vehiculo() {
        // Constructor por defecto
    }

    public Vehiculo(Long id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = TipoVehiculo.valueOf(tipo.toUpperCase());
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }


    public String getTipo() {
        return tipo.toString();
    }

    public void setTipo(String tipo) {
        this.tipo = TipoVehiculo.valueOf(tipo.toUpperCase());
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}