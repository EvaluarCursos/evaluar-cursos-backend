package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.EvaluacionProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionProfesorRepository extends JpaRepository<EvaluacionProfesor,Integer> {





}
