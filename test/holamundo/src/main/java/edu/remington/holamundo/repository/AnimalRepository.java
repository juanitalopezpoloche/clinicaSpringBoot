package edu.remington.holamundo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import edu.remington.holamundo.model.Acudiente;
import edu.remington.holamundo.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    Optional<Acudiente> findByDocumento(String documento);
}
