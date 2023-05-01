package com.udeaevaluarcursos.models;

import jakarta.persistence.*;

@Entity
@Table(name="profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfesor;

    @Column(name = "cedula")
    private int cedula;

    @Column(name = "nombre")
    private String nombre;

    @JoinColumn(name = "idUsuario")
    @OneToOne()
    private Usuario idUsuario;

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }


    public Profesor() {

    }
}


