package com.example.Parqueadero.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Piso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int espaciosTotales;
    private int capacidadTotal;
    private Integer capacidadMaxima; // Nueva propiedad
    private int espaciosDisponibles;

     @OneToMany(mappedBy = "piso")
    private List<Vehiculo> vehiculos;  // Lista de vehículos en este piso

    // Constructor con todos los campos necesarios
    public Piso(Long id, int espaciosTotales, int capacidadTotal, Integer capacidadMaxima, Tarifa tarifa) {
        this.id = id;
        this.espaciosTotales = espaciosTotales;
        this.capacidadTotal = capacidadTotal;
        this.capacidadMaxima = capacidadMaxima;
        this.tarifa = tarifa;
    }

    public Piso() {
    }

    // un constructor con argumentos
    public Piso(Long id) {
        this.id = id;
    }
    
    public Piso(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
    @ManyToOne
    @JoinColumn(name = "tarifa_id")
    private Tarifa tarifa;

    // getters y setters

    public Piso(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidadTotal() {
        return capacidadTotal;
    }

    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getEspaciosTotales() {
        return espaciosTotales;
    }
    
    public void setEspaciosTotales(int espaciosTotales) {
        this.espaciosTotales = espaciosTotales;
    }

    public void setEspaciosDisponibles(int espaciosDisponibles) {
        this.espaciosDisponibles = espaciosDisponibles;
    }
    

    public Integer getEspaciosDisponibles() {
        return espaciosTotales - (vehiculos != null ? vehiculos.size() : 0);
    }
}

