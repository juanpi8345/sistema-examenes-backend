package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.modelo.Pregunta;
import com.sistema.examenes.repositorios.PreguntaRepositorio;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImp implements PreguntaService {

    @Autowired
    private PreguntaRepositorio preguntaRepositorio;

    @Override
    public Pregunta agregarPregunta(Pregunta pregunta) {
       return preguntaRepositorio.save(pregunta);
    }

    @Override
    public Pregunta actualizarPregunta(Pregunta preguntaRequest) {
        return preguntaRepositorio.findById(preguntaRequest.getPreguntaId()).map(pregunta->{
            pregunta.setContenido(preguntaRequest.getContenido());
            pregunta.setExamen(preguntaRequest.getExamen());
            pregunta.setImg(preguntaRequest.getImg());
            pregunta.setOpcion1(preguntaRequest.getOpcion1());
            pregunta.setOpcion2(preguntaRequest.getOpcion2());
            pregunta.setOpcion3(preguntaRequest.getOpcion3());
            pregunta.setOpcion4(preguntaRequest.getOpcion4());
            pregunta.setRespuesta(preguntaRequest.getRespuesta());
            return preguntaRepositorio.save(pregunta);
        }).orElse(null);
    }

    @Override
    public Set<Pregunta> obtenerPreguntas() {
        return (Set<Pregunta>) preguntaRepositorio.findAll();
    }

    @Override
    public Pregunta obtenerPregunta(Long preguntaId) {
        return preguntaRepositorio.findById(preguntaId).orElse(null);
    }

    @Override
    public Set<Pregunta> obtenerPreguntasDelExamen(Examen examen) {
        return preguntaRepositorio.findByExamen(examen);
    }

    @Override
    public void eliminarPregunta(Long preguntaId) {
         preguntaRepositorio.deleteById(preguntaId);
    }

    @Override
    public Pregunta listarPregunta(Long preguntaId) {
        return this.preguntaRepositorio.findById(preguntaId).orElse(null);
    }

}
