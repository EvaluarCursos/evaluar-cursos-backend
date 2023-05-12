package com.udeaevaluarcursos.controllers;

import com.udeaevaluarcursos.models.EvaluacionProfesor;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.params.request.EvalProfesorRequest;
import com.udeaevaluarcursos.repository.EvaluacionProfesorRepository;
import com.udeaevaluarcursos.repository.MatriculaRepository;
import com.udeaevaluarcursos.service.EvaluacionProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/evaluacion-profesor")
public class EvaluacionProfesorController {


    @Autowired
    EvaluacionProfesorServiceImpl evaluacionProfesorServiceImpl;
    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    EvaluacionProfesorRepository evaluacionProfesorRepository;
    @PostMapping("/form")
    public ResponseEntity<EvaluacionProfesor> createEvaluacion(@RequestBody EvalProfesorRequest evaluacionRequest) {
        EvaluacionProfesor evaluacionProfesor = new EvaluacionProfesor();
        evaluacionProfesor.setNotaUno(evaluacionRequest.getNotaUno());
        evaluacionProfesor.setNotaDos(evaluacionRequest.getNotaDos());
        evaluacionProfesor.setNotaTres(evaluacionRequest.getNotaTres());
        evaluacionProfesor.setNotaCuatro(evaluacionRequest.getNotaCuatro());
        evaluacionProfesor.setNotaCinco(evaluacionRequest.getNotaCinco());

        int idMatricula = evaluacionRequest.getIdMatricula();
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(idMatricula);
        if (optionalMatricula.isPresent()) {
            Matricula matricula = optionalMatricula.get();
            evaluacionProfesor.setIdMatricula(matricula);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        evaluacionProfesor.setFeedback(evaluacionRequest.getFeedback());

        EvaluacionProfesor createdEvaluacion = evaluacionProfesorRepository.save(evaluacionProfesor);

        return ResponseEntity.ok(createdEvaluacion);
    }

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

