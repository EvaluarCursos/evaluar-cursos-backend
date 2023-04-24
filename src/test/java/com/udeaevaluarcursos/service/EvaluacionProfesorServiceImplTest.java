package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionProfesor;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.repository.EvaluacionProfesorRepository;
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

class EvaluacionProfesorServiceImplTest {

    AutoCloseable openMocks;

    @Mock
    private EvaluacionProfesorRepository evaluacionProfesorRepository;

    @InjectMocks
    private EvaluacionProfesorServiceImpl evaluacionProfesorService;

    private EvaluacionProfesor evaluacionProfesor;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        evaluacionProfesor = new EvaluacionProfesor();
        Matricula matricula = new Matricula();

        evaluacionProfesor.setIdEvaluacionProfesor(2424);
        evaluacionProfesor.setFeedback("Mejorar el metodo de evaluacion");
        evaluacionProfesor.setIdMatricula(matricula);
        evaluacionProfesor.setNotaUno(1);
        evaluacionProfesor.setNotaDos(2);
        evaluacionProfesor.setNotaTres(2);
        evaluacionProfesor.setNotaCuatro(5);
        evaluacionProfesor.setNotaCinco(5);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void listEvaluacionesProfesores() {
        when(evaluacionProfesorRepository.findAll()).thenReturn(Arrays.asList(evaluacionProfesor));
        assertNotNull(evaluacionProfesorService.listEvaluacionesProfesores());
    }

    @Test
    void getEvaluacionProfesorById() {
        when(evaluacionProfesorRepository.findById(evaluacionProfesor.getIdEvaluacionProfesor())).thenReturn(Optional.ofNullable(evaluacionProfesor));
        assertNotNull(evaluacionProfesorService.getEvaluacionProfesorById(evaluacionProfesor.getIdEvaluacionProfesor()));
    }

    @Test
    void createEvaluacionProfesor() {
        assertNotNull(evaluacionProfesorService.createEvaluacionProfesor(evaluacionProfesor));
    }

    @Test
    void deleteEvaluacionProfesor() {
        when(evaluacionProfesorRepository.findById(evaluacionProfesor.getIdEvaluacionProfesor())).thenReturn(Optional.ofNullable(evaluacionProfesor));
        assertNotNull(evaluacionProfesorService.deleteEvaluacionProfesor(evaluacionProfesor.getIdEvaluacionProfesor()));
    }
}