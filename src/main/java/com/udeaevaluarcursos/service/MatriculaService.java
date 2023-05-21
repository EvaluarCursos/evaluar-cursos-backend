package com.udeaevaluarcursos.service;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.params.response.CoursesPerStudent;
import com.udeaevaluarcursos.params.response.CoursesPerTeacher;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    
    public List<Matricula> listMatriculas();
    public Matricula getMatriculaById(int id);
    public Matricula createMatricula(Matricula matricula);
    public Matricula deleteMatricula(int id);

    public Matricula updateMatricula(Matricula matricula);

    /*
    List<CoursesPerTeacher> getCoursesPerTeacher(
            int profesorId,
            String faculty,
            String semester,
            String materia
    );

    public List<CoursesPerStudent> getCoursesPerStudent(int estudianteId);
    */

}
