package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.PreguntasEvaluaciones;
import com.udeaevaluarcursos.models.ProfesorMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorMateriaRepository extends JpaRepository<ProfesorMateria,Integer> {

    @Query(value = "select u from ProfesorMateria u where u.idProfesor.idProfesor = :idProfessor and  u.faculty=:faculty and u.semestre=:semester")
    ProfesorMateria[] findByFilters(int idProfessor,String semester, String faculty);


}
