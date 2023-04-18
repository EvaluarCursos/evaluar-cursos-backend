package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.EvaluacionProfesor;

import java.util.List;
import java.util.Optional;

public interface EvaluacionMateriaService {
    public List<EvaluacionMateria> listEvaluacionesMaterias();
    public EvaluacionMateria getEvaluacionMateriaById(int id);

    public EvaluacionMateria createEvaluacionMateria(EvaluacionMateria evaluacionMateria);
    public EvaluacionMateria deleteEvaluacionMateria(int id);
}
