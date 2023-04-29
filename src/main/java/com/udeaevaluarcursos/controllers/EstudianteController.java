package com.udeaevaluarcursos.controllers;


import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.service.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteServiceImpl estudianteServiceImpl;


    @PostMapping("/create-estudiante")
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante) {

        Estudiante estudianteCreado = estudianteServiceImpl.createEstudiante(estudiante);

        if (estudianteCreado != null) {
            return new ResponseEntity<>(estudianteCreado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estudianteCreado, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-estudiantes")
    public ResponseEntity<List<Estudiante>> listEstudiantes() {
        return new ResponseEntity<>(estudianteServiceImpl.listEstudiantes(), HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Estudiante> getEstudianteByCedula(@PathVariable("cedula") int cedula) {

        Estudiante estudiante = estudianteServiceImpl.getEstudianteByCedula(cedula);

        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estudiante, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-estudiante/{cedula}")
    public ResponseEntity<Estudiante> deleteEstudiante(@PathVariable("cedula") int cedula) {
        Estudiante estudiante = estudianteServiceImpl.deleteEstudiante(cedula);

        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estudiante, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("update-estudiante")
    public ResponseEntity<Estudiante> updateEstudiante(@RequestBody Estudiante estudiante) {

        Estudiante estudianteActualizado = estudianteServiceImpl.updateEstudiante(estudiante);

        if (estudianteActualizado != null) {
            return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estudianteActualizado, HttpStatus.BAD_REQUEST);
        }
    }
}

