package com.udeaevaluarcursos.controllers;
import java.util.Optional;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.EvaluationResponse;
import com.udeaevaluarcursos.params.request.EvalMateriaRequest;
import com.udeaevaluarcursos.repository.EvaluacionMateriaRepository;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.repository.MatriculaRepository;
import com.udeaevaluarcursos.service.EvaluacionMateriaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluacion-materia")
public class EvaluacionMateriaController {
    @Autowired
    EvaluacionMateriaServiceImpl evaluacionMateriaServiceImpl;
    @Autowired
    MatriculaRepository matriculaRepository;
    @Autowired
    EvaluacionMateriaRepository evaluacionMateriaRepository;

    @PostMapping("/create-evaluacion-materia")
    public ResponseEntity<EvaluacionMateria> createEvaluacionMateria(@RequestBody EvaluacionMateria evaluacionMateria) {

        EvaluacionMateria evaluacionMateriaCreada = evaluacionMateriaServiceImpl.createEvaluacionMateria(evaluacionMateria);

        if (evaluacionMateriaCreada != null) {
            return new ResponseEntity<>(evaluacionMateriaCreada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(evaluacionMateriaCreada, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/form")
    public ResponseEntity<EvaluacionMateria> createEvaluacion(@RequestBody EvalMateriaRequest evaluacionRequest) {
        EvaluacionMateria evaluacionMateria = new EvaluacionMateria();
        evaluacionMateria.setNotaUno(evaluacionRequest.getQ1());
        evaluacionMateria.setNotaDos(evaluacionRequest.getQ2());
        evaluacionMateria.setNotaTres(evaluacionRequest.getQ3());

        int idMatricula = evaluacionRequest.getId();
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(idMatricula);
                //.orElseThrow(() -> new ResourceNotFoundException("Matricula not found with id " + evaluacionRequest.getIdMatricula()));
        if (optionalMatricula.isPresent()) {
            Matricula matricula = optionalMatricula.get();
            matricula.setCalificado(1);
            evaluacionMateria.setIdMatricula(matricula);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        evaluacionMateria.setFeedback(evaluacionRequest.getFeedback());

        EvaluacionMateria createdEvaluacion = evaluacionMateriaRepository.save(evaluacionMateria);

        return ResponseEntity.ok(createdEvaluacion);
    }

    @GetMapping("/list-evaluaciones-materias")
    public ResponseEntity<List<EvaluacionMateria>> listMaterias() {
        return new ResponseEntity<>(evaluacionMateriaServiceImpl.listEvaluacionesMaterias(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionMateria> getEvaluacionMateriaById(@PathVariable("id") int id) {

        EvaluacionMateria evaluacionMateria = evaluacionMateriaServiceImpl.getEvaluacionMateriaById(id);

        if (evaluacionMateria != null) {
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-evaluacion-materia/{id}")
    public ResponseEntity<EvaluacionMateria> deleteEvaluacionMateria(@PathVariable("id") int id) {
        EvaluacionMateria evaluacionMateria = evaluacionMateriaServiceImpl.deleteEvaluacionMateria(id);

        if (evaluacionMateria != null) {
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(evaluacionMateria, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/informe-materia/{idProfesor}/{idMateria}")
    public ResponseEntity< EvaluationResponse> getInformeByIdMateria(@PathVariable("idProfesor") int idProfesor , @PathVariable("idMateria") int idMateria){

        EvaluationResponse evaluacionMateria=evaluacionMateriaServiceImpl.getInformeByIdMateria(idProfesor,idMateria);


        return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);


    }

    @GetMapping("/informe-materia/test/{idProfesor}/{idMateria}")
    public ResponseEntity< EvaluacionMateria[]> getTestInformesByIds(@PathVariable("idProfesor") int idProfesor , @PathVariable("idMateria") int idMateria){

        EvaluacionMateria[] evaluacionMateria=evaluacionMateriaServiceImpl.testInformeByIds(idProfesor,idMateria);


        return new ResponseEntity<>(evaluacionMateria, HttpStatus.OK);


    }
}