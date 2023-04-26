package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.Profesor;
import com.udeaevaluarcursos.repository.ProfesorRepository;
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

class ProfesorServiceImplTest {

    AutoCloseable openMocks;

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private ProfesorServiceImpl profesorService;

    private Profesor profesor;

    @BeforeEach
    void setUp() {
        openMocks = MockitoAnnotations.openMocks(this);
        profesor = new Profesor();
        profesor.setIdProfesor(776332);
        profesor.setCedula(2318923);
    }

    @AfterEach
    void tearDown() throws Exception{
        openMocks.close();
    }

    @Test
    void listProfesors() {
        when(profesorRepository.findAll()).thenReturn(Arrays.asList(profesor));
        assertNotNull(profesorService.listProfesors());
    }

    @Test
    void getProfesorByCedula() {
        when(profesorRepository.findByCedula(profesor.getCedula())).thenReturn(Optional.ofNullable(profesor));
        assertNotNull(profesorService.getProfesorByCedula(profesor.getCedula()));

    }

    @Test
    void createProfesor() {
        when(profesorRepository.save(profesor)).thenReturn(profesor);
        assertNotNull(profesorService.createProfesor(profesor));
    }

    @Test
    void deleteProfesor() {
        when(profesorRepository.findByCedula(profesor.getIdProfesor())).thenReturn(Optional.ofNullable(profesor));
        assertNotNull(profesorService.deleteProfesor(profesor.getIdProfesor()));

    }

    @Test
    void updateProfesor() {
        when(profesorRepository.findById(profesor.getIdProfesor())).thenReturn(Optional.ofNullable(profesor));
        assertNotNull(profesorService.updateProfesor(profesor));


    }
}