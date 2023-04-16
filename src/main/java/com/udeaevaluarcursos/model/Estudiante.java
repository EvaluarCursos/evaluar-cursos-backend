package com.udeaevaluarcursos.model;

import jakarta.persistence.*;

@Entity
@Table(name="evaluacion_materia")
public class Estudiante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estudiante(){

    }
}
