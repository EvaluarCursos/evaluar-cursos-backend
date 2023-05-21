package com.udeaevaluarcursos.params.response;

public class UsuarioLogeado {
    private String rol;

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

    private int cedula;
}
