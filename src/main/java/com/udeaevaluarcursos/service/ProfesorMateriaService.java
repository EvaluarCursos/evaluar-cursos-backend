package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.models.ProfesorMateria;

import java.util.List;

public interface ProfesorMateriaService {

    public ProfesorMateria createProfesorMateria(ProfesorMateria row);

   public List<ProfesorMateria> listProfesorMateria();

    public List<ProfesorMateria> listProfesorMateriaByFilters(int idProfesor,String semester, String faculty);



}
