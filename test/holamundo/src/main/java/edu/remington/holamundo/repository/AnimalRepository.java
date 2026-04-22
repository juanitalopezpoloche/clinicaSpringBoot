package edu.remington.holamundo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.remington.holamundo.model.Animal;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    List<Animal> findByAcudienteDocumento(String documento);
    List<Animal> findByAcudienteId(Long acudienteId);
}
