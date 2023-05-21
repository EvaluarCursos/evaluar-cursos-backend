package com.udeaevaluarcursos.params.response;

public class CoursesPerTeacher {
    private int id;
    private String code;
    private String name;
    private String faculty;

    public void setMateriaId(int materiaId) {
        this.id = materiaId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String materia) {
        this.name = materia;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }


    public String getFaculty() {
        return faculty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoursesPerTeacher(

    ) {

    }
}