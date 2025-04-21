package com.upeu.ms_matricula.feign;

import com.upeu.ms_matricula.dto.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-curso", url = "http://localhost:8062/cursos")
public interface CursoClient {

    @GetMapping("/{id}")
    Curso obtenerCursoPorId(@PathVariable("id") Integer id);
}
