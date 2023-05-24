package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia,Integer> {


    @Query(value = "select u from EvaluacionMateria u where u.idProfesor.idProfesor = :idProfessor and  u.idMateria.code = :codeMateria")
    EvaluacionMateria[] findByCode(int idProfessor, int codeMateria);

}
