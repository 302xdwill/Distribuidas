package com.upeu.ms_curso.service.impl;

import com.upeu.ms_curso.entity.Curso;
import com.upeu.ms_curso.repository.CursoRepository;
import com.upeu.ms_curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> buscar(Integer id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizar(Integer id, Curso curso) {
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    @Override
    public void eliminar(Integer id) {
        cursoRepository.deleteById(id);
    }
}

