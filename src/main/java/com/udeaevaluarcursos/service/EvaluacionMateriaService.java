package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.model.EvaluacionMateria;
import com.udeaevaluarcursos.model.EvaluacionProfesor;

import java.util.List;
import java.util.Optional;

public interface EvaluacionMateriaService {
    public List<EvaluacionMateria> listEvaluacionesMaterias();
    public Optional<EvaluacionMateria> getEvaluacionMateriaById(int id);

    public EvaluacionMateria createEvaluacionMateria(EvaluacionMateria evaluacionMateria);
    public EvaluacionMateria deleteEvaluacionMateria(int id);
}
