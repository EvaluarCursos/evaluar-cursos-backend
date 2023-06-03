package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.params.response.EvaluationResponse;

import java.util.List;

public interface EvaluacionMateriaService {
    public List<EvaluacionMateria> listEvaluacionesMaterias();
    public EvaluacionMateria getEvaluacionMateriaById(int id);

    public EvaluacionMateria createEvaluacionMateria(EvaluacionMateria evaluacionMateria);
    public EvaluacionMateria deleteEvaluacionMateria(int id);

    public EvaluationResponse getInformeByIdMateria(int idProfesor, int idMateria);

    public EvaluacionMateria[] testInformeByIds(int idProfesor, int idMateria);

}
