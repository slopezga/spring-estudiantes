package com.santi.estudiantes_spring.repository;

import com.santi.estudiantes_spring.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}