
package com.sistema.examenes.controlador;

import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.modelo.Pregunta;
import com.sistema.examenes.servicios.ExamenService;
import com.sistema.examenes.servicios.PreguntaService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    @GetMapping("/examen/todos/{examenId}")
     public ResponseEntity<?> listarPreguntasComoAdministrador(@PathVariable Long examenId){
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        Set<Pregunta> preguntas = preguntaService.obtenerPreguntasDelExamen(examen);
        return ResponseEntity.ok(preguntas);
     }
    
    @GetMapping("/{preguntaId}")
    public Pregunta listarPregunta(@PathVariable Long preguntaId){
        return preguntaService.obtenerPregunta(preguntaId);
    }
    
    @PostMapping("/")
    public ResponseEntity<Pregunta> guardarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.agregarPregunta(pregunta));
    }
    
    @PostMapping("/evaluar-examen")
    public ResponseEntity<?> evaluarExamen(@RequestBody List<Pregunta> preguntas){
        double puntosMaximos = 0;
        Integer respuestasCorrectas = 0;
        Integer intentos = 0;
        
        for(Pregunta p : preguntas){
            Pregunta pregunta = this.preguntaService.listarPregunta(p.getPreguntaId());
            if(pregunta.getRespuesta().equals(p.getRespuestaDada())){
                double puntos = Double.parseDouble(preguntas.get(0).getExamen().getPuntosMaximos()) / preguntas.size();
                puntosMaximos += puntos;
                respuestasCorrectas++;
                intentos++;
            }
            if(p.getRespuestaDada() != null){
                intentos++;
            }
        }
        
        Map<String,Object> respuestas = new HashMap<>();
        respuestas.put("puntosMaximos",puntosMaximos);
        respuestas.put("respuestasCorrectas",respuestasCorrectas);
        respuestas.put("intentos",intentos);
        return ResponseEntity.ok(respuestas);
    
    }
    
    @PutMapping("/")
    public ResponseEntity<Pregunta> actualizarPregunta(@RequestBody Pregunta pregunta){
        return ResponseEntity.ok(preguntaService.actualizarPregunta(pregunta));
    }
    
    @DeleteMapping("/{preguntaId}")
    public void eliminarPregunta(@PathVariable Long preguntaId){
        preguntaService.eliminarPregunta(preguntaId);
    }
    
    
}
