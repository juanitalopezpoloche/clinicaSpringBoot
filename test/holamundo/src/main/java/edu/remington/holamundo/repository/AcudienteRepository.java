package edu.remington.holamundo.repository;
import java.util.Optional;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.remington.holamundo.model.Acudiente;


public interface AcudienteRepository extends JpaRepository<Acudiente, Long>{
    Optional<Acudiente> findByDocumento(String documento);
    Page<Acudiente> findAll(Pageable pageable);
}
