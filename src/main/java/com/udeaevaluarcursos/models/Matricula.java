package com.udeaevaluarcursos.models;

import com.udeaevaluarcursos.models.Profesor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;


    @JoinColumn(name = "idEstudiante")
    @ManyToOne()
    private Estudiante idEstudiante;

    @JoinColumn(name = "idMateria")
    @ManyToOne()
    private Materia idMateria;


    @JoinColumn(name = "idProfesor")
    @ManyToOne()
    private Profesor idProfesor;


    @Column(name = "semestre")
    private int semestre;

    @Column(name = "calificado")
    private int calificado;

    public int getCalificado() {
        return calificado;
    }

    public void setCalificado(int calificado) {
        this.calificado = calificado;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Estudiante getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Estudiante idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }


    public Matricula() {

    }

}
