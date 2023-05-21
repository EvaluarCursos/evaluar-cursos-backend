package com.udeaevaluarcursos.models;

import jakarta.persistence.*;


@Entity
@Table(name = "evaluacion_profesor")
public class EvaluacionProfesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacionProfesor;

    @OneToOne()
    private Profesor idProfesor;

    @OneToOne
    private Materia idMateria;

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    @Column(name = "nota_pregunta_1")
    private int notaUno;
    @Column(name = "nota_pregunta_2")
    private int notaDos;
    @Column(name = "nota_pregunta_3")
    private int notaTres;
    @Column(name = "nota_pregunta_4")
    private int notaCuatro;
    @Column(name = "nota_pregunta_5")
    private int notaCinco;
    @Column(name = "nota_pregunta_6")
    private int notaSeis;

    public int getNotaSeis() {
        return notaSeis;
    }

    public void setNotaSeis(int notaSeis) {
        this.notaSeis = notaSeis;
    }

    public int getNotaSiete() {
        return notaSiete;
    }

    public void setNotaSiete(int notaSiete) {
        this.notaSiete = notaSiete;
    }

    @Column(name = "nota_pregunta_7")
    private int notaSiete;

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

    public int getIdEvaluacionProfesor() {
        return idEvaluacionProfesor;
    }

    public void setIdEvaluacionProfesor(int id) {
        this.idEvaluacionProfesor = id;
    }

    public int getNotaUno() {
        return notaUno;
    }

    public void setNotaUno(int notaUno) {
        this.notaUno = notaUno;
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

    public int getNotaCuatro() {
        return notaCuatro;
    }

    public void setNotaCuatro(int notaCuatro) {
        this.notaCuatro = notaCuatro;
    }

    public int getNotaCinco() {
        return notaCinco;
    }

    public void setNotaCinco(int notaCinco) {
        this.notaCinco = notaCinco;
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

    public EvaluacionProfesor() {

    }
}
