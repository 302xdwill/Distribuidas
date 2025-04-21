package com.upeu.ms_curso.controller;

import com.upeu.ms_curso.entity.Curso;
import com.upeu.ms_curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Listar todos los cursos
    @RequestMapping
    public List<Curso> listar() {
        return cursoService.listar();
    }

    // Buscar un curso por ID
    @RequestMapping("/{id}")
    public Optional<Curso> buscar(@PathVariable Integer id) {
        return cursoService.buscar(id);
    }

    // Crear un nuevo curso
    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        System.out.println(curso); // Para depuración, puedes eliminar este println más tarde
        return cursoService.guardar(curso);
    }

    // Actualizar un curso existente
    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        return cursoService.actualizar(id, curso);
    }

    // Eliminar un curso
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cursoService.eliminar(id);
    }
}

