package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Integer> {


    @Query("select u from Matricula u where u.idEstudiante.idEstudiante = :estudiante")
    Optional<Matricula> findMatriculaByFilter(int estudiante);

    List<Matricula> findAllByIdEstudiante_IdEstudiante(int idEstudiante);

    /*
    @Query("SELECT m FROM Matricula m JOIN m.idProfesor p WHERE p.idProfesor = :idProfesor" +
            " AND (:faculty IS NULL OR m.faculty = :faculty)" +
            " AND (:semester IS NULL OR m.semestre = :semester)" +
            " AND (:materia IS NULL OR m.idMateria.nombre = :materia)")
    List<Matricula> findAllByIdProfesor_IdProfesorAndFacultyAndSemesterAndMateria(
            int idProfesor,
            @Param("faculty") String faculty,
            @Param("semester") String semester,
            @Param("materia") String materia
    );
    */


}
