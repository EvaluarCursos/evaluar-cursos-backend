package com.udeaevaluarcursos.repository;


import com.udeaevaluarcursos.models.TotalProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalProfesorRepository extends JpaRepository<TotalProfesor,Integer> {
}
