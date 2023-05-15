package com.udeaevaluarcursos.controllers;

import com.udeaevaluarcursos.models.Matricula;

import com.udeaevaluarcursos.service.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.udeaevaluarcursos.params.response.CoursesPerStudent;
import com.udeaevaluarcursos.params.response.CoursesPerTeacher;


import java.util.List;
@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    MatriculaServiceImpl matriculaServiceImpl;

    @GetMapping("/courses-per-student/{idEstudiante}")
    public ResponseEntity<List<CoursesPerStudent>> coursesPerStudent(
            @PathVariable("userId") int estudianteId
    ){
        List<CoursesPerStudent> coursesPerStudent = matriculaServiceImpl.getCoursesPerStudent(estudianteId);
        if (coursesPerStudent != null) {
            return new ResponseEntity<>(coursesPerStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/courses-per-teacher/{idProfesor}")
    public ResponseEntity<List<CoursesPerTeacher>> coursesPerTeacher(
            @PathVariable("userID") int profesorId,
            @RequestParam(name="Faculty", required = false) String faculty,
            @RequestParam(name="Semester", required = false) String semester,
            @RequestParam(name="Course", required = false) String course
    ){
        List<CoursesPerTeacher> coursesPerTeacher = matriculaServiceImpl.getCoursesPerTeacher(
                profesorId,
                faculty,
                semester,
                course
        );
        if (coursesPerTeacher != null) {
            return new ResponseEntity<>(coursesPerTeacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create-matricula")
    public ResponseEntity<Matricula> createMatricula(@RequestBody Matricula matricula) {

        Matricula matriculaCreada = matriculaServiceImpl.createMatricula(matricula);

        if (matriculaCreada != null) {
            return new ResponseEntity<>(matriculaCreada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(matriculaCreada, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-matriculas")
    public ResponseEntity<List<Matricula>> listMatriculas() {
        return new ResponseEntity<>(matriculaServiceImpl.listMatriculas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getMatriculaById(@PathVariable("id") int id) {

        Matricula matricula = matriculaServiceImpl.getMatriculaById(id);

        if (matricula != null) {
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(matricula, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-matricula/{id}")
    public ResponseEntity<Matricula> deleteMatricula(@PathVariable("id") int id) {
        Matricula matricula = matriculaServiceImpl.deleteMatricula(id);

        if (matricula != null) {
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(matricula, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("update-matricula")
    public ResponseEntity<Matricula> updateMatricula(@RequestBody Matricula matricula) {

        Matricula matriculaActualizada = matriculaServiceImpl.updateMatricula(matricula);

        if (matriculaActualizada != null) {
            return new ResponseEntity<>(matriculaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(matriculaActualizada, HttpStatus.BAD_REQUEST);
        }
    }
}
