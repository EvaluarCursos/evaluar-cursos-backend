package com.udeaevaluarcursos.repository;
import com.udeaevaluarcursos.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Integer>{

    Optional<Estudiante> findByCedula(int cedula);
    Optional<Estudiante> getByIdUsuario_Id(int idUsuario);

    Optional<Estudiante> findByEmail(String email);
    Optional<Estudiante> deleteByCedula(int cedula);
}
