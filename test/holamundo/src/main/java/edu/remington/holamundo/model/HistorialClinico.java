package edu.remington.holamundo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "historial_clinico")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistorialClinico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaConsulta;

    @Column(nullable = false, length = 500)
    private String motivoConsulta;

    @Column(nullable = false , length = 1000)
    private String diagnostico;

    @Column(nullable = false , length = 1000)
    private String tratamiento;

    @Column(nullable = false , length = 1000)
    private String medicamentos;

    @Column(length = 1000)
    private String observaciones;

    @Column(nullable = false)
    private String veterinario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    @ToString.Exclude 
    private Animal animal;
}
