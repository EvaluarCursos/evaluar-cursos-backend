package com.udeaevaluarcursos.service;

import com.udeaevaluarcursos.models.*;
import com.udeaevaluarcursos.params.response.EvaluationResponse;
import com.udeaevaluarcursos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EvaluacionMateriaServiceImpl implements EvaluacionMateriaService{

    @Autowired
    EvaluacionMateriaRepository evaluacionMateriaRepository;

    @Autowired
    MateriaRepository materiaRepository;

    @Autowired
    EvaluacionProfesorRepository evaluacionProfesorRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public List<EvaluacionMateria> listEvaluacionesMaterias() {
        List<EvaluacionMateria> listadoEvaluacionesMaterias = evaluacionMateriaRepository.findAll();

        return listadoEvaluacionesMaterias;
    }

    @Override
    public EvaluacionMateria getEvaluacionMateriaById(int id) {
        Optional<EvaluacionMateria> evaluacionMateria= evaluacionMateriaRepository.findById(id);
        if (!evaluacionMateria.isPresent()) {
            return null;
        }

        return evaluacionMateria.get();
    }

    @Override
    public EvaluacionMateria createEvaluacionMateria(EvaluacionMateria evaluacionMateria) {
        Optional<EvaluacionMateria> evaluacionMateriaPorId= evaluacionMateriaRepository.findById(evaluacionMateria.getIdEvaluacionMateria());

        if(evaluacionMateriaPorId.isPresent()) {
            return null;
        }

        evaluacionMateriaRepository.save(evaluacionMateria);

        return evaluacionMateria;
    }

    @Override
    public EvaluacionMateria deleteEvaluacionMateria(int id) {
        Optional<EvaluacionMateria> evaluacionMateria= evaluacionMateriaRepository.findById(id);
        if (!evaluacionMateria.isPresent()) {
            return null;
        }
        evaluacionMateriaRepository.delete(evaluacionMateria.get());

        return evaluacionMateria.get();
    }

    @Override
    public EvaluationResponse getInformeByIdMateria(int idProfesor, int idMateria) {
        //Optional<Materia> materiaFiltrar=materiaRepository.findById(idMateria);
        //Optional<Profesor> profesorFiltrar=profesorRepository.findById(idProfesor);


            //EvaluacionMateria[] evaluacionesMateriasPorFiltros=evaluacionMateriaRepository.findByFilters(profesorFiltrar.get(),materiaFiltrar.get());
            //EvaluacionProfesor[] evaluacionesProfesorPorFiltros=evaluacionProfesorRepository.findByFilters(profesorFiltrar.get(),materiaFiltrar.get());

        EvaluacionMateria[] evaluacionesMateriasPorFiltros=evaluacionMateriaRepository.findByCode(idProfesor,idMateria);
        EvaluacionProfesor[] evaluacionesProfesorPorFiltros=evaluacionProfesorRepository.findByCode(idProfesor,idMateria);

            PreguntasEvaluaciones preguntasEvaluaciones=new PreguntasEvaluaciones();


            for (int i=0;i<evaluacionesMateriasPorFiltros.length;i++){
                EvaluacionMateria evaluacionMateria=evaluacionesMateriasPorFiltros[i];
                preguntasEvaluaciones.getQ1().addNota(evaluacionMateria.getNotaUno());
                preguntasEvaluaciones.getQ2().addNota(evaluacionMateria.getNotaDos());
                preguntasEvaluaciones.getQ3().addNota(evaluacionMateria.getNotaTres());
                preguntasEvaluaciones.getQ1().setAswers(evaluacionesMateriasPorFiltros.length);
                preguntasEvaluaciones.getQ2().setAswers(evaluacionesMateriasPorFiltros.length);
                preguntasEvaluaciones.getQ3().setAswers(evaluacionesMateriasPorFiltros.length);

            }


            for (int i=0;i<evaluacionesProfesorPorFiltros.length;i++){
                EvaluacionProfesor evaluacionProfesor=evaluacionesProfesorPorFiltros[i];
                preguntasEvaluaciones.getQ4().addNota(evaluacionProfesor.getNotaUno());
                preguntasEvaluaciones.getQ5().addNota(evaluacionProfesor.getNotaDos());
                preguntasEvaluaciones.getQ6().addNota(evaluacionProfesor.getNotaTres());
                preguntasEvaluaciones.getQ7().addNota(evaluacionProfesor.getNotaCuatro());
                preguntasEvaluaciones.getQ8().addNota(evaluacionProfesor.getNotaCinco());
                preguntasEvaluaciones.getQ9().addNota(evaluacionProfesor.getNotaSeis());
                preguntasEvaluaciones.getQ10().addNota(evaluacionProfesor.getNotaSiete());


                preguntasEvaluaciones.getQ4().setAswers(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ5().setAswers(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ6().setAswers(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ7().setAswers(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ8().setAswers(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ9().setAswers(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ10().setAswers(evaluacionesProfesorPorFiltros.length);


            }


            if(evaluacionesMateriasPorFiltros.length >0){
                preguntasEvaluaciones.getQ1().estadisticas(evaluacionesMateriasPorFiltros.length);
                preguntasEvaluaciones.getQ2().estadisticas(evaluacionesMateriasPorFiltros.length);
                preguntasEvaluaciones.getQ3().estadisticas(evaluacionesMateriasPorFiltros.length);

            }

            if(evaluacionesProfesorPorFiltros.length > 0){
                preguntasEvaluaciones.getQ4().estadisticas(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ5().estadisticas(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ6().estadisticas(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ7().estadisticas(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ8().estadisticas(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ9().estadisticas(evaluacionesProfesorPorFiltros.length);
                preguntasEvaluaciones.getQ10().estadisticas(evaluacionesProfesorPorFiltros.length);
            }

            EvaluationResponse evaluationResponse = new EvaluationResponse();
            evaluationResponse.headers.put("professor", evaluacionesProfesorPorFiltros[0].getIdProfesor().getNombre());
            evaluationResponse.headers.put("subject", evaluacionesMateriasPorFiltros[0].getIdMateria().getNombreMateria());
            evaluationResponse.seccion1.put("q1", preguntasEvaluaciones.getQ1());
            evaluationResponse.seccion2.put("q2", preguntasEvaluaciones.getQ2());
            evaluationResponse.seccion3.put("q3", preguntasEvaluaciones.getQ3());
            evaluationResponse.seccion4.put("q4", preguntasEvaluaciones.getQ4());
            evaluationResponse.seccion4.put("q5", preguntasEvaluaciones.getQ5());
            evaluationResponse.seccion5.put("q6", preguntasEvaluaciones.getQ6());
            evaluationResponse.seccion5.put("q7", preguntasEvaluaciones.getQ7());
            evaluationResponse.seccion6.put("q8", preguntasEvaluaciones.getQ8());
            evaluationResponse.seccion6.put("q9", preguntasEvaluaciones.getQ9());
            evaluationResponse.seccion6.put("q10", preguntasEvaluaciones.getQ10());



            return evaluationResponse;







    }

    @Override
    public EvaluacionMateria[] testInformeByIds(int idProfesor, int idMateria) {
        return evaluacionMateriaRepository.findByCode(idProfesor,idMateria);
    }


}
