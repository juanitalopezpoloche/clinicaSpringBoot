package edu.remington.holamundo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistorialClinicoRequest {

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @NotNull
    private Long animalId;
}