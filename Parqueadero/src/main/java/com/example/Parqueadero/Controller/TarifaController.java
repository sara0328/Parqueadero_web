package com.example.Parqueadero.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.example.Parqueadero.Model.Tarifa;
import com.example.Parqueadero.Service.TarifaService;

@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    @GetMapping
    public List<Tarifa> getAllTarifas() {
        return tarifaService.getAllTarifas();
    }

    @GetMapping("/{id}")
    public Tarifa getTarifaById(@PathVariable Long id) {
        return tarifaService.getTarifaById(id);
    }

    @PostMapping
    public Tarifa createTarifa(@RequestBody Tarifa tarifa) {
        return tarifaService.createTarifa(tarifa);
    }

    @PutMapping("/{id}")
    public Tarifa updateTarifa(@PathVariable Long id, @RequestBody Tarifa tarifa) {
        return tarifaService.updateTarifa(id, tarifa);
    }

    @DeleteMapping("/{id}")
    public void deleteTarifa(@PathVariable Long id) {
        tarifaService.deleteTarifa(id);
    }
}
