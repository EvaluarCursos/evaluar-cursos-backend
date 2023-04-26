package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.repository.MatriculaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MatriculaServiceImplTest {

    AutoCloseable openMocks;

    @Mock
    private MatriculaRepository matriculaRepository;

    @InjectMocks
    private MatriculaServiceImpl matriculaService;

    private Matricula matricula;


    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);

        matricula = new Matricula();
        Estudiante estudiante = new Estudiante();
        Materia materia = new Materia();
        Profesor profesor = new Profesor();

        //LLenado de datos para testing
        matricula.setIdMatricula(3452);
        matricula.setCalificado(1);
        matricula.setIdEstudiante(estudiante);
        matricula.setIdMateria(materia);
        matricula.setSemestre(6);
        matricula.setIdProfesor(profesor);
    }

    @AfterEach
    void tearDown() throws Exception {

        openMocks.close();


    }

    @Test
    void listMatriculas() {
        //Testing lista de matriculas
        when(matriculaRepository.findAll()).thenReturn(Arrays.asList(matricula));
        assertNotNull(matriculaService.listMatriculas());
    }

    @Test
    void getMatriculaById() {
        //Testing get request de la matricula por id
        when(matriculaRepository.findById(matricula.getIdMatricula())).thenReturn(Optional.ofNullable(matricula));
        assertNotNull(matriculaService.getMatriculaById(matricula.getIdMatricula()));

    }

    @Test
    void createMatricula() {
        assertNotNull(matriculaService.createMatricula(matricula));
    }

    @Test
    void deleteMatricula() {
        when(matriculaRepository.findById(matricula.getIdMatricula())).thenReturn(Optional.ofNullable(matricula));
        assertNotNull(matriculaService.deleteMatricula(matricula.getIdMatricula()));

    }

    @Test
    void updateMatricula() {
        when(matriculaRepository.findById(matricula.getIdMatricula())).thenReturn(Optional.ofNullable(matricula));
        assertNotNull(matriculaService.updateMatricula(matricula));
    }
}