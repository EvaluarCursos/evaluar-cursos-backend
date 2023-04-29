package com.udeaevaluarcursos.params.request;

public class EvalMateriaRequest {
    private int notaUno;
    private int notaDos;
    private int notaTres;
    private int notaCuatro;
    private int notaCinco;
    private int idMatricula;
    private String feedback;

    public void setNotaUno(int notaUno) {
        this.notaUno = notaUno;
    }

    public void setNotaDos(int notaDos) {
        this.notaDos = notaDos;
    }

    public void setNotaTres(int notaTres) {
        this.notaTres = notaTres;
    }

    public void setNotaCuatro(int notaCuatro) {
        this.notaCuatro = notaCuatro;
    }

    public void setNotaCinco(int notaCinco) {
        this.notaCinco = notaCinco;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getNotaUno() {
        return notaUno;
    }

    public int getNotaDos() {
        return notaDos;
    }

    public int getNotaTres() {
        return notaTres;
    }

    public int getNotaCuatro() {
        return notaCuatro;
    }

    public int getNotaCinco() {
        return notaCinco;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public String getFeedback() {
        return feedback;
    }
}
