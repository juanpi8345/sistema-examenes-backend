
package com.sistema.examenes.controlador;

import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.modelo.Pregunta;
import com.sistema.examenes.servicios.ExamenService;
import com.sistema.examenes.servicios.PreguntaService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pregunta")
@CrossOrigin("*")
public class PreguntaController {
    
    @Autowired
    private PreguntaService preguntaService;
    
    @Autowired
    private ExamenService examenService;
    
    @GetMapping("/examen/{examenId}")
    public ResponseEntity<?> listarPreguntas(@PathVariable Long examenId){
        
        Examen examen = examenService.obtenerExamen(examenId);
        Set<Pregunta> preguntas = examen.getPreguntas(); // Obtener preguntas del examen
        
        List examenes = new ArrayList(preguntas); //Castear el conjunto a una lista
        if(examenes.size() > Integer.parseInt(examen.getNumeroDePreguntas())){ // Si hay mas preguntas que el max
            examenes = examenes.subList(0,  Integer.parseInt(examen.getNumeroDePreguntas())); 
        }
        
        Collections.shuffle(examenes); 
        return ResponseEntity.ok(examenes);
    
    }
    
    @GetMapping("/{preguntaId}")
    public Pregunta listarPregunta(@PathVariable Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }
    
    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }
    
    @PutMapping("/{preguntaId}")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta, @PathVariable Long preguntaId){
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta,preguntaId));
    }
    
    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
    }
    
    
}
