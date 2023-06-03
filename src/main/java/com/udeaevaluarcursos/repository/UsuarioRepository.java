package com.udeaevaluarcursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.udeaevaluarcursos.models.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario u where u.email = :email and  u.password= :password")
    Optional<Usuario> findByEmailAndPassword(String email, String password);
    Optional<Usuario> findByEmail(String email);



}
