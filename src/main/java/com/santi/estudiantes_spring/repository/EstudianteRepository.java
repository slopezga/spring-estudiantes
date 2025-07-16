package com.santi.estudiantes_spring.repository;

import com.santi.estudiantes_spring.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}