package com.udeaevaluarcursos.models;

import jakarta.persistence.*;

@Entity
@Table(name="estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;

    @Column(name = "cedula")
    private int cedula;

    @JoinColumn(name = "idUsuario")
    @OneToOne()
    private Usuario idUsuario;

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int id) {
        this.idEstudiante = id;
    }

    public Estudiante() {

    }
}