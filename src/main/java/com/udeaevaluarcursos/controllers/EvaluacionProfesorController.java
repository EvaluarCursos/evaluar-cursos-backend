package com.udeaevaluarcursos.controllers;
import com.udeaevaluarcursos.models.EvaluacionProfesor;
import com.udeaevaluarcursos.service.EvaluacionProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@Controller
@RequestMapping("/evaluacion-profesor")
public class EvaluacionProfesorController {


    @Autowired
    EvaluacionProfesorServiceImpl evaluacionProfesorServiceImpl;


    @PostMapping("/create-evaluacion-profesor")
    public ResponseEntity<EvaluacionProfesor> createEvaluacionProfesor(@RequestBody EvaluacionProfesor evaluacionProfesor){

        EvaluacionProfesor evaluacionProfesorCreada=evaluacionProfesorServiceImpl.createEvaluacionProfesor(evaluacionProfesor);

        if(evaluacionProfesorCreada != null){
            return new ResponseEntity<>(evaluacionProfesorCreada, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(evaluacionProfesorCreada, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/list-evaluaciones-profesor")
    public ResponseEntity<List<EvaluacionProfesor>> listProfesor(){
        return new ResponseEntity<>(evaluacionProfesorServiceImpl.listEvaluacionesProfesores(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionProfesor> getEvaluacionProfesorById(@PathVariable("id") int id ){

        EvaluacionProfesor evaluacionProfesor=evaluacionProfesorServiceImpl.getEvaluacionProfesorById(id);

        if(evaluacionProfesor != null){
            return new ResponseEntity<>(evaluacionProfesor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(evaluacionProfesor, HttpStatus.BAD_REQUEST);
        }
    }





    @DeleteMapping("/delete-evaluacion-profesor/{id}")
    public ResponseEntity<EvaluacionProfesor> deleteEvaluacionProfesor(@PathVariable("id") int id){
        EvaluacionProfesor evaluacionProfesor=evaluacionProfesorServiceImpl.deleteEvaluacionProfesor(id);

        if(evaluacionProfesor != null){
            return new ResponseEntity<>(evaluacionProfesor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(evaluacionProfesor, HttpStatus.BAD_REQUEST);
        }
    }
}



