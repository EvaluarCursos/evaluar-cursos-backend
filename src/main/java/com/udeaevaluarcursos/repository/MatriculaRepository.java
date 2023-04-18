package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Integer> {


    Optional<Matricula> findByidEstudiante(Estudiante idEstudiante);
}
