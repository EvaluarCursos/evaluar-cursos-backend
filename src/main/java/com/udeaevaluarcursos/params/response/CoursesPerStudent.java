package com.udeaevaluarcursos.params.response;

public class CoursesPerStudent {
    private int matriculaId;
    private String code;
    private String nombreProfesor;
    private String materia;
    private int calificado;

    public CoursesPerStudent(

    ) {

    }

    public void setMatriculaId(int matriculaId) {
        this.matriculaId = matriculaId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setCalificado(int calificado) {
        this.calificado = calificado;
    }

    public int getMatriculaId() {
        return matriculaId;
    }

    public String getCode() {
        return code;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getMateria() {
        return materia;
    }

    public int getCalificado() {
        return calificado;
    }
}
