package com.udeaevaluarcursos.params.request;

public class CreateMatricula {
    private int idEstudiante;
    private int idMateria;
    private String semestre;
    private int calificado = 1;

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setCalificado(int calificado) {
        this.calificado = calificado;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public String getSemestre() {
        return semestre;
    }

    public int getCalificado() {
        return calificado;
    }
}
