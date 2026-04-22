package edu.remington.holamundo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistorialClinicoRequest {

    @NotBlank
    private LocalDate fechaConsulta;

    @NotBlank
    private String motivoConsulta;

    @NotBlank
    private String diagnostico;

    @NotBlank
    private String tratamiento;

    @NotBlank
    private String medicamentos;

    private String observaciones;

    @NotBlank
    private String veterinario;

    @NotBlank
    private Long animalId;
}