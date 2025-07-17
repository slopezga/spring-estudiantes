package com.santi.estudiantes_spring.repository;

import com.santi.estudiantes_spring.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}