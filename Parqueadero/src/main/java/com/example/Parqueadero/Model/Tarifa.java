package com.example.Parqueadero.Model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@Entity
public class Tarifa {

    @Id
    private Long id;
    
    @NonNull
    private String tipoVehiculo; // Por ejemplo: "AUTO", "MOTO", etc.
    
    @NonNull
    private Double tarifaPorMinuto;

    public Tarifa() {
    }

    public Tarifa(Long id, String tipoVehiculo, Double tarifaPorMinuto) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

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

    public Double getTarifaPorMinuto() {
        return tarifaPorMinuto;
    }

    public void setTarifaPorMinuto(Double tarifaPorMinuto) {
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "id=" + id +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", tarifaPorMinuto=" + tarifaPorMinuto +
                '}';
    }
}