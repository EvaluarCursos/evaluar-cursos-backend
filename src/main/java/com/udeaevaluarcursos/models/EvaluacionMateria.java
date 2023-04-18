package com.udeaevaluarcursos.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.udeaevaluarcursos.model.Matricula;
@Entity
@Table(name="evaluacion_materia")
public class EvaluacionMateria {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="nota_pregunta_1")
    private int notaUno;
    @Column(name="nota_pregunta_2")
    private int notaDos;
    @Column(name="nota_pregunta_3")
    private int notaTres;
    @Column(name="nota_pregunta_4")
    private int notaCuatro;
    @Column(name="nota_pregunta_5")
    private int notaCinco;


    @JoinColumn(name = "idMatricula")
    @OneToOne()
    @JsonManagedReference
    private Matricula idMatricula;

    @Column(name="feedback")
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public EvaluacionMateria(){

    };

}
