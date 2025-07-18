package com.santi.estudiantes_spring.service;

import com.santi.estudiantes_spring.repository.InscripcionRepository;
import com.santi.estudiantes_spring.repository.EstudianteRepository;
import com.santi.estudiantes_spring.repository.CursoRepository;
import com.santi.estudiantes_spring.model.Inscripcion;
import com.santi.estudiantes_spring.model.Estudiante;
import com.santi.estudiantes_spring.model.Curso;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository,
                              EstudianteRepository estudianteRepository,
                              CursoRepository cursoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    public Inscripcion crearInscripcion(Long estudianteId, Long cursoId, LocalDate fechaInscripcion) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Inscripcion inscripcion = new Inscripcion(estudiante, curso, fechaInscripcion);
        return inscripcionRepository.save(inscripcion);
    }
}