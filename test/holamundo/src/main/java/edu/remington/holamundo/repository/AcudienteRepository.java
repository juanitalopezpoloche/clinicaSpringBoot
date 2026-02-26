package edu.remington.holamundo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.remington.holamundo.model.Acudiente;


public interface AcudienteRepository extends JpaRepository<Acudiente, Long>{
    Optional<Acudiente> findByDocumento(String documento);
}
