package com.upeu.ms_matricula.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MatriculaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer matriculaId;
    private Integer cursoId;


}
