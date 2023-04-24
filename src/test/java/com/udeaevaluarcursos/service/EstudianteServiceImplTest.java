package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.repository.EstudianteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

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
    void createEstudiante() {
        assertNotNull(estudianteService.createEstudiante(estudiante));
    }

    @Test
    void getEstudianteByCedula() {
        when(estudianteRepository.findByCedula(estudiante.getCedula())).thenReturn(Optional.ofNullable(estudiante));
        assertNotNull(estudianteService.getEstudianteByCedula(estudiante.getCedula()));

    }

    @Test
    void deleteEstudiante() {
        when(estudianteRepository.findByCedula(estudiante.getCedula())).thenReturn(Optional.ofNullable(estudiante));
        assertNotNull(estudianteService.deleteEstudiante(estudiante.getCedula()));

    }

    @Test
    void updateEstudiante() {
        when(estudianteRepository.findById(estudiante.getIdEstudiante())).thenReturn(Optional.ofNullable(estudiante));
        assertNotNull(estudianteService.updateEstudiante(estudiante));

    }
}