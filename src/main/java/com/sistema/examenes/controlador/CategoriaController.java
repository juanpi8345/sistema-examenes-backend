
package com.sistema.examenes.controlador;

import com.sistema.examenes.modelo.Categoria;
import com.sistema.examenes.servicios.CategoriaService;
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
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @PostMapping("/")
    public ResponseEntity<Categoria> guardarCategoria(@RequestBody Categoria categoria){
        Categoria categoriaGuardada = categoriaService.guardarCategoria(categoria);
        return ResponseEntity.ok(categoriaGuardada);
    }
    
    @GetMapping("/{categoriaId}")
    public Categoria listarCategoriaPorId(@PathVariable Long categoriaId){
        return categoriaService.obtenerCategoria(categoriaId);
    }
    
    @GetMapping("/")
    public ResponseEntity<?> listarCategorias(){
        return ResponseEntity.ok(categoriaService.obtenerCategorias());
    }
    
    @PutMapping("/{categoriaId}")
    public Categoria actualizarCategoria(@RequestBody Categoria categoria,@PathVariable Long categoriaId){
          return categoriaService.actualizarCategoria(categoria, categoriaId);
               
        
    }
    
    @DeleteMapping("/{categoriaId}")
    public void eliminarCategoria(@PathVariable Long categoriaId){
        categoriaService.eliminarCategoria(categoriaId);
    }
    
            
    
}
