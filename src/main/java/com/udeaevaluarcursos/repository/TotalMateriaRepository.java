package com.udeaevaluarcursos.repository;


import com.udeaevaluarcursos.models.TotalMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalMateriaRepository extends JpaRepository<TotalMateria,Integer> {
}
