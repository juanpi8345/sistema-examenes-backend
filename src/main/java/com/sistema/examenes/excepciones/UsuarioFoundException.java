
package com.sistema.examenes.excepciones;


public class UsuarioFoundException extends Exception{

    public UsuarioFoundException() {
        super("El usuario con ese username ya existe!");
    }
    
      public UsuarioFoundException(String mensaje) {
        super(mensaje);
    }
    
    
}
