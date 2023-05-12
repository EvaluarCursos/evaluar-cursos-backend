package com.udeaevaluarcursos.controllers;

import java.util.List;

import com.udeaevaluarcursos.models.Usuario;
import com.udeaevaluarcursos.params.response.UsuarioLogeado;
import com.udeaevaluarcursos.service.EstudianteServiceImpl;
import com.udeaevaluarcursos.service.ProfesorServiceImpl;
import com.udeaevaluarcursos.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;
    @Autowired
    ProfesorServiceImpl profesorServiceImpl;
    @Autowired
    EstudianteServiceImpl estudianteServiceImpl;

    @GetMapping("/login")
    public ResponseEntity<UsuarioLogeado> login(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "password", required = true) String password
    ) {
        Usuario usuario = usuarioServiceImpl.getUsuarioByEmailAndPassword(email, password);
        if (usuario != null){
            UsuarioLogeado usuarioLogeado = new UsuarioLogeado();
            if(usuario.getRol() == "Estudiante"){
                estudianteServiceImpl.getBy()
                usuarioLogeado.setRol(usuario.getRol());

            } else if (usuario.getRol() == "Profesor"){

            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/create-usuario")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {

        Usuario usuarioCreado = usuarioServiceImpl.createUsuario(usuario);

        if (usuarioCreado != null) {
            return new ResponseEntity<>(usuarioCreado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-usuarios")
    public ResponseEntity<List<Usuario>> listUsuarios() {
        return new ResponseEntity<>(usuarioServiceImpl.listUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable("email") String email) {

        Usuario usuario = usuarioServiceImpl.getUsuarioByEmail(email);

        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-usuairo/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") int id) {
        Usuario usuario = usuarioServiceImpl.deleteUsuario(id);

        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("update-usuario")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {

        Usuario usuarioActualizado = usuarioServiceImpl.updateUsuario(usuario);

        if (usuarioActualizado != null) {
            return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
