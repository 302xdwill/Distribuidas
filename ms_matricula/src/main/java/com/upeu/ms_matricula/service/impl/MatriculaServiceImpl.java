package com.upeu.ms_matricula.service.impl;

import com.upeu.ms_matricula.entity.Matricula;
import com.upeu.ms_matricula.repository.MatriculaRepository;
import com.upeu.ms_matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listar() {
        // Retorna todos los registros de matrícula
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> buscar(Integer id) {
        // Busca una matrícula por ID
        return matriculaRepository.findById(id);
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        // Guarda una nueva matrícula en la base de datos
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizar(Integer id, Matricula matricula) {
        // Actualiza una matrícula existente, asignando el ID proporcionado
        matricula.setId(id);
        return matriculaRepository.save(matricula);
    }

    @Override
    public void eliminar(Integer id) {
        // Elimina una matrícula por ID
        matriculaRepository.deleteById(id);
    }
}

