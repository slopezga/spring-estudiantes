package com.santi.estudiantes_spring.controller;

import com.santi.estudiantes_spring.model.Estudiante;
import com.santi.estudiantes_spring.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteRepository repo;

    public EstudianteController(EstudianteRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return repo.findAll();
    }

    @PostMapping
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante) {
        return repo.save(estudiante); // Devuelve el mismo objeto como confirmación
    }
}
