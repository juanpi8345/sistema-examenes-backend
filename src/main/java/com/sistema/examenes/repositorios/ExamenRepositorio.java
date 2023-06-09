
package com.sistema.examenes.repositorios;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.modelo.Examen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepositorio extends JpaRepository<Examen, Long> {
    
    List<Examen> findByCategoria(Categoria categoria);
    
    List<Examen> findByActivo(Boolean estado);
    
    List<Examen> findByCategoriaAndActivo(Categoria categoria, Boolean estado);
    
}
