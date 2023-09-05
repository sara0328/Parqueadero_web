package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Vehiculo;
import com.example.Parqueadero.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo obtenerVehiculo(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if (!vehiculo.isPresent()) {
            // manejar error, por ejemplo lanzar una excepción
        }
        return vehiculo.get();
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminarVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }
}
