package edu.remington.holamundo.service;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.remington.holamundo.dto.AcudienteRequest;
import edu.remington.holamundo.dto.AcudienteResponse;
import edu.remington.holamundo.dto.AnimalRequest;
import edu.remington.holamundo.dto.AnimalResponse;
import edu.remington.holamundo.model.Acudiente;
import edu.remington.holamundo.model.Animal;
import edu.remington.holamundo.repository.AcudienteRepository;
import edu.remington.holamundo.repository.AnimalRepository;

@Service
@Transactional
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AcudienteRepository acudienteRepository;

    public AnimalService(AnimalRepository animalRepository, AcudienteRepository acudienteRepository){
        this.acudienteRepository = acudienteRepository;
        this.animalRepository = animalRepository;
    }

    public AnimalResponse crear(AnimalRequest request){
        Animal animal = new Animal();
        applyRequest(animal, request);
        Animal saved = animalRepository.save(animal);
        return toResponse(saved);
    }

    public AnimalResponse actualizar(long id, AnimalRequest request){
        Animal animal = findAnimal(id);
        applyRequest(animal, request);
        Animal update = animalRepository.save(animal);
        return  toResponse(update);
    }

    public void eliminar(long id){
        Animal animal = findAnimal(id);
        animalRepository.delete(animal);
    }
    
    @Transactional(readOnly = true)
    public Page<AnimalResponse> listar(Pageable pageable){
        return animalRepository.findAll(pageable)
                .map(this::toResponse);
    }

    @Transactional
    public AnimalResponse obtenerPorId(Long id){
        Animal animal = findAnimal(id);
        return toResponse(animal);
    }

    private Animal findAnimal(Long id){
        return animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal no encontrado con id " + id));
    }

    private void applyRequest(Animal animal, AnimalRequest request) {
        animal.setNombre(request.getNombre());
        animal.setEspecie(request.getEspecie());
        animal.setRaza(request.getRaza());
        animal.setEdad(request.getEdad());
        animal.setPeso(request.getPeso());
        animal.setFechaNacimiento(request.getFechaNacimiento());
        animal.setSexo(request.getSexo());
    
        Acudiente acudiente = acudienteRepository
            .findById(request.getAcudienteId())
            .orElseThrow(() -> new RuntimeException("Acudiente no encontrado"));
    
        animal.setAcudiente(acudiente);
    }

    private AnimalResponse toResponse(Animal animal) {
        AnimalResponse response = new AnimalResponse();
    
        response.setId(animal.getId());
        response.setNombre(animal.getNombre());
        response.setEspecie(animal.getEspecie());
        response.setRaza(animal.getRaza());
        response.setEdad(animal.getEdad());
        response.setPeso(animal.getPeso());
        response.setFechaNacimiento(animal.getFechaNacimiento());
        response.setSexo(animal.getSexo());
        response.setAcudienteId(animal.getAcudiente().getId());
    
        return response;
    }
}
