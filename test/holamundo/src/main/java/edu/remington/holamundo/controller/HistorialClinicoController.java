package edu.remington.holamundo.controller;


import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.remington.holamundo.dto.HistorialClinicoRequest;
import edu.remington.holamundo.dto.HistorialClinicoResponse;
import edu.remington.holamundo.service.HistorialClinicoService;

@RestController
@RequestMapping("/historial")
public class HistorialClinicoController {

    private final HistorialClinicoService historialService;

    public HistorialClinicoController(HistorialClinicoService historialService) {
        this.historialService = historialService;
    }

    @PostMapping
    public ResponseEntity<HistorialClinicoResponse> crear(
            @Valid @RequestBody HistorialClinicoRequest request) {
        HistorialClinicoResponse response = historialService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialClinicoResponse> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(historialService.obtenerPorId(id));
    }

    @GetMapping("/animal/{idAnimal}")
    public ResponseEntity<List<HistorialClinicoResponse>> listarPorAnimal(
            @PathVariable Long idAnimal) {
        return ResponseEntity.ok(historialService.listarPorAnimal(idAnimal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}