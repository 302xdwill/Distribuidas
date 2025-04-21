package com.upeu.ms_matricula.util;

import com.upeu.ms_matricula.entity.Matricula;
import com.upeu.ms_matricula.repository.MatriculaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class MatriculaSeeder implements CommandLineRunner {

    private final MatriculaRepository matriculaRepository;

    public MatriculaSeeder(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public void run(String... args) {
        // Verificamos si ya existen registros en la base de datos
        if (matriculaRepository.count() == 0) {
            List<Matricula> matrículas = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                Matricula matricula = new Matricula();
                matricula.setEstudianteId(i); // Aquí deberías ajustar según cómo vincules a los estudiantes (podrías obtener un estudiante específico)
                matricula.setFechaMatricula(LocalDate.now()); // La fecha de matrícula es la fecha actual

                matrículas.add(matricula);
            }

            matriculaRepository.saveAll(matrículas); // Guardamos las matrículas en la base de datos
            System.out.println("Datos de matrículas insertados correctamente.");
        } else {
            System.out.println("Las matrículas ya existen, no se insertaron datos.");
        }
    }
}
