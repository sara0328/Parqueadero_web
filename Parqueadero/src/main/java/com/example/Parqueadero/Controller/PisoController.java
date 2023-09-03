package com.example.Parqueadero.Controller;
import com.example.Parqueadero.Model.Piso;
import com.example.Parqueadero.Service.PisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pisos")
public class PisoController {

    @Autowired
    private PisoService pisoService;

    @GetMapping
    public List<Piso> obtenerPisos() {
        return pisoService.obtenerPisos();
    }

    @GetMapping("/{id}")
    public Piso obtenerPiso(@PathVariable Long id) {
        return pisoService.obtenerPiso(id);
    }

    @PostMapping
    public Piso crearPiso(@RequestBody Piso piso) {
        return pisoService.crearPiso(piso);
    }

    @PutMapping("/{id}")
    public Piso actualizarPiso(@PathVariable Long id, @RequestBody Piso piso) {
        piso.setId(id);
        return pisoService.actualizarPiso(piso);
    }

    @DeleteMapping("/{id}")
    public void eliminarPiso(@PathVariable Long id) {
        pisoService.eliminarPiso(id);
    }

    @PutMapping("/{id}/tipoVehiculo")
    public Piso especificarTipoVehiculo(@PathVariable Long id, @RequestParam String tipoVehiculo) {
        return pisoService.especificarTipoVehiculo(id, tipoVehiculo);
    }

    @PutMapping("/{id}/espaciosDisponibles")
    public Piso calcularEspaciosDisponibles(@PathVariable Long id, @RequestParam int espaciosOcupados) {
        return pisoService.calcularEspaciosDisponibles(id, espaciosOcupados);
    }
}
