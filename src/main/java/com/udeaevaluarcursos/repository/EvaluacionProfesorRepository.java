package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionProfesorRepository extends JpaRepository<EvaluacionProfesor,Integer> {
    @Query("select u from EvaluacionProfesor u where u.idProfesor = :profesor and  u.idMateria = :materia")
    EvaluacionProfesor[] findByFilters(Profesor profesor, Materia materia );
}
