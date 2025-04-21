package com.upeu.ms_matricula.service.impl;

import com.upeu.ms_matricula.entity.Matricula;
import com.upeu.ms_matricula.entity.MatriculaDetalle;
import com.upeu.ms_matricula.feign.EstudianteClient;
import com.upeu.ms_matricula.feign.CursoClient;
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

    @Autowired
    private EstudianteClient estudianteClient;

    @Autowired
    private CursoClient cursoClient;

    @Override
    public List<Matricula> listar() {
        List<Matricula> matriculas = matriculaRepository.findAll();
        for (Matricula m : matriculas) {
            m.setEstudiante(estudianteClient.obtenerEstudiantePorId(m.getEstudianteId()));
            if (m.getDetalle() != null) {
                m.getDetalle().forEach(det -> det.setCurso(cursoClient.obtenerCursoPorId(det.getCursoId())));
            }
        }
        return matriculas;
    }

    @Override
    public Optional<Matricula> buscar(Integer id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);
        matricula.ifPresent(m -> {
            m.setEstudiante(estudianteClient.obtenerEstudiantePorId(m.getEstudianteId()));
            if (m.getDetalle() != null) {
                m.getDetalle().forEach(det -> det.setCurso(cursoClient.obtenerCursoPorId(det.getCursoId())));
            }
        });
        return matricula;
    }

    @Override
    public Matricula guardar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizar(Integer id, Matricula matricula) {
        matricula.setId(id);
        return matriculaRepository.save(matricula);
    }

    @Override
    public void eliminar(Integer id) {
        matriculaRepository.deleteById(id);
    }
}
