package com.upeu.ms_matricula.feign;

import com.upeu.ms_matricula.dto.Estudiante;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-estudiante", url = "http://localhost:8061/estudiantes")
public interface EstudianteClient {

    @GetMapping("/{id}")
    Estudiante obtenerEstudiantePorId(@PathVariable("id") Integer id);
}
