
package com.sistema.examenes.servicios;

import com.sistema.examenes.modelo.Usuario;
import com.sistema.examenes.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepo;

    //Buscar usuario por username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = this.usuarioRepo.findByUsername(username);
       if(usuario == null){
           throw new UsernameNotFoundException("Usuario no encontrado");
       }
       return usuario;
    }
    
}
