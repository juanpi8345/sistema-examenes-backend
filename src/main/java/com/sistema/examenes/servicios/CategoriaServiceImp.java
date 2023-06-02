package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.repositorios.CategoriaRepositorio;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoriaRequest, Long idCategoria) {
         return categoriaRepositorio.findById(idCategoria).map(categoria->{
             categoria.setDescripcion(categoriaRequest.getDescripcion());
             categoria.setTitulo(categoriaRequest.getTitulo());
             categoria.setExamenes(categoriaRequest.getExamenes());
             return categoriaRepositorio.save(categoria);
        }).orElse(null);
    }

    @Override
    public Set<Categoria> obtenerCategorias() {
        return new LinkedHashSet<>(categoriaRepositorio.findAll());

    }

    @Override
    public Categoria obtenerCategoria(Long idCategoria) {
        return categoriaRepositorio.findById(idCategoria).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long idCategoria) {
        categoriaRepositorio.deleteById(idCategoria);
    }

}
