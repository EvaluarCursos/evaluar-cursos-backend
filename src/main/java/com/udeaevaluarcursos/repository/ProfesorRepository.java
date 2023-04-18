package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.Profesor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
    Optional<Profesor> findByCedula(int cedula);
    Optional<Profesor> deleteByCedula(int cedula);
}
