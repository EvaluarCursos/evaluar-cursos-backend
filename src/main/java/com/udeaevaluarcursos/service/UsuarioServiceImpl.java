package com.udeaevaluarcursos.service;
import com.udeaevaluarcursos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udeaevaluarcursos.models.Usuario;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listUsuarios(){
        List<Usuario> listUsuarios = usuarioRepository.findAll();
        return listUsuarios;
    }

    @Override
    public Usuario getUsuarioByEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (!usuario.isPresent()) {
            return null;
        }

        return usuario.get();
    }

    @Override
    public Usuario getUsuarioByEmailAndPassword(String email, String password){
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndPassword(email, password);
        if (!usuario.isPresent()) {
            return null;
        }

        return usuario.get();
    }

    @Override
    public Usuario createUsuario(Usuario usuario){
        Optional<Usuario> usuarioPorEmail= usuarioRepository.findByEmail(usuario.getEmail());

        if(usuarioPorEmail.isPresent()) {
            return null;
        }

        usuarioRepository.save(usuario);

        return usuario;
    }

    @Override
    public Usuario deleteUsuario(int id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            return null;
        }
        usuarioRepository.delete(usuario.get());

        return usuario.get();
    }

    @Override
    public Usuario updateUsuario(Usuario usuario){
        Optional<Usuario> usuarioActualizar= usuarioRepository.findById(usuario.getId());
        if (!usuarioActualizar.isPresent()) {
            return null;
        }
        Usuario usuarioActualizado = usuarioActualizar.get();

        usuarioActualizado.setId(usuario.getId());
        usuarioRepository.save(usuarioActualizado);


        return usuarioActualizado;
    }
}
