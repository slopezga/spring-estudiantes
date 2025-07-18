package com.santi.estudiantes_spring.controller;

import com.santi.estudiantes_spring.model.Inscripcion;
import com.santi.estudiantes_spring.repository.InscripcionRepository;
import com.santi.estudiantes_spring.service.InscripcionService;
import com.santi.estudiantes_spring.dto.InscripcionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionRepository inscripcionRepository;
    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionRepository inscripcionRepository, InscripcionService inscripcionService) {
        this.inscripcionRepository = inscripcionRepository;
        this.inscripcionService = inscripcionService;
    }

    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> getInscripcionById(@PathVariable Long id) {
        return inscripcionRepository.findById(id)
                .map(inscripcion -> ResponseEntity.ok(inscripcion))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInscripcion(@PathVariable Long id) {
        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return ResponseEntity.ok("Inscripción eliminada con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Inscripción no encontrada");
        }
    }

    @PostMapping
    public ResponseEntity<?> inscribirEstudiante(@RequestBody InscripcionRequest request) {
        Long estudianteId = request.getEstudianteId();
        Long cursoId = request.getCursoId();
        if (estudianteId == null || cursoId == null) {
            return ResponseEntity.badRequest().body("ID de estudiante o curso no proporcionado");
        }
        Inscripcion nuevaInscripcion = inscripcionService.crearInscripcion(estudianteId, cursoId, LocalDate.now());
        return ResponseEntity.ok(nuevaInscripcion);
    }
}