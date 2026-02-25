package edu.remington.holamundo.service;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.remington.holamundo.dto.AcudienteRequest;
import edu.remington.holamundo.dto.AcudienteResponse;
import edu.remington.holamundo.model.Acudiente;
import edu.remington.holamundo.repository.AcudienteRepository;

@Service
@Transactional
public class AcudienteService {
    
    private final AcudienteRepository acudienteRepository;

    public AcudienteService(AcudienteRepository acudienteRepository) {
        this.acudienteRepository = acudienteRepository;
    }

    public AcudienteResponse crear(AcudienteRequest request){
        Acudiente acudiente = new Acudiente();
        applyRequest(acudiente, request);
        Acudiente saved = acudienteRepository.save(acudiente);
        return toResponse(saved);
    }

    public AcudienteResponse actualizar(long id, AcudienteRequest request){
        Acudiente acudiente = findAcudiente(id);
        applyRequest(acudiente, request);
        Acudiente update = acudienteRepository.save(acudiente);
        return  toResponse(update);
    }

    public void eliminar(long id){
        Acudiente acudiente = findAcudiente(id);
        acudienteRepository.delete(acudiente);
    }

    @Transactional(readOnly = true)
    public Page<AcudienteResponse> listar(Pageable pageable){
        return acudienteRepository.findAll(pageable).map(this::toResponse);
    }

    @Transactional
    public AcudienteResponse obtenerPorId(Long id){
        Acudiente acudiente = findAcudiente(id);
        return toResponse(acudiente);
    }

    private Acudiente findAcudiente(Long id){
        return acudienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Acudiente no encontrado con id " + id));
    }

    private void applyRequest(Acudiente acudiente, AcudienteRequest request){
        acudiente.setNombre(request.getNombre());
        acudiente.setDocumento(request.getDocumento());
        acudiente.setTelefono(request.getTelefono());
        acudiente.setEmail(request.getEmail());
        acudiente.setDireccion(request.getDireccion());
    }
    
    private AcudienteResponse toResponse(Acudiente acudiente){
        AcudienteResponse response = new AcudienteResponse();
        response.setId(acudiente.getId());
        response.setNombre(acudiente.getNombre());
        response.setDocumento(acudiente.getDocumento());
        response.setTelefono(acudiente.getTelefono());
        response.setEmail(acudiente.getEmail());
        response.setDireccion(acudiente.getDireccion());
        return response;
    }

}
