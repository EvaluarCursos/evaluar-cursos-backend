package com.udeaevaluarcursos.controllers;


import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.models.ProfesorMateria;
import com.udeaevaluarcursos.service.ProfesorMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor-materia")
public class ProfesorMateriaController {

    @Autowired
    ProfesorMateriaService profesorMateriaService;

    @PostMapping("/create")
    public ResponseEntity<ProfesorMateria> createProfesorMateria(@RequestBody ProfesorMateria row) {

        ProfesorMateria profesorMateriaCreado = profesorMateriaService.createProfesorMateria(row);

        if (profesorMateriaCreado != null) {
            return new ResponseEntity<>(profesorMateriaCreado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(profesorMateriaCreado, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-profesor-materia")
    public ResponseEntity<List<ProfesorMateria>> listProfesores() {
        return new ResponseEntity<>(profesorMateriaService.listProfesorMateria(), HttpStatus.OK);
    }

    @GetMapping("/list-profesor-materia/{idProfesor}/{semester}/{faculty}")
    public ResponseEntity<List<ProfesorMateria>> listProfesoresByFilters(@PathVariable("idProfesor") int idProfessor,@PathVariable("semester") String semester,@PathVariable("faculty") String faculty) {
        return new ResponseEntity<>(profesorMateriaService.listProfesorMateriaByFilters(idProfessor,semester,faculty), HttpStatus.OK);
    }


}
