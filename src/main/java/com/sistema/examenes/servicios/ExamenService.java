
package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Examen;
import java.util.Set;

public interface ExamenService {
    
    Examen agregarExamen(Examen examen);
    Examen actualizarExamen(Examen examen, Long examenId);
    Set<Examen> obtenerExamenes();
    Examen obtenerExamen(Long examenId);
    void eliminarExamen(Long examenId);
    
}
