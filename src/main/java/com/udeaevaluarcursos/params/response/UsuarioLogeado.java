package com.udeaevaluarcursos.params.response;

import com.udeaevaluarcursos.models.Materia;

import java.util.List;

public class UsuarioLogeado {
    private String rol;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;



    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public int getCedula() {
        return cedula;
    }

    public List<Materia> courses;

    public List<Materia> getCourses() {
        return courses;
    }

    public void setCourses(List<Materia> courses) {
        this.courses = courses;
    }

    private int cedula;
}
