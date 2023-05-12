package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.EvaluacionProfesor;
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
        List<EvaluacionProfesor> listadoEvaluacionesProfesores = evaluacionProfesorRepository.findAll();

        return listadoEvaluacionesProfesores;
    }

    @Override
    public EvaluacionProfesor getEvaluacionProfesorById(int id) {
        Optional<EvaluacionProfesor> evaluacionProfesor= evaluacionProfesorRepository.findById(id);
        if (!evaluacionProfesor.isPresent()) {
            return null;
        }

        return evaluacionProfesor.get();
    }

    @Override
    public EvaluacionProfesor createEvaluacionProfesor(EvaluacionProfesor evaluacionProfesor) {
        Optional<EvaluacionProfesor> evaluacionProfesorPorId= evaluacionProfesorRepository.findById(evaluacionProfesor.getIdEvaluacionProfesor());

        if(evaluacionProfesorPorId.isPresent()) {
            return null;
        }

        evaluacionProfesorRepository.save(evaluacionProfesor);

        return evaluacionProfesor;
    }

    @Override
    public EvaluacionProfesor deleteEvaluacionProfesor(int id) {
        Optional<EvaluacionProfesor> evaluacionProfesor= evaluacionProfesorRepository.findById(id);
        if (!evaluacionProfesor.isPresent()) {
            return null;
        }
        evaluacionProfesorRepository.delete(evaluacionProfesor.get());

        return evaluacionProfesor.get();
    }





}
