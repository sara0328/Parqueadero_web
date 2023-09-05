package com.example.Parqueadero.Controller;

import com.example.Parqueadero.Model.Vehiculo;
import com.example.Parqueadero.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoService.obtenerVehiculos();
    }

    @GetMapping("/{id}")
    public Vehiculo obtenerVehiculo(@PathVariable Long id) {
        return vehiculoService.obtenerVehiculo(id);
    }

    @PostMapping
    public Vehiculo crearVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoService.crearVehiculo(vehiculo);
    }

    /*@PutMapping("/{id}")
    public Vehiculo actualizarVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        Vehiculo vehiculoExistente = vehiculoService.obtenerVehiculo(id);
        if (vehiculoExistente != null) {
            vehiculoExistente.setTipo(vehiculo.getClass()); // Cambiado de getClass() a getTipo()
            vehiculoExistente.setDescripcion(vehiculo.getDescripcion());
            return vehiculoService.actualizarVehiculo(vehiculoExistente);
        } else {
            // Manejar el caso donde el vehiculo con el ID proporcionado no se encuentra (puedes lanzar una excepción o retornar una respuesta de error)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehiculo no encontrado");
        }
    }*/
    

    
    @DeleteMapping("/{id}")
    public void eliminarVehiculo(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
    }
}
