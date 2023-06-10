/*
 *  Universidad Politécnica De San Luis Potosí
 *  Programación III Java
 *  Programación Orientada a Objetos
 */
package mensajeria;
import java.sql.Connection;
import menuu.*;

/**
 * Clase principal de la cual se llama al login para iniciar el programa
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Mensajeria {

    /**
     * Constructor nulo
     */
    public Mensajeria() {
    }
    
    
    /**
     * Metodo Principal del proyecto
     * @param args argumentos
     */
    public static void main(String[] args) {
        Conexion obj = new Conexion();
        Connection con = obj.Conexion();
        new Login(con).setVisible(true);
    }
    
}
