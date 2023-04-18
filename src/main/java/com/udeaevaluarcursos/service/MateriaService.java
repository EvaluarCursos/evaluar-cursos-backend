package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.*;

import java.util.List;
import java.util.Optional;

public interface MateriaService {
    public List<Materia> listMaterias();
    public Materia getMateriaById(int id);
    public Materia createMateria(Materia materia);
    public Materia deleteMateria(int id);
    public Materia updateMateria(Materia materia);
}
