package com.sistema.examenes;

import com.sistema.examenes.excepciones.UsuarioFoundException;
import com.sistema.examenes.modelo.Rol;
import com.sistema.examenes.modelo.Usuario;
import com.sistema.examenes.modelo.UsuarioRol;
import com.sistema.examenes.servicios.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {
    
    @Autowired
    private UsuarioService usuarioService;
    
  
    public static void main(String[] args) {
        SpringApplication.run(SistemaExamenesBackendApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        /*try{
        Usuario usuario = new Usuario();
        
        usuario.setNombre("Juan");
        usuario.setApellido("Pregliasco");
        usuario.setUsername("Juanpi");
        usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
        usuario.setEmail("juanpipre@outlook.com");
        usuario.setTelefono("1132312016");
        usuario.setPerfil("foto.png");

        Rol rol = new Rol();
        rol.setRolId(1L);
        rol.setNombre("ADMIN");

        Set<UsuarioRol> usuarioRoles = new HashSet<>();
        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setRol(rol);
        usuarioRol.setUsuario(usuario);
        usuarioRoles.add(usuarioRol);

        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
        System.out.println(usuarioGuardado.getUsername());
          }catch(UsuarioFoundException exception){
              exception.printStackTrace();
          }*/
    }

}
