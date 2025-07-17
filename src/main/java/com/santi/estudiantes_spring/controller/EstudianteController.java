package com.santi.estudiantes_spring.controller;

import com.santi.estudiantes_spring.model.Estudiante;
import com.santi.estudiantes_spring.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable Long id) {
        return repo.findById(id)
                .map(estudiante -> ResponseEntity.ok(estudiante))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante) {
        return repo.save(estudiante); // Devuelve el mismo objeto como confirmación
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().body("Estudiante eliminado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
