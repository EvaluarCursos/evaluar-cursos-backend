package com.udeaevaluarcursos.models;
import java.util.ArrayList;
public class CalculosPreguntas {

    private double average = 0;
    private double desv_est= 0;
    private double  coef_var= 0;

    public double getDesv_est() {
        return desv_est;
    }

    public void setDesv_est(double desv_est) {
        this.desv_est = desv_est;
    }

    public double getCoef_var() {
        return coef_var;
    }

    public void setCoef_var(double coef_var) {
        this.coef_var = coef_var;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }





    private int total=0;

    private int answers=0;

    public int getAnswers() {
        return answers;
    }

    public void setAswers(int aswers) {
        this.answers = aswers;
    }

    private ArrayList<Integer> notas= new ArrayList<>();

    public void addNota(int nota) {
         this.notas.add(nota);
    }



    public void estadisticas(int length){
        calculateAverage(length);
        calculateDesvEst(length);
        calculateCoefVar();

    }
    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    public void calculateAverage(int length){
        for (int i=0;i<this.notas.size();i++){

            this.total=this.total+this.notas.get(i);
        }

        this.average=this.total/length;

    }

    public void calculateDesvEst(int length){
        double sumCuadradosDiff = 0.0;
        for (double num : this.notas) {
            double diff = num - this.average;
            sumCuadradosDiff += diff * diff;
        }

        // Calcula la varianza

        if (length >1){
            double varianza = sumCuadradosDiff / (length - 1);
            double desviacionEstandar = Math.sqrt(varianza);
            this.desv_est=desviacionEstandar;
        }else{
            this.desv_est=0;
        }






    }

    public void calculateCoefVar(){
        double coefficientOfVariation = (this.desv_est / this.average) * 100;
        this.coef_var=coefficientOfVariation;

    }





}
