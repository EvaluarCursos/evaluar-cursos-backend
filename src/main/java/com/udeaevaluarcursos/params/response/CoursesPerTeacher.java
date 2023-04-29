package com.udeaevaluarcursos.params.response;

public class CoursesPerTeacher {
    private int materiaId;
    private String code;
    private String materia;
    private String faculty;

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public String getCode() {
        return code;
    }

    public String getMateria() {
        return materia;
    }

    public String getFaculty() {
        return faculty;
    }

    public CoursesPerTeacher(

    ) {

    }
}