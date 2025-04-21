package com.upeu.ms_matricula.entity;

import com.upeu.ms_matricula.dto.Curso;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MatriculaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer cursoId;

    @Transient
    private Curso curso;
}
