package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Tarifa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Parqueadero.Controller.TarifaController;
import com.example.Parqueadero.Repository.TarifaRepository;

@Service
public class TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<Tarifa> getAllTarifas() {
        return tarifaRepository.findAll();
    }

    public Tarifa getTarifaById(Long id) {
        return tarifaRepository.findById(id).orElse(null);
    }

    public Tarifa createTarifa(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public Tarifa updateTarifa(Long id, Tarifa tarifa) {
        tarifa.setId(id);
        return tarifaRepository.save(tarifa);
    }

    public void deleteTarifa(Long id) {
        tarifaRepository.deleteById(id);
    }
}
