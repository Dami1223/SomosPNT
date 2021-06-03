package com.dosideas.repository;

import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    List<Provincia> findByNombre(String nombre);

    List<Provincia> findByNombreContaining(String nombre);

}
