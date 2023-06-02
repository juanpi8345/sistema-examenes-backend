
package com.sistema.examenes.repositorios;

import com.sistema.examenes.modelo.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio  extends JpaRepository<Rol, Long>{
    
}
