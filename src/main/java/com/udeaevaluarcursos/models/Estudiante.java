package com.udeaevaluarcursos.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idEstudiante ;

    @Column(name="cedula")
    private int cedula;

    /* @Column(name="courses")
    @OneToMany()
    @JoinTable(
            name="Materia",
            joinColumns = @JoinColumn( name="idEstudiante"),
    inverseJoinColumns = @JoinColumn( name="idMateria")
        )
    private List<Materia> courses;
    */

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

    public Estudiante(){

    } }