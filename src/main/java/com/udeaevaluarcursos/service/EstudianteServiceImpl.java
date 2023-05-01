package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> listEstudiantes() {
        List<Estudiante> listadoEstudiantes = estudianteRepository.findAll();

        return listadoEstudiantes;
    }

    public int getCedulaByUserId(int idUsuario){
        Optional<Estudiante> estudiante = estudianteRepository.idUsuario);
        if(!estudiante.isPresent()){
            return 0;
        }
        return estudiante.get().getCedula();
    }

    @Override
    public Estudiante getEstudianteByCedula(int cedula) {
        Optional<Estudiante> estudiante= estudianteRepository.findByCedula(cedula);
        if (!estudiante.isPresent()) {
            return null;
        }

        return estudiante.get();
    }

    @Override
    public Estudiante createEstudiante(Estudiante estudiante)  {

        Optional<Estudiante> estudiantePorCedula= estudianteRepository.findByCedula(estudiante.getCedula());

        if(estudiantePorCedula.isPresent()) {
            return null;
        }

        estudianteRepository.save(estudiante);

        return estudiante;
    }

    @Override
    public Estudiante deleteEstudiante(int cedula) {
        Optional<Estudiante> estudiante= estudianteRepository.findByCedula(cedula);
        if (!estudiante.isPresent()) {
            return null;
        }
        estudianteRepository.delete(estudiante.get());

        return estudiante.get();
    }

    @Override
    public Estudiante updateEstudiante(Estudiante estudiante) {
        Optional<Estudiante> estudianteActualizar= estudianteRepository.findById(estudiante.getIdEstudiante());
        if (!estudianteActualizar.isPresent()) {
            return null;
        }
        Estudiante estudianteActualizado= estudianteActualizar.get();

        estudianteActualizado.setCedula(estudiante.getCedula());
        estudianteRepository.save(estudianteActualizado);


        return estudianteActualizado;
    }
}
