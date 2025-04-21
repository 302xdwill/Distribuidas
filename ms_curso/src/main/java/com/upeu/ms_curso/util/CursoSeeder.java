package com.upeu.ms_curso.util;

import com.upeu.ms_curso.entity.Curso;
import com.upeu.ms_curso.repository.CursoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CursoSeeder implements CommandLineRunner {

    private final CursoRepository cursoRepository;

    // Inyección del repositorio de Curso
    public CursoSeeder(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verificamos si ya existen cursos en la base de datos
        if (cursoRepository.count() == 0) {
            // Si no existen, insertamos algunos cursos de ejemplo
            Curso curso1 = new Curso(null, "Matemáticas", "Curso de álgebra y cálculo", 30);
            Curso curso2 = new Curso(null, "Programación", "Curso introductorio de programación en Java", 25);
            Curso curso3 = new Curso(null, "Bases de Datos", "Curso de fundamentos de bases de datos y SQL", 20);
            Curso curso4 = new Curso(null, "Redes", "Curso de redes informáticas y comunicaciones", 35);

            // Guardamos los cursos en la base de datos
            cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3, curso4));

            System.out.println("Cursos insertados correctamente.");
        } else {
            System.out.println("Los cursos ya existen en la base de datos.");
        }
    }
}
