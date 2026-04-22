package edu.remington.holamundo.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalRequest {
    @NotBlank
    private String nombre;

    @NotBlank
    private String especie;

    @NotBlank
    private String raza;

    @NotBlank
    private Integer edad;

    @NotBlank
    private Double peso;

    @NotBlank
    private LocalDate fechaNacimiento;

    @NotBlank
    private String sexo;
    
    @NotBlank
    public Long acudiente;
}
