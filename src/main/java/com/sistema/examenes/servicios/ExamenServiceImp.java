package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.repositorios.ExamenRepositorio;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenServiceImp implements ExamenService {

    @Autowired
    private ExamenRepositorio examenRepositorio;

    @Override
    public Examen agregarExamen(Examen examen) {
        return examenRepositorio.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examenRequest) {
        return examenRepositorio.findById(examenRequest.getExamenId()).map(examen -> {
            examen.setTitulo(examenRequest.getTitulo());
            examen.setPuntosMaximos(examenRequest.getPuntosMaximos());
            examen.setPreguntas(examenRequest.getPreguntas());
            examen.setNumeroDePreguntas(examenRequest.getNumeroDePreguntas());
            examen.setDescripcion(examenRequest.getDescripcion());
            examen.setCategoria(examenRequest.getCategoria());
            examen.setActivo(examenRequest.isActivo());
            return examenRepositorio.save(examen);
        }).orElse(null);
    }

    @Override
    public Set<Examen> obtenerExamenes() {
        return new LinkedHashSet<>(examenRepositorio.findAll());
    }

    @Override
    public Examen obtenerExamen(Long examenId) {
        return examenRepositorio.findById(examenId).orElse(null);
    }

    @Override
    public void eliminarExamen(Long examenId) {
        examenRepositorio.deleteById(examenId);
    }

    @Override
    public List<Examen> listarExamenesDeUnaCategoria(Categoria categoria) {
          return examenRepositorio.findByCategoria(categoria);
    }

    @Override
    public List<Examen> obtenerExamenesActivos() {
        return examenRepositorio.findByActivo(true);
    }
    
    @Override
    public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
        return examenRepositorio.findByCategoriaAndActivo(categoria, true);
    }



}
