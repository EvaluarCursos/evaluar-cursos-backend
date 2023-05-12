package com.udeaevaluarcursos.models;
import java.util.ArrayList;
public class CalculosPreguntas {

    private double average = 0;
    private double desvEst= 0;
    private double  coefVar= 0;

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getDesvEst() {
        return desvEst;
    }

    public void setDesvEst(double desvEst) {
        this.desvEst = desvEst;
    }

    public double getCoefVar() {
        return coefVar;
    }

    public void setCoefVar(double coefVar) {
        this.coefVar = coefVar;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total=0;

    private ArrayList<Integer> notas= new ArrayList<>();

    public ArrayList<Integer> getNotas() {
        return notas;
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
            this.desvEst=desviacionEstandar;
        }else{
            this.desvEst=0;
        }






    }

    public void calculateCoefVar(){
        double coefficientOfVariation = (this.desvEst / this.average) * 100;
        this.coefVar=coefficientOfVariation;

    }





}
