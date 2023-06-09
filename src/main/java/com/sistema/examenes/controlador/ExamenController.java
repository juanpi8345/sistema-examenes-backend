package com.sistema.examenes.controlador;
import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.modelo.Examen;
import com.sistema.examenes.servicios.ExamenService;
import java.util.List;
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
    
    @GetMapping("/categoria/{categoriaId}")
    public List<Examen> listarExamenesDeUnaCategoria(@PathVariable Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setCategoriaId(categoriaId);
        return examenService.listarExamenesDeUnaCategoria(categoria);
    }
    
    @GetMapping("/activo")
    public List<Examen> listarExamenesActivos(){
        return examenService.obtenerExamenesActivos();
    }
    
   @GetMapping("/categoria/activo/{categoriaId}")
    public List<Examen> listarExamenesActivosDeUnaCategoria(@PathVariable Long categoriaId){
       Categoria categoria = new Categoria();
       categoria.setCategoriaId(categoriaId);
       return examenService.obtenerExamenesActivosDeUnaCategoria(categoria);
    }
    
    @PostMapping("/")
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen){
        return ResponseEntity.ok(examenService.agregarExamen(examen));
    }
    
    @PutMapping("/")
    public Examen actualizarExamen(@RequestBody Examen examen){
          return examenService.actualizarExamen(examen);
    }
    
    @DeleteMapping("/{examenId}")
    public void eliminarExamen(@PathVariable Long examenId){
        examenService.eliminarExamen(examenId);
    }
    
    
    
}
