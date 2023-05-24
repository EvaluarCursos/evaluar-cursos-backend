package com.udeaevaluarcursos.controllers;

import com.udeaevaluarcursos.models.*;
import com.udeaevaluarcursos.params.request.EvalProfesorRequest;
import com.udeaevaluarcursos.repository.EvaluacionProfesorRepository;
import com.udeaevaluarcursos.repository.MatriculaRepository;
import com.udeaevaluarcursos.service.EvaluacionProfesorServiceImpl;
import com.udeaevaluarcursos.service.MateriaServiceImpl;
import com.udeaevaluarcursos.service.MatriculaServiceImpl;
import com.udeaevaluarcursos.service.ProfesorServiceImpl;
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
    @Autowired
    ProfesorServiceImpl profesorService;
    @Autowired
    MatriculaServiceImpl matriculaService;

    @Autowired
    MateriaServiceImpl materiaService;


    @PostMapping("/form")
    public ResponseEntity<EvaluacionProfesor> createEvaluacion(@RequestBody EvalProfesorRequest evaluacionRequest) {
        try{

            //Busco la matricula con el userId que me pasan
            Matricula matricula = matriculaService.matriculaByEstudiante(evaluacionRequest.getUserId());
            matricula.setCalificado(1);

            //Busco la materia con el id que me pasan
            Materia materia= materiaService.getMateriaById(evaluacionRequest.getId());
            materia.setEvaluated(true);

            //Creo la nueva evaluación profesor
            EvaluacionProfesor evaluacionProfesor = new EvaluacionProfesor();
            //Seteo el profesor correspondiente a ese objeto materia encontrado con el id
            evaluacionProfesor.setIdProfesor(materia.getProfessor());
            evaluacionProfesor.setIdMateria(materia);
            evaluacionProfesor.setNotaUno(evaluacionRequest.getQ1());
            evaluacionProfesor.setNotaDos(evaluacionRequest.getQ2());
            evaluacionProfesor.setNotaTres(evaluacionRequest.getQ3());
            evaluacionProfesor.setNotaCuatro(evaluacionRequest.getQ4());
            evaluacionProfesor.setNotaCinco(evaluacionRequest.getQ5());
            evaluacionProfesor.setNotaSeis(evaluacionRequest.getQ6());
            evaluacionProfesor.setNotaSiete(evaluacionRequest.getQ7());
            evaluacionProfesor.setIdMatricula(matricula);
            evaluacionProfesor.setIdMatricula(matricula);
            evaluacionProfesor.setFeedback(evaluacionRequest.getFeedback());

            EvaluacionProfesor createdEvaluacion = evaluacionProfesorRepository.save(evaluacionProfesor);

            return new ResponseEntity<>( createdEvaluacion,HttpStatus.OK);
        }catch (Exception e){

            System.out.println(e.getMessage());
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
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

