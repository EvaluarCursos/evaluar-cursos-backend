package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.repository.MateriaRepository;
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

class MateriaServiceImplTest {

    @Mock
    private MateriaRepository materiaRepository;

    @InjectMocks
    private MateriaServiceImpl materiaService;

    private Materia materia;

    AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        materia = new Materia();
        materia.setIdMateria(12345);

    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Test
    void listMaterias() {
        when(materiaRepository.findAll()).thenReturn(Arrays.asList(materia));
        assertNotNull(materiaService.listMaterias());
    }

    @Test
    void getMateriaById() {
        when(materiaRepository.findById(materia.getIdMateria())).thenReturn(Optional.ofNullable(materia));
        assertNotNull(materiaService.getMateriaById(materia.getIdMateria()));

    }

    @Test
    void createMateria() {
        assertNotNull(materiaService.createMateria(materia));

    }

    @Test
    void deleteMateria() {
        when(materiaRepository.findById(materia.getIdMateria())).thenReturn(Optional.ofNullable(materia));
        assertNotNull(materiaService.deleteMateria(materia.getIdMateria()));

    }

    @Test
    void updateMateria() {
        when(materiaRepository.findById(materia.getIdMateria())).thenReturn(Optional.ofNullable(materia));
        assertNotNull(materiaService.updateMateria(materia));
    }
}