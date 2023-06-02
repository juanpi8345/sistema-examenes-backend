package com.sistema.examenes.controlador;
import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.servicios.ExamenService;
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
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {
    
    @Autowired
    private ExamenService examenService;
    
    @GetMapping("/{examenId}")
    public Examen listarExamen(@PathVariable Long examenId){
        return examenService.obtenerExamen(examenId);
    }
    
    @GetMapping("/")
    public ResponseEntity<?> listarExamenes(){
        return ResponseEntity.ok(examenService.obtenerExamenes());
    }
    
    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }
    
    @PutMapping("/{examenId}")
    public Examen actualizarExamen(@RequestBody Examen examen,@PathVariable Long categoriaId){
          return examenService.actualizarExamen(examen, categoriaId);
    }
    
    @DeleteMapping("/{examenId}")
    public void eliminarExamen(@PathVariable Long examenId){
        examenService.eliminarExamen(examenId);
    }
    
    
    
}
