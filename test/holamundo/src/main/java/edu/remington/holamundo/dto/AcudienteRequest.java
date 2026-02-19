package edu.remington.holamundo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AcudienteRequest {

    @NotBlank
    private String nombre;
    @NotBlank
    private String documento;
    @NotBlank
    private String telefono;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String direccion;
    
    
    
    

}
