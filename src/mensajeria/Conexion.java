/*
 *  Universidad Politécnica De San Luis Potosí
 *  Programación III Java
 *  Programación Orientada a Objetos
 */

package mensajeria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase conexion para realizar la conexión a la base de datos.
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Conexion {
    /**
     * Representa la conexión
     */
    Connection con;

    /**
     * Constructor 
     */
    public Conexion() {
    }
    
    
    
    /**
     * Se genera la conexión con la base de datos con un driver
     * @return con
     */
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajeria", "root", "");
            System.out.println("Se conectó (: ");
        }catch(ClassNotFoundException | SQLException e){ 
            System.out.println("Error" + e);
        }
        return con;
    }
}
