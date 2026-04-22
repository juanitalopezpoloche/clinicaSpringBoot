package edu.remington.holamundo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistorialClinicoResponse {

    private Long id;
    private LocalDate fechaConsulta;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private String medicamentos;
    private String observaciones;
    private String veterinario;
    private Long animalId;
}