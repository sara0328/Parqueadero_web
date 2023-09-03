package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Piso;
import com.example.Parqueadero.Repository.PisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PisoService {

    @Autowired
    private PisoRepository pisoRepository;

    public List<Piso> obtenerPisos() {
        return pisoRepository.findAll();
    }

    public Piso obtenerPiso(Long id) {
        Optional<Piso> piso = pisoRepository.findById(id);
        if (!piso.isPresent()) {
            // manejar error, por ejemplo lanzar una excepción
        }
        return piso.get();
    }

    public Piso crearPiso(Piso piso) {
        return pisoRepository.save(piso);
    }

    public Piso actualizarPiso(Piso piso) {
        return pisoRepository.save(piso);
    }

    public void eliminarPiso(Long id) {
        pisoRepository.deleteById(id);
    }

    public Piso especificarTipoVehiculo(Long id, String tipoVehiculo) {
        Piso piso = obtenerPiso(id);
        piso.setTipoVehiculo(tipoVehiculo);
        return pisoRepository.save(piso);
    }

    public Piso calcularEspaciosDisponibles(Long id, int espaciosOcupados) {
        Piso piso = obtenerPiso(id);
        int espaciosDisponibles = piso.getEspaciosTotales() - espaciosOcupados;
        piso.setEspaciosDisponibles(espaciosDisponibles);
        return pisoRepository.save(piso);
    }
}
