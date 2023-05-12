package com.udeaevaluarcursos.controllers;

import com.udeaevaluarcursos.models.Profesor;

import com.udeaevaluarcursos.service.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.udeaevaluarcursos.params.response.CoursesPerTeacher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {
    @Autowired
    ProfesorServiceImpl profesorServiceImpl;
    @PostMapping("/create-profesor")
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {

        Profesor profesorCreado = profesorServiceImpl.createProfesor(profesor);

        if (profesorCreado != null) {
            return new ResponseEntity<>(profesorCreado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(profesorCreado, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-profesores")
    public ResponseEntity<List<Profesor>> listProfesores() {
        return new ResponseEntity<>(profesorServiceImpl.listProfesors(), HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Profesor> getProfesorByCedula(@PathVariable("cedula") int cedula) {

        Profesor profesor = profesorServiceImpl.getProfesorByCedula(cedula);

        if (profesor != null) {
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(profesor, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-profesor/{cedula}")
    public ResponseEntity<Profesor> deleteProfesor(@PathVariable("cedula") int cedula) {
        Profesor profesor = profesorServiceImpl.deleteProfesor(cedula);

        if (profesor != null) {
            return new ResponseEntity<>(profesor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(profesor, HttpStatus.BAD_REQUEST);
        }


    }


    @PutMapping("update-profesor")
    public ResponseEntity<Profesor> updateProfesor(@RequestBody Profesor profesor) {

        Profesor profesorActualizado = profesorServiceImpl.updateProfesor(profesor);

        if (profesorActualizado != null) {
            return new ResponseEntity<>(profesorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(profesorActualizado, HttpStatus.BAD_REQUEST);
        }
    }
}
