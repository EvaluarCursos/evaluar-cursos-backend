package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.models.ProfesorMateria;
import com.udeaevaluarcursos.params.response.CourseByFilter;
import com.udeaevaluarcursos.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService{

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    MatriculaServiceImpl matriculaService;

    @Autowired
    ProfesorMateriaServiceImpl profesorMateriaService;

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

    @Override
    public List<Materia> listMateriasByIdEstudiante(int estudiante) {
        return matriculaService.matriculaByEstudiante(estudiante).getIdMateria();
    }

    @Override
    public List<CourseByFilter> listMateriasByFilters(int profesor, String semestre, String facultad) {

        List<ProfesorMateria> lista=profesorMateriaService.listProfesorMateriaByFilters( profesor, semestre,facultad);
        List<CourseByFilter> respuesta= new ArrayList<>();

        for (int i=0;i<lista.toArray().length;i++){
            ProfesorMateria object= lista.get(i);

            respuesta.add(new CourseByFilter(Integer.toString(object.getIdMateria().getIdMateria()),object.getIdMateria().getNombreMateria(),Integer.toString(object.getIdMateria().getCode()), facultad));

        }

        return respuesta;
    }


}
