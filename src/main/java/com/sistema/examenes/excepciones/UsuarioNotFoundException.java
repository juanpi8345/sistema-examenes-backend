
package com.sistema.examenes.excepciones;


public class UsuarioNotFoundException extends Exception{
    
     public UsuarioNotFoundException() {
        super("El usuario con ese username no existe!");
    }
    
      public UsuarioNotFoundException(String mensaje) {
        super(mensaje);
    }
    
    
}
