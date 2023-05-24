package com.udeaevaluarcursos.repository;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Profesor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
    Optional<Profesor> findByCedula(int cedula);
    Optional<Profesor> findByEmail(String email);
    Optional<Profesor> getProfesorsByIdUsuario_Id(int idUsuario);
}
