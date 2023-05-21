package com.udeaevaluarcursos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluacion_materia")
public class EvaluacionMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacionMateria;
    @Column(name = "nota_pregunta_1")
    private int notaUno;
    @Column(name = "nota_pregunta_2")
    private int notaDos;
    @Column(name = "nota_pregunta_3")
    private int notaTres;

    @OneToOne
    private Profesor idProfesor;

    @OneToOne
    private Materia idMateria;

    @JoinColumn(name = "idMatricula")
    @OneToOne()
    private Matricula idMatricula;

    @Column(name = "feedback")
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getIdEvaluacionMateria() {
        return idEvaluacionMateria;
    }

    public void setIdEvaluacionMateria(int id) {
        this.idEvaluacionMateria = id;
    }

    public int getNotaDos() {
        return notaDos;
    }

    public void setNotaDos(int notaDos) {
        this.notaDos = notaDos;
    }

    public int getNotaTres() {
        return notaTres;
    }

    public void setNotaTres(int notaTres) {
        this.notaTres = notaTres;
    }

    public int getNotaUno() {
        return notaUno;
    }

    public void setNotaUno(int notaUno) {
        this.notaUno = notaUno;
    }

    public Matricula getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Matricula idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Profesor getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Profesor idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public EvaluacionMateria() {

    }
}
