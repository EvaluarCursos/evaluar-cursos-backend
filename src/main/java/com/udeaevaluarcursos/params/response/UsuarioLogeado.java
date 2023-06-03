package com.udeaevaluarcursos.params.response;

import com.udeaevaluarcursos.models.Materia;

import java.util.List;

public class UsuarioLogeado {
    private String role;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;



    public void setRole(String rol) {
        this.role = rol;
    }



    public String getRole() {
        return role;
    }



    public List<Materia> courses;

    public List<Materia> getCourses() {
        return courses;
    }

    public void setCourses(List<Materia> courses) {
        this.courses = courses;
    }


}
