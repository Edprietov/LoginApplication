/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;

/**
 *
 * @author DNIA-B-19
 */
public class ValidarRegistro {
    
        private Sistema sistema = FramePrincipal.sistema;
        
    public ValidarRegistro(){
        
        
    }
    
        public String verificarRegistro(Usuario usuario){
            if(!verificarLongitudNombre(usuario.getNombre())){
            return ("Longitud nombre incorrecta");
       
    }
            if(!verificarLongitudPassword(usuario.getPassword())){
            return ("Longitud contraseña incorrecta");
       
    }
            for(Usuario u: sistema.getUsuarios()){
                if(usuario.getNombre().equals(u.getNombre()))
                {
                    return("Usuario ya Registrado");
                }
            }
            
           if((usuario.getPassword()).equals(usuario.getPasswordv())){
                  return ("Registro exitoso");
                }
           else{
               return ("Las contraseñas no coinciden");
           }
        }
            public boolean ValidarLongitudNombre(String nombre){
             return true;
            }
        
        
      public boolean ValidarLongitudPassword(String password){
        return true;
        
    }
      
          public boolean verificarLongitudNombre(String nombre){
             return (nombre.length() > 1 && nombre.length() <= 6);
            }
          
          public boolean verificarLongitudPassword(String password){
        return (password.length() >= 3 && password.length() < 6);
    
          }   
    
}