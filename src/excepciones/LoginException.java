/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 */
package excepciones;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

/**
 * Clase que crea un archivo que registra los logeos de los usuarios, información sobre sus patrones de logeo
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class LoginException extends Exception {
    /**
     * guarda el usuario de logeo
     */
    private final String userLogin;
    
    /**
     * Crea una instancia de la clase LoginException que extiende de Exception
     * @param userLogin usuario  con el que se ingresa
     * @throws FileNotFoundException excepcion al no encontrar algun archivo
     */
    public LoginException(String userLogin)throws FileNotFoundException{
        this.userLogin = userLogin;
        agregaArchivo();
    }
    
    /**
     * Se crea el archivo y se le da nombre y localizacion
     * @throws FileNotFoundException excepcion al no encontrar algun archivo
     */
    public void crearArchivo()throws FileNotFoundException{
        PrintStream loginFile = new PrintStream("src/archivos/"+userLogin+".xls");
        loginFile.println("Usuario Login");
    }
    
    /**
     * Se crea un archivo por cada usuario que ingresa y se guardan sus logeos
     * @throws FileNotFoundException excepcion al no encontrar algun archivo
     */
    public void agregaArchivo()throws FileNotFoundException{
        try{
            File archivo = new File("src/archivos/"+userLogin+".xls");
            if(!archivo.exists()) crearArchivo();
            
            try(//true indica agregar informacion al archivo
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo.getAbsoluteFile(),true))
                ){
                
                bw.write("\n" + userLogin + " " + new SimpleDateFormat("EEE dd 'de' MMM 'de' YYY HH:mm:ss").format(new java.util.Date()));
                
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
}
