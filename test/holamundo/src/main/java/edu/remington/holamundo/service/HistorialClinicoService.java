package edu.remington.holamundo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.remington.holamundo.dto.HistorialClinicoRequest;
import edu.remington.holamundo.dto.HistorialClinicoResponse;
import edu.remington.holamundo.model.Animal;
import edu.remington.holamundo.model.HistorialClinico;
import edu.remington.holamundo.repository.AnimalRepository;
import edu.remington.holamundo.repository.HistorialClinicoRepository;

@Service
@Transactional
public class HistorialClinicoService {

    private final HistorialClinicoRepository historialRepository;
    private final AnimalRepository animalRepository;

    public HistorialClinicoService(HistorialClinicoRepository historialRepository, AnimalRepository animalRepository) {
        this.historialRepository = historialRepository;
        this.animalRepository = animalRepository;
    }

    public HistorialClinicoResponse crear(HistorialClinicoRequest request) {
        HistorialClinico historial = new HistorialClinico();
        Animal animal = findAnimal(request.getAnimalId());
        applyRequest(historial, request, animal);
        HistorialClinico saved = historialRepository.save(historial);
        return toResponse(saved);
    }

    public HistorialClinicoResponse actualizar(Long id, HistorialClinicoRequest request) {
        HistorialClinico historial = findHistorialClinico(id);
        Animal animal = findAnimal(request.getAnimalId());
        applyRequest(historial, request, animal);
        HistorialClinico updated = historialRepository.save(historial);
        return toResponse(updated);
    }

    public void eliminar(Long id) {
        HistorialClinico historial = findHistorialClinico(id);
        historialRepository.delete(historial);
    }

    @Transactional(readOnly = true)
    public Page<HistorialClinicoResponse> listar(Pageable pageable) {
        return historialRepository.findAll(pageable)
                .map(this::toResponse);
    }

    @Transactional(readOnly = true)
    public HistorialClinicoResponse obtenerPorId(Long id) {
        HistorialClinico historial = findHistorialClinico(id);
        return toResponse(historial);
    }    

    private HistorialClinico findHistorialClinico(Long id) {
        return historialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial clínico no encontrado con id " + id));
    }

    private Animal findAnimal(Long id){
        return animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal no encontrado con id " + id));
    }

    private void applyRequest(HistorialClinico historial, HistorialClinicoRequest request, Animal animal) {
        historial.setFechaNacimiento(request.getFechaNacimiento());
        historial.setMotivoConsulta(request.getMotivoConsulta());
        historial.setDiagnostico(request.getDiagnostico());
        historial.setTratamiento(request.getTratamiento());
        historial.setMedicamentos(request.getMedicamentos());
        historial.setObservaciones(request.getObservaciones());
        historial.setVeterinario(request.getVeterinario());
        historial.setAnimal(animal);
    }

    private HistorialClinicoResponse toResponse(HistorialClinico historial) {
        HistorialClinicoResponse response = new HistorialClinicoResponse();

        response.setId(historial.getId());
        response.setFechaNacimiento(historial.getFechaNacimiento());
        response.setMotivoConsulta(historial.getMotivoConsulta());
        response.setDiagnostico(historial.getDiagnostico());
        response.setTratamiento(historial.getTratamiento());
        response.setMedicamentos(historial.getMedicamentos());
        response.setObservaciones(historial.getObservaciones());
        response.setVeterinario(historial.getVeterinario());
        response.setAnimalId(historial.getAnimal().getId());

        return response;
    }
}