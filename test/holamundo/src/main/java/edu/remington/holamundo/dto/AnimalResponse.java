package edu.remington.holamundo.dto;
import java.time.LocalDate;

import edu.remington.holamundo.model.Acudiente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalResponse {
    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private Integer edad;
    private Double peso;
    private LocalDate fechaNacimiento;
    private String sexo;
    private Long acudienteId;
    private Acudiente acudiente;
}
