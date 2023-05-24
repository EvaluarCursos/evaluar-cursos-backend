package com.udeaevaluarcursos.controllers;
import java.util.Optional;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.EvaluationResponse;
import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.params.request.EvalMateriaRequest;
import com.udeaevaluarcursos.repository.EvaluacionMateriaRepository;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.repository.MatriculaRepository;
import com.udeaevaluarcursos.service.EvaluacionMateriaServiceImpl;

import com.udeaevaluarcursos.service.MateriaServiceImpl;
import com.udeaevaluarcursos.service.MatriculaServiceImpl;
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

    @Autowired
    MatriculaServiceImpl matriculaService;
    @Autowired
    MateriaServiceImpl materiaService;


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
        try{
            //Busco la materia con el id que me pasan
            Materia materia= materiaService.getMateriaById(evaluacionRequest.getId());
            materia.setEvaluated(true);

            //Busco la matricula con el userId que me pasan
            Matricula matricula = matriculaService.matriculaByEstudiante(evaluacionRequest.getUserId());
            matricula.setCalificado(1);

            //Creo la nueva evaluación materia
            EvaluacionMateria evaluacionMateria = new EvaluacionMateria();
            //Seteo el profesor correspondiente a ese objeto materia encontrado con el id
            evaluacionMateria.setIdProfesor(materia.getProfessor());
            evaluacionMateria.setNotaUno(evaluacionRequest.getQ1());
            evaluacionMateria.setNotaDos(evaluacionRequest.getQ2());
            evaluacionMateria.setNotaTres(evaluacionRequest.getQ3());
            evaluacionMateria.setIdMateria(materia);
            evaluacionMateria.setIdMatricula(matricula);
            evaluacionMateria.setIdMatricula(matricula);
            evaluacionMateria.setFeedback(evaluacionRequest.getFeedback());

            EvaluacionMateria createdEvaluacion = evaluacionMateriaRepository.save(evaluacionMateria);

            return new ResponseEntity<>( createdEvaluacion,HttpStatus.OK);
        }catch (Exception e){

            System.out.println(e.getMessage());
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

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