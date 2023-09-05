package com.example.Parqueadero.Model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarifa {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @NonNull
    private TipoVehiculo tipoVehiculo; // Por ejemplo: "AUTO", "MOTO", etc.
    
    @NonNull
    private Double tarifaPorMinuto;

    public Tarifa() {
        tipoVehiculo = TipoVehiculo.NINGUNO;
    }

    public Tarifa(Long id, TipoVehiculo tipoVehiculo, Double tarifaPorMinuto) {
        this.id = id;
        this.tipoVehiculo = tipoVehiculo;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

    public Tarifa (TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
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