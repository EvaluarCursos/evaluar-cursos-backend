package com.udeaevaluarcursos.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="total_materia")
public class TotalMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTotalMateria;


    @JoinColumn(name = "idMateria")
    @ManyToOne()
    @JsonBackReference
    private Materia idMateria;


    @Column(name = "semestre")
    private int semestre;
    @Column(name = "promedio_nota_1")
    private int promedioNotaUno;
    @Column(name = "promedio_nota_2")
    private int promedioNotaDos;
    @Column(name = "promedio_nota_3")
    private int promedioNotaTres;
    @Column(name = "promedio_nota_4")
    private int promedioNotaCuatro;
    @Column(name = "promedio_nota_5")
    private int promedioNotaCinco;


    public int getIdTotalMateria() {
        return idTotalMateria;
    }

    public void setIdTotalMateria(int id) {
        this.idTotalMateria = id;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getPromedioNotaUno() {
        return promedioNotaUno;
    }

    public void setPromedioNotaUno(int promedioNotaUno) {
        this.promedioNotaUno = promedioNotaUno;
    }

    public int getPromedioNotaDos() {
        return promedioNotaDos;
    }

    public void setPromedioNotaDos(int promedioNotaDos) {
        this.promedioNotaDos = promedioNotaDos;
    }

    public int getPromedioNotaTres() {
        return promedioNotaTres;
    }

    public void setPromedioNotaTres(int promedioNotaTres) {
        this.promedioNotaTres = promedioNotaTres;
    }

    public int getPromedioNotaCuatro() {
        return promedioNotaCuatro;
    }

    public void setPromedioNotaCuatro(int promedioNotaCuatro) {
        this.promedioNotaCuatro = promedioNotaCuatro;
    }

    public int getPromedioNotaCinco() {
        return promedioNotaCinco;
    }

    public void setPromedioNotaCinco(int promedioNotaCinco) {
        this.promedioNotaCinco = promedioNotaCinco;
    }


    public TotalMateria() {

    }
}