
package com.sistema.examenes.repositorios;

import com.sistema.examenes.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    
    public Usuario findByUsername(String username);
    
}
