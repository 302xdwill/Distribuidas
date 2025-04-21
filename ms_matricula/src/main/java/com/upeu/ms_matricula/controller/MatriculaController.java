package com.upeu.ms_matricula.controller;

import com.upeu.ms_matricula.entity.Matricula;
import com.upeu.ms_matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    // Lista todas las matrículas registradas
    @RequestMapping
    public List<Matricula> listar() {
        return matriculaService.listar();
    }

    // Busca una matrícula por su ID
    @RequestMapping("/{id}")
    public Optional<Matricula> buscar(@PathVariable Integer id) {
        return matriculaService.buscar(id);
    }

    // Guarda una nueva matrícula
    @PostMapping
    public Matricula guardar(@RequestBody Matricula matricula) {
        System.out.println(matricula);
        return matriculaService.guardar(matricula);
    }

    // Actualiza una matrícula existente
    @PutMapping("/{id}")
    public Matricula actualizar(@PathVariable Integer id, @RequestBody Matricula matricula) {
        return matriculaService.actualizar(id, matricula);
    }

    // Elimina una matrícula por su ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        matriculaService.eliminar(id);
    }
}
