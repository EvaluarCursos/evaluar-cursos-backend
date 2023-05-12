package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> listUsuarios();
    public Usuario getUsuarioByEmail(String email);
    public Usuario getUsuarioByEmailAndPassword(String email, String password);
    public Usuario createUsuario(Usuario usuario);
    public Usuario deleteUsuario(int id);
    public Usuario updateUsuario(Usuario estudiante);
}
