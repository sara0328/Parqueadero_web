package com.example.Parqueadero.Repository;

import com.example.Parqueadero.Model.Piso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisoRepository extends JpaRepository<Piso, Long> {
    boolean existsPisoByNumeroPiso(Long numeroPiso);
}