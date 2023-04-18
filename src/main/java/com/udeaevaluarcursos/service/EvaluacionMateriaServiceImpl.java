package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.repository.EvaluacionMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EvaluacionMateriaServiceImpl implements EvaluacionMateriaService{

    @Autowired
    EvaluacionMateriaRepository evaluacionMateriaRepository;
    @Override
    public List<EvaluacionMateria> listEvaluacionesMaterias() {
        List<EvaluacionMateria> listadoEvaluacionesMaterias = evaluacionMateriaRepository.findAll();

        return listadoEvaluacionesMaterias;
    }

    @Override
    public EvaluacionMateria getEvaluacionMateriaById(int id) {
        Optional<EvaluacionMateria> evaluacionMateria= evaluacionMateriaRepository.findById(id);
        if (!evaluacionMateria.isPresent()) {
            return null;
        }

        return evaluacionMateria.get();
    }

    @Override
    public EvaluacionMateria createEvaluacionMateria(EvaluacionMateria evaluacionMateria) {
        Optional<EvaluacionMateria> evaluacionMateriaPorId= evaluacionMateriaRepository.findById(evaluacionMateria.getIdEvaluacionMateria());

        if(evaluacionMateriaPorId.isPresent()) {
            return null;
        }

        evaluacionMateriaRepository.save(evaluacionMateria);

        return evaluacionMateria;
    }

    @Override
    public EvaluacionMateria deleteEvaluacionMateria(int id) {
        Optional<EvaluacionMateria> evaluacionMateria= evaluacionMateriaRepository.findById(id);
        if (!evaluacionMateria.isPresent()) {
            return null;
        }
        evaluacionMateriaRepository.delete(evaluacionMateria.get());

        return evaluacionMateria.get();
    }
}
