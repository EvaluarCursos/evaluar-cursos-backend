package com.udeaevaluarcursos.service;

import java.util.List;
import java.util.Optional;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Matricula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> listProfesors() {
       List<Profesor> profesors = profesorRepository.findAll();
       return profesors;
    }

    @Override
    public Profesor getProfesorByCedula(int cedula) {
        Optional<Profesor> profesor = profesorRepository.findByCedula(cedula);
        if(!profesor.isPresent()){
            return null;
        }
        return profesor.get();

    }

    @Override
    public Profesor createProfesor(Profesor profesor)  {
        Optional<Profesor> tempProfesor = profesorRepository.findByCedula(profesor.getCedula());
        if(tempProfesor.isPresent()){
            return null;
        }
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor deleteProfesor(int cedula) {
        Optional<Profesor> profesor= profesorRepository.findByCedula(cedula);
        if (!profesor.isPresent()) {
            return null;
        }
        profesorRepository.delete(profesor.get());

        return profesor.get();
    }

    @Override
    public Profesor updateProfesor(Profesor profesor) {
        Optional<Profesor> profesorActualizar= profesorRepository.findById(profesor.getIdProfesor());
        if (!profesorActualizar.isPresent()) {
            return null;
        }
        Profesor profesorActualizado= profesorActualizar.get();

        profesorActualizado.setCedula(profesor.getCedula());
        profesorRepository.save(profesorActualizado);


        return profesorActualizado;
    }

}
