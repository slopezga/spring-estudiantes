package com.santi.estudiantes_spring.dto;

public class InscripcionRequest {

    private Long estudianteId;
    private Long cursoId;

    public InscripcionRequest() {
    }

    public InscripcionRequest(Long estudianteId, Long cursoId) {
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}