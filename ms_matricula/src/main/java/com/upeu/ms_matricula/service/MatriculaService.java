package com.upeu.ms_matricula.service;

import com.upeu.ms_matricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    // Lista todas las matrículas registradas
    List<Matricula> listar();

    // Busca una matrícula por su ID
    Optional<Matricula> buscar(Integer id);

    // Guarda una nueva matrícula
    Matricula guardar(Matricula matricula);

    // Actualiza una matrícula existente
    Matricula actualizar(Integer id, Matricula matricula);

    // Elimina una matrícula por su ID
    void eliminar(Integer id);
}
