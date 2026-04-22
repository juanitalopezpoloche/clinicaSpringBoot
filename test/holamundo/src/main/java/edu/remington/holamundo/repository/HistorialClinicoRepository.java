package edu.remington.holamundo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import edu.remington.holamundo.model.HistorialClinico;
import java.util.List;

public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long>{
    Optional<HistorialClinico> findById(Long id);
    List<HistorialClinico> findByAnimalId(Long animalId);
}
