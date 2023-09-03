package com.example.Parqueadero.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Parqueadero.Model.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
}