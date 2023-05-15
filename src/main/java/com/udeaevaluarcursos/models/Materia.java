package com.udeaevaluarcursos.models;

import com.udeaevaluarcursos.repository.ProfesorRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMateria;


    @Column(name="code")
    private int code;


    @ManyToOne
    private Profesor professor;

    @Column(name="nombre_materia")
    private String nombreMateria;

    @Column(name="evaluated")
    private Boolean evaluated;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Profesor getProfessor() {
        return professor;
    }

    public void setProfessor(Profesor professor) {
        this.professor = professor;
    }

    public Boolean getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(Boolean evaluated) {
        this.evaluated = evaluated;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public Materia(){

    }


}
