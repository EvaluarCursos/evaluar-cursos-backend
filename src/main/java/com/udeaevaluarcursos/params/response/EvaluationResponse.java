package com.udeaevaluarcursos.params.response;

import com.udeaevaluarcursos.models.CalculosPreguntas;

import java.util.HashMap;

public class EvaluationResponse {
    public HashMap<String,String> headers = new HashMap<String, String>();
    
    public HashMap<String, CalculosPreguntas> seccion1 = new HashMap<String, CalculosPreguntas>();
    public HashMap<String,CalculosPreguntas> seccion2 = new HashMap<String, CalculosPreguntas>();
    public HashMap<String,CalculosPreguntas> seccion3 = new HashMap<String, CalculosPreguntas>();
    public HashMap<String,CalculosPreguntas> seccion4 = new HashMap<String, CalculosPreguntas>();
    public HashMap<String,CalculosPreguntas> seccion5 = new HashMap<String, CalculosPreguntas>();

    public HashMap<String,CalculosPreguntas> seccion6 = new HashMap<String, CalculosPreguntas>();



}
