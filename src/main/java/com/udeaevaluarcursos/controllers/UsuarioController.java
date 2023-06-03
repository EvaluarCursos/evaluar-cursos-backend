package com.udeaevaluarcursos.controllers;

import java.util.List;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.models.Usuario;
import com.udeaevaluarcursos.params.request.Login;
import com.udeaevaluarcursos.params.response.UsuarioLogeado;
import com.udeaevaluarcursos.service.EstudianteServiceImpl;
import com.udeaevaluarcursos.service.MateriaServiceImpl;
import com.udeaevaluarcursos.service.ProfesorServiceImpl;
import com.udeaevaluarcursos.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;
    @Autowired
    ProfesorServiceImpl profesorServiceImpl;
    @Autowired
    EstudianteServiceImpl estudianteServiceImpl;

    @Autowired
    MateriaServiceImpl materiaService;

    @PostMapping("/log")
    public ResponseEntity<UsuarioLogeado> login(
            @RequestBody Login login
    ) {
        Usuario usuario = usuarioServiceImpl.getUsuarioByEmailAndPassword(login.getEmail(), login.getPassword());
        if (usuario != null){
            UsuarioLogeado usuarioLogeado = new UsuarioLogeado();
            usuarioLogeado.setRole(usuario.getRol());
            if(usuario.getRol().equals("student")){
                Estudiante estudianteEncontrado=estudianteServiceImpl.getEstudianteByEmail(login.getEmail());
                usuarioLogeado.setCourses(materiaService.listMateriasByIdEstudiante(estudianteEncontrado.getIdEstudiante()));
                usuarioLogeado.setUserId(estudianteEncontrado.getIdEstudiante());
                return new ResponseEntity<>(usuarioLogeado,HttpStatus.OK);


            } else if (usuario.getRol().equals("teacher")){
                Profesor profesorEncontrado=profesorServiceImpl.getProfesorByEmail(login.getEmail());
                usuarioLogeado.setUserId(profesorEncontrado.getIdProfesor());
                return new ResponseEntity<>(usuarioLogeado,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


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
