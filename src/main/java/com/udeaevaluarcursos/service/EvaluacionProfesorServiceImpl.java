package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.model.EvaluacionMateria;
import com.udeaevaluarcursos.model.EvaluacionProfesor;
import com.udeaevaluarcursos.repository.EvaluacionMateriaRepository;
import com.udeaevaluarcursos.repository.EvaluacionProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EvaluacionProfesorServiceImpl implements EvaluacionProfesorService{

    @Autowired
    EvaluacionProfesorRepository evaluacionProfesorRepository;


    @Override
    public List<EvaluacionProfesor> listEvaluacionesProfesores() {
        return null;
    }

    @Override
    public Optional<EvaluacionProfesor> getEvaluacionProfesorById(int id) {
        return Optional.empty();
    }

    @Override
    public EvaluacionProfesor createEvaluacionProfesor(EvaluacionMateria evaluacionMateria) {
        return null;
    }

    @Override
    public EvaluacionProfesor deleteEvaluacionProfesor(int id) {
        return null;
    }
}
