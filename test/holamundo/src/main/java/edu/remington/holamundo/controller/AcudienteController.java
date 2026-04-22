package edu.remington.holamundo.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.remington.holamundo.dto.AcudienteRequest;
import edu.remington.holamundo.dto.AcudienteResponse;
import edu.remington.holamundo.service.AcudienteService;  

@RestController
@RequestMapping("/acudientes")
public class AcudienteController {

    private final AcudienteService acudienteService;

    public AcudienteController(AcudienteService acudienteService) {
        this.acudienteService = acudienteService;
    }

    @PostMapping
    public ResponseEntity<AcudienteResponse> crear(@Valid @RequestBody AcudienteRequest request) {
        AcudienteResponse response = acudienteService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AcudienteResponse>> listar() {
        return ResponseEntity.ok(acudienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcudienteResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(acudienteService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcudienteResponse> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody AcudienteRequest request) {
        return ResponseEntity.ok(acudienteService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        acudienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}