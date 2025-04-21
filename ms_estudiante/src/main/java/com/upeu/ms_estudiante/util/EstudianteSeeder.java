package com.upeu.ms_estudiante.util;

import com.upeu.ms_estudiante.entity.Estudiante;
import com.upeu.ms_estudiante.repository.EstudianteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EstudianteSeeder implements CommandLineRunner {

    private final EstudianteRepository estudianteRepository;

    public EstudianteSeeder(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public void run(String... args) {
        if (estudianteRepository.count() == 0) {
            List<Estudiante> estudiantes = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                Estudiante estudiante = new Estudiante();
                estudiante.setNombre("Nombre" + i);
                estudiante.setApellido("Apellido" + i);
                estudiante.setDni(String.format("1234567%02d", i)); // DNI de 8 dígitos
                estudiante.setCodigo("2024" + String.format("%03d", i)); // Código tipo "2024001"
                estudiante.setCorreo("estudiante" + i + "@upeu.edu.pe");
                estudiante.setTelefono("9000000" + String.format("%02d", i));

                estudiantes.add(estudiante);
            }

            estudianteRepository.saveAll(estudiantes);
            System.out.println("Datos de estudiantes insertados correctamente.");
        } else {
            System.out.println("Los estudiantes ya existen, no se insertaron datos.");
        }
    }
}
