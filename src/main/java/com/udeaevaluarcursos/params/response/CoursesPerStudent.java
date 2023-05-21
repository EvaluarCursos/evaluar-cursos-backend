package com.udeaevaluarcursos.params.response;

public class CoursesPerStudent {
    private int id;
    private String code;
    private String teacher;
    private String name;
    private int evaluated;

    public CoursesPerStudent(

    ) {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEvaluated(int evaluated) {
        this.evaluated = evaluated;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getName() {
        return name;
    }

    public int getEvaluated() {
        return evaluated;
    }
}
