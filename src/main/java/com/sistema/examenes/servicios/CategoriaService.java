
package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Categoria;
import java.util.Set;

public interface CategoriaService {
    
    Categoria guardarCategoria(Categoria categoria);
    Categoria actualizarCategoria(Categoria categoria,Long idCategoria);
    Set<Categoria> obtenerCategorias();
    Categoria obtenerCategoria(Long idCategoria);
    void eliminarCategoria(Long idCategoria);
    
}
