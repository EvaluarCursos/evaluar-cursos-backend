package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvaluacionMateriaRepository extends JpaRepository<EvaluacionMateria,Integer> {

    @Query("select u from EvaluacionMateria u where u.idProfesor = :profesor and  u.idMateria = :materia")
    EvaluacionMateria[] findByFilters(Profesor profesor, Materia materia );

    @Query(value = "select u from EvaluacionMateria u where u.idProfesor.idProfesor = :idProfessor and  u.idMateria.idMateria = :codeMateria")
    EvaluacionMateria[] findByCode(int idProfessor,int codeMateria);


}
