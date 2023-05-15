package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.EvaluacionProfesor;
import com.udeaevaluarcursos.models.EvaluationResponse;
import com.udeaevaluarcursos.models.PreguntasEvaluaciones;

import java.util.List;
import java.util.Optional;

public interface EvaluacionMateriaService {
    public List<EvaluacionMateria> listEvaluacionesMaterias();
    public EvaluacionMateria getEvaluacionMateriaById(int id);

    public EvaluacionMateria createEvaluacionMateria(EvaluacionMateria evaluacionMateria);
    public EvaluacionMateria deleteEvaluacionMateria(int id);

    public EvaluationResponse getInformeByIdMateria(int idProfesor, int idMateria);

    public EvaluacionMateria[] testInformeByIds(int idProfesor, int idMateria);

}
