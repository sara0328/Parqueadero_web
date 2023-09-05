package com.example.Parqueadero.Service;

import com.example.Parqueadero.Model.Piso;
import com.example.Parqueadero.Model.Tarifa;
import com.example.Parqueadero.Repository.PisoRepository;
import com.example.Parqueadero.Repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PisoService {

    @Autowired
    private PisoRepository pisoRepository;
    @Autowired
    private TarifaRepository tarifaRepository;

    public List<Piso> obtenerPisos() {
        return pisoRepository.findAll();
    }

    public Piso obtenerPiso(Long id) {
        Optional<Piso> piso = pisoRepository.findById(id);
        return piso.orElse(null);
    }

    public void crearPiso(Piso piso) {
        if (!tarifaRepository.existsTarifaByTipoVehiculo(piso.getTarifa().getTipoVehiculo())) {
            return;
        }
        Tarifa tarifa = tarifaRepository.findTarifaByTipoVehiculo(piso.getTarifa().getTipoVehiculo());
        piso.setTarifa(tarifa);
        pisoRepository.save(piso);
    }

    public Piso actualizarPiso(Piso piso) {
        return pisoRepository.save(piso);
    }

    public boolean eliminarPiso(Long id) {
        if(pisoRepository.existsById(id)) {
            pisoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Piso calcularEspaciosDisponibles(Long id, int espaciosOcupados) {
        Piso piso = obtenerPiso(id);
        if (piso != null) {
            int espaciosDisponibles = piso.getCapacidadMaxima() - espaciosOcupados;
    
            // Actualizar la cantidad de espacios disponibles en el objeto piso
            piso.setEspaciosDisponibles(espaciosDisponibles); 
    
            // Aquí podrías actualizar la lista de vehículos en el piso en función 
            // de los espacios ocupados, según la lógica de tu negocio
    
            return pisoRepository.save(piso);
        }
        return null;
    }
    

    public Piso crearPiso(Integer capacidadTotal, Tarifa tarifa) {
        Piso piso = new Piso();
        piso.setCapacidadTotal(capacidadTotal);
        piso.setCapacidadMaxima(capacidadTotal); // Asumo que la capacidad máxima inicialmente es igual a la capacidad total.
        piso.setTarifa(tarifa);
        return pisoRepository.save(piso);   
    }

    public Piso getPisoById(Long id) {
        return obtenerPiso(id); // Simplificado para utilizar el método obtenerPiso
    }
}
