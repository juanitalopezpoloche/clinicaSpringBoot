package edu.remington.holamundo.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
public class AnimalRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String especie;

    @NotBlank
    private String raza;

    @NotNull
    @PositiveOrZero
    private Integer edad;

    @NotNull
    @Positive
    private Double peso;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @NotBlank
    private String sexo;

    @NotNull
    private Long acudienteId;
}