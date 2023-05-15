package com.udeaevaluarcursos.params.request;

public class EvalMateriaRequest {
    private int q1;
    private int q2;
    private int q3;
    private int id;
    private String feedback;

    public void setQ1(int q1) {
        this.q1 = q1;
    }

    public void setQ2(int q2) {
        this.q2 = q2;
    }

    public void setQ3(int q3) {
        this.q3 = q3;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getQ1() {
        return q1;
    }

    public int getQ2() {
        return q2;
    }

    public int getQ3() {
        return q3;
    }

    public int getId() {
        return id;
    }

    public String getFeedback() {
        return feedback;
    }
}
