package com.udeaevaluarcursos.controller;


import com.udeaevaluarcursos.model.Materia;
import com.udeaevaluarcursos.service.MateriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    MateriaServiceImpl materiaServiceImpl;

    @PostMapping("/create-materia")
    public ResponseEntity<Materia> createMateria(@RequestBody Materia materia){

        Materia materiaCreada=materiaServiceImpl.createMateria(materia);

        if(materiaCreada != null){
            return new ResponseEntity<>(materiaCreada, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(materiaCreada, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-materias")
    public ResponseEntity<List<Materia>> listMaterias(){
        return new ResponseEntity<>(materiaServiceImpl.listMaterias(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable("id") int id ){

        Materia materia=materiaServiceImpl.getMateriaById(id);

        if(materia != null){
            return new ResponseEntity<>(materia, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(materia, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-materia/{id}")
    public ResponseEntity<Materia> deleteMateria(@PathVariable("id") int id){
        Materia materia=materiaServiceImpl.deleteMateria(id);

        if(materia != null){
            return new ResponseEntity<>(materia, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(materia, HttpStatus.BAD_REQUEST);
        }
    }




    @PutMapping("update-materia")
    public ResponseEntity<Materia> updateMateria(@RequestBody Materia materia){

        Materia materiaActualizada=materiaServiceImpl.updateMateria(materia);

        if(materiaActualizada != null){
            return new ResponseEntity<>(materiaActualizada, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(materiaActualizada, HttpStatus.BAD_REQUEST);
        }
    }
}
