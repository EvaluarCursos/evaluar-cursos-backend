package com.udeaevaluarcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.udeaevaluarcursos.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmailAndPassword(String email, String password);
    Optional<Usuario> findByEmail(String email);


}
