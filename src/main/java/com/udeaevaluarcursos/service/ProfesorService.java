package com.udeaevaluarcursos.service;
import com.udeaevaluarcursos.models.Estudiante;
import com.udeaevaluarcursos.models.Materia;
import com.udeaevaluarcursos.models.Profesor;
import java.util.List;

public interface ProfesorService {
    public List<Profesor> listProfesors();

    public Profesor getProfesorByEmail(String email);
    public Profesor getProfesorByCedula(int cedula);
    public Profesor createProfesor(Profesor profesor);
    public Profesor getProfesorById(int id);
    public Profesor deleteProfesor(int cedula);

    public Profesor updateProfesor(Profesor profesor);

    public int getCedulaByUserId(int idUsuario);
}
