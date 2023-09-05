package com.example.Parqueadero.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

@Entity
public class Tarifa {

    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    private Double tarifaPorMinuto;

    public Tarifa() {
    }

    public Tarifa(Long id, Vehiculo vehiculo, Double tarifaPorMinuto) {
        this.id = id;
        this.vehiculo = vehiculo;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
                ", vehiculo=" + vehiculo +
                ", tarifaPorMinuto=" + tarifaPorMinuto +
                '}';
    }
}
