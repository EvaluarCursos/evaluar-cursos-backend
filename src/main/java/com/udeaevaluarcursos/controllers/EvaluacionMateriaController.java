package com.udeaevaluarcursos.controllers;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.service.EvaluacionMateriaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/evaluacion-materia")
public class EvaluacionMateriaController {
    @Autowired
    EvaluacionMateriaServiceImpl evaluacionMateriaServiceImpl;

    @PostMapping("/create-evaluacion-materia")
    public ResponseEntity<EvaluacionMateria> createEvaluacionMateria(@RequestBody EvaluacionMateria evaluacionMateria){

        EvaluacionMateria evaluacionMateriaCreada=evaluacionMateriaServiceImpl.createEvaluacionMateria(evaluacionMateria);

        if(evaluacionMateriaCreada != null){
            return new ResponseEntity<>(evaluacionMateriaCreada, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(evaluacionMateriaCreada, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list-evaluaciones-materias")
    public ResponseEntity<List<EvaluacionMateria>> listMaterias(){
        return new ResponseEntity<>(evaluacionMateriaServiceImpl.listEvaluacionesMaterias(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionMateria> getEvaluacionMateriaById(@PathVariable("id") int id ){

        EvaluacionMateria evaluacionMateria=evaluacionMateriaServiceImpl.getEvaluacionMateriaById(id);

        if(evaluacionMateria != null){
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-evaluacion-materia/{id}")
    public ResponseEntity<EvaluacionMateria> deleteEvaluacionMateria(@PathVariable("id") int id){
        EvaluacionMateria evaluacionMateria=evaluacionMateriaServiceImpl.deleteEvaluacionMateria(id);

        if(evaluacionMateria != null){
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.BAD_REQUEST);
        }
    }


}
