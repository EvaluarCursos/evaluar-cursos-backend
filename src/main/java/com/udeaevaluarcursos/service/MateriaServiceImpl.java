package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.repository.EvaluacionProfesorRepository;
import com.udeaevaluarcursos.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService{

    @Autowired
    MateriaRepository materiaRepository;


    @Override
    public List<Materia> listMaterias() {
        List<Materia> listadoMaterias = materiaRepository.findAll();

        return listadoMaterias;
    }

    @Override
    public Materia getMateriaById(int id) {
        Optional<Materia> materia= materiaRepository.findById(id);
        if (!materia.isPresent()) {
            return null;
        }

        return materia.get();
    }

    @Override
    public Materia createMateria(Materia materia) {
        Optional<Materia> materiaPorId= materiaRepository.findById(materia.getIdMateria());

        if(materiaPorId.isPresent()) {
            return null;
        }

        materiaRepository.save(materia);

        return materia;
    }

    @Override
    public Materia deleteMateria(int id) {
        Optional<Materia> materia= materiaRepository.findById(id);
        if (!materia.isPresent()) {
            return null;
        }
        materiaRepository.delete(materia.get());

        return materia.get();
    }

    @Override
    public Materia updateMateria(Materia materia) {
        Optional<Materia> materiaActualizar= materiaRepository.findById(materia.getIdMateria());
        if (!materiaActualizar.isPresent()) {
            return null;
        }

        Materia materiaActualizada= materiaActualizar.get();
        materiaActualizada.setNombreMateria(materia.getNombreMateria());
        materiaRepository.save(materiaActualizada);


        return materiaActualizar.get();
    }
}
