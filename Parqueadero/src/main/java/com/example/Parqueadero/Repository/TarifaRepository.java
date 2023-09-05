package com.example.Parqueadero.Repository;
import com.example.Parqueadero.Model.TipoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Parqueadero.Model.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    Tarifa findTarifaByTipoVehiculo(TipoVehiculo tipoVehiculo);
    Boolean existsTarifaByTipoVehiculo(TipoVehiculo tipoVehiculo);
}