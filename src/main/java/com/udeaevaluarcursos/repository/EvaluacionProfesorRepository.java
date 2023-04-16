package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.model.Estudiante;
import com.udeaevaluarcursos.model.EvaluacionProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionProfesorRepository extends JpaRepository<EvaluacionProfesor,Integer> {





}
