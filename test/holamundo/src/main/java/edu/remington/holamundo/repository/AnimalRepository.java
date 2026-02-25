package edu.remington.holamundo.repository;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import edu.remington.holamundo.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    Optional<Animal> findByDocumentoAcudiente(String documentoAcudiente);
    Page<Animal> findAll(Pageable pageable);
}
