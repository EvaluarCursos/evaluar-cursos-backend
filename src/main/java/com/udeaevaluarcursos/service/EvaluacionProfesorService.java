package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.EvaluacionProfesor;
import com.udeaevaluarcursos.models.PreguntasEvaluaciones;

import java.util.List;
import java.util.Optional;

public interface EvaluacionProfesorService {


    public List<EvaluacionProfesor> listEvaluacionesProfesores();
    public EvaluacionProfesor getEvaluacionProfesorById(int id);

    public EvaluacionProfesor createEvaluacionProfesor(EvaluacionProfesor evaluacionProfesor);
    public EvaluacionProfesor deleteEvaluacionProfesor(int id);




}
