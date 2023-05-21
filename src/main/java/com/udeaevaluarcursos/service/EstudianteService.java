package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import java.util.List;


public interface EstudianteService {
    public List<Estudiante> listEstudiantes();
    public Estudiante getEstudianteByCedula(int cedula);

    public Estudiante createEstudiante(Estudiante estudiante);
    public Estudiante deleteEstudiante(int cedula);

    public Estudiante updateEstudiante(Estudiante estudiante);
}
