package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.repository.EstudianteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EstudianteServiceImplTest {

    @Mock
    private EstudianteRepository estudianteRepository;
    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    private Estudiante estudiante;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        estudiante = new Estudiante();

        estudiante.setIdEstudiante(1001);
        estudiante.setCedula(1231231233);

    }

    @Test
    void listEstudiantes() {
        when(estudianteRepository.findAll()).thenReturn(Arrays.asList(estudiante));
        assertNotNull(estudianteService.listEstudiantes());
    }

    @Test
    void getEstudianteByCedula() {

    }
}