package com.udeaevaluarcursos.service;

import java.util.List;
import java.util.Optional;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService  {
    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public List<Matricula> listMatriculas() {
        List<Matricula> listadoMatriculas = matriculaRepository.findAll();

        return listadoMatriculas;
    }

    @Override
    public Matricula getMatriculaById(int id) {
        Optional<Matricula> matricula= matriculaRepository.findById(id);
        if (!matricula.isPresent()) {
            return null;
        }

        return matricula.get();
    }

    @Override
    public Matricula createMatricula(Matricula matricula) {

        /* LIMITO QUE SOLO HAYA UNA MATRICULA POR ESTUDIANTE AL INTENTAR CREAR LA MATRICULA*/
        Optional<Matricula> matriculaPorId= matriculaRepository.findByidEstudiante(matricula.getIdEstudiante());

        if(matriculaPorId.isPresent()) {
            return null;
        }

        matriculaRepository.save(matricula);

        return matricula;
    }

    @Override
    public Matricula deleteMatricula(int id) {
        Optional<Matricula> matricula= matriculaRepository.findById(id);
        if (!matricula.isPresent()) {
            return null;
        }
        matriculaRepository.delete(matricula.get());

        return matricula.get();
    }

    @Override
    public Matricula updateMatricula(Matricula matricula) {
        Optional<Matricula> matriculaActualizar= matriculaRepository.findById(matricula.getIdMatricula());
        if (!matriculaActualizar.isPresent()) {
            return null;
        }
        Matricula matriculaActualizada= matriculaActualizar.get();

        matriculaActualizada.setCalificado(matricula.getCalificado());
        matriculaRepository.save(matriculaActualizada);


        return matriculaActualizada;
    }
}
