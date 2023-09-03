package com.example.Parqueadero.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Piso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoVehiculo;
    private int espaciosTotales;
    private int espaciosDisponibles;

    // getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getEspaciosTotales() {
        return espaciosTotales;
    }

    public void setEspaciosTotales(int espaciosTotales) {
        this.espaciosTotales = espaciosTotales;
    }

    public int getEspaciosDisponibles() {
        return espaciosDisponibles;
    }

    public void setEspaciosDisponibles(int espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }
}

