package com.upeu.ms_estudiante.repository;

import com.upeu.ms_estudiante.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
