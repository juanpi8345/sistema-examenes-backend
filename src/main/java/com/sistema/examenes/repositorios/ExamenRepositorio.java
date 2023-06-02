
package com.sistema.examenes.repositorios;

import com.sistema.examenes.modelo.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamenRepositorio extends JpaRepository<Examen, Long> {
    
}
