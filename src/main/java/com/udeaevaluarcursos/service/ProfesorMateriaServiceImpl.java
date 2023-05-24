package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.ProfesorMateria;
import com.udeaevaluarcursos.repository.ProfesorMateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorMateriaServiceImpl implements ProfesorMateriaService{

    @Autowired
    ProfesorMateriaRepository profesorMateriaRepository;

    @Override
    public ProfesorMateria createProfesorMateria(ProfesorMateria row) {
        profesorMateriaRepository.save(row);
        return row;
    }

    @Override
    public List<ProfesorMateria> listProfesorMateria() {
        return profesorMateriaRepository.findAll();
    }

    @Override
    public List<ProfesorMateria> listProfesorMateriaByFilters(int idProfesor, String semester, String faculty) {
        return List.of(profesorMateriaRepository.findByFilters(idProfesor, semester, faculty));
    }


}
