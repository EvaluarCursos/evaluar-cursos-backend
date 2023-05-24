package com.udeaevaluarcursos.params.response;

public class CourseByFilter {

    private String id;
    private String name;
    private String code;
    private String faculty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public CourseByFilter(String id, String name, String code, String faculty){
        this.id=id;
        this.code=code;
        this.faculty=faculty;
        this.name=name;
    }



}
