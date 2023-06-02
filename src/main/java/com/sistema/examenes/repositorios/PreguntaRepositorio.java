
package com.sistema.examenes.repositorios;

import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.modelo.Pregunta;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepositorio extends JpaRepository<Pregunta, Long> {
    
    Set<Pregunta> findByExamen(Examen examen);
    
}
