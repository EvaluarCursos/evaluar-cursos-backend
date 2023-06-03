package com.udeaevaluarcursos.controllers;

import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.models.ProfesorMateria;
import com.udeaevaluarcursos.params.response.CourseByFilter;
import com.udeaevaluarcursos.params.response.EvaluationResponse;
import com.udeaevaluarcursos.service.EvaluacionMateriaServiceImpl;
import com.udeaevaluarcursos.service.MateriaServiceImpl;
import com.udeaevaluarcursos.service.ProfesorMateriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courses")
public class MateriaController {

    @Autowired
    MateriaServiceImpl materiaServiceImpl;

    @Autowired
    ProfesorMateriaServiceImpl profesorMateriaService;

    @Autowired
    EvaluacionMateriaServiceImpl evaluacionMateriaServiceImpl;


    @PostMapping("/create-materia")
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia) {

        Materia materiaCreada = materiaServiceImpl.createMateria(materia);

        if (materiaCreada != null) {
            return new ResponseEntity<>(materiaCreada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(materiaCreada, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{userId}/")
    public ResponseEntity<List<CourseByFilter>> listMateriasByFilters(@PathVariable ("userId") int idProfessor, @RequestParam ("semester") String semester, @RequestParam ("faculty") String faculty) {
        return new ResponseEntity<>(materiaServiceImpl.listMateriasByFilters(idProfessor,semester,faculty), HttpStatus.OK);
    }

    @GetMapping("/list-materias")
    public ResponseEntity<List<Materia>> listMaterias() {
        return new ResponseEntity<>(materiaServiceImpl.listMaterias(), HttpStatus.OK);
    }

    @GetMapping("/list-materias/{id}")
    public ResponseEntity<List<Materia>> listMateriasByEstudiante(@PathVariable("id") int id) {
        return new ResponseEntity<>(materiaServiceImpl.listMateriasByIdEstudiante(id), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable("id") int id) {

        Materia materia = materiaServiceImpl.getMateriaById(id);

        if (materia != null) {
            return new ResponseEntity<>(materia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(materia, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-materia/{id}")
    public ResponseEntity<Materia> deleteMateria(@PathVariable("id") int id) {
        Materia materia = materiaServiceImpl.deleteMateria(id);

        if (materia != null) {
            return new ResponseEntity<>(materia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(materia, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("update-materia")
    public ResponseEntity<Materia> updateMateria(@RequestBody Materia materia) {

        Materia materiaActualizada = materiaServiceImpl.updateMateria(materia);

        if (materiaActualizada != null) {
            return new ResponseEntity<>(materiaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(materiaActualizada, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{idProfesor}/{idMateria}")
    public ResponseEntity<EvaluationResponse> getInformeByIdMateria(@PathVariable("idProfesor") int idProfesor , @PathVariable("idMateria") int idMateria){

        EvaluationResponse evaluacionMateria=evaluacionMateriaServiceImpl.getInformeByIdMateria(idProfesor,idMateria);


        return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);


    }


}