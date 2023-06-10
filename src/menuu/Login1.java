/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 */
package menuu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Clase que verifica la existencia de los usuarios de tipo administrador que existen, para que estos puedan entrar o no
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Login1 {
    
    ArrayList<String> administradores = new ArrayList<String>(Arrays.asList("Admin1", "Admin2", "Admin3", "Admin4", "Admin5"));

    /**
     * Crea una instancia de la clase Login1
     */
    public Login1() {
    }
    
    /**
     * Revisa si el registro del administrador está
     * @param usuario información ingresada por el usuario
     * @param password información ingresada por el usuario
     * @return boolean cierto o falso
     */
    public boolean log(String usuario, String password){
        if(administradores.contains(usuario) && administradores.contains(password)){
            return true;
        }else{
            return false;
        }
    }
    
}
