package com.example.Parqueadero.Controller;


import java.util.Arrays;
import java.util.List;

import com.example.Parqueadero.Model.Piso;
import com.example.Parqueadero.Model.TipoVehiculo;
import com.example.Parqueadero.data.ListadoTarifas;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonFactoryBean;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    /*
    @PostMapping
    public Tarifa createTarifa(@RequestBody Tarifa tarifa) {
        return tarifaService.createTarifa(tarifa);
    }
    */

    @GetMapping("/crear")
    public ModelAndView crearTarifa () {
        Tarifa tarifa = new Tarifa(TipoVehiculo.NINGUNO);
        ModelAndView tarifaCreateView = new ModelAndView("crear_tarifa");
        tarifaCreateView.addObject("tarifa", tarifa);
        tarifaCreateView.addObject("tiposVehiculos", TipoVehiculo.values());
        return tarifaCreateView;
    }

    @PostMapping("/guardar")
    public RedirectView updateTarifa(@ModelAttribute("tarifa") Tarifa tarifa) {
        tarifaService.updateTarifa(tarifa);
        return new RedirectView("/api/pisos/");
    }

    /*
    @PutMapping("/{id}")
    public Tarifa updateTarifa(@PathVariable Long id, @RequestBody Tarifa tarifa) {
        return tarifaService.updateTarifa(tarifa);
    }

     */

    @DeleteMapping("/{id}")
    public void deleteTarifa(@PathVariable Long id) {
        tarifaService.deleteTarifa(id);
    }
}
