package edu.remington.holamundo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AcudienteResponse {
    private long id;
    private String nombre;
    private String documento;
    private String telefono;
    private String email;
    private String direccion;
}
