package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.EvaluacionMateria;
import com.udeaevaluarcursos.models.Matricula;
import com.udeaevaluarcursos.repository.EvaluacionMateriaRepository;
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

class EvaluacionMateriaServiceImplTest {

    AutoCloseable openMocks;
    @Mock
    private EvaluacionMateriaRepository evaluacionMateriaRepository;

    @InjectMocks
    private EvaluacionMateriaServiceImpl evaluacionMateriaService;

    private EvaluacionMateria evaluacionMateria;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);

        evaluacionMateria = new EvaluacionMateria();
        Matricula matricula = new Matricula();

        evaluacionMateria.setIdEvaluacionMateria(1234);
        evaluacionMateria.setFeedback("Mejorar el metodo de evaluacion");
        evaluacionMateria.setIdMatricula(matricula);
        evaluacionMateria.setNotaUno(3);
        evaluacionMateria.setNotaDos(4);
        evaluacionMateria.setNotaTres(4);
        evaluacionMateria.setNotaCuatro(5);
        evaluacionMateria.setNotaCinco(3);
    }

    @Test
    void listEvaluacionesMaterias() {
        when(evaluacionMateriaRepository.findAll()).thenReturn(Arrays.asList(evaluacionMateria));
        assertNotNull(evaluacionMateriaService.listEvaluacionesMaterias());
    }

    @Test
    void getEvaluacionMateriaById() {
        when(evaluacionMateriaRepository.findById(evaluacionMateria.getIdEvaluacionMateria())).thenReturn(Optional.ofNullable(evaluacionMateria));
        assertNotNull(evaluacionMateriaService.getEvaluacionMateriaById(evaluacionMateria.getIdEvaluacionMateria()));

    }

    @Test
    void createEvaluacionMateria() {
        assertNotNull(evaluacionMateriaService.createEvaluacionMateria(evaluacionMateria));

    }


    @Test
    void deleteEvaluacionMateria() {
        when(evaluacionMateriaRepository.findById(evaluacionMateria.getIdEvaluacionMateria())).thenReturn(Optional.ofNullable(evaluacionMateria));
        assertNotNull(evaluacionMateriaService.deleteEvaluacionMateria(evaluacionMateria.getIdEvaluacionMateria()));

    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();

    }
}