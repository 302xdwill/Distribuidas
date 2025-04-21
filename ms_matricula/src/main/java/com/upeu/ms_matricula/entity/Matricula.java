package com.upeu.ms_matricula.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.upeu.ms_matricula.dto.Estudiante;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer estudianteId;

    private LocalDate fechaMatricula;

    @Transient
    private Estudiante estudiante;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "matricula_id")
    private List<MatriculaDetalle> detalle;

}
