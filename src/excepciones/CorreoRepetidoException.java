/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 */
package excepciones;

/**
 * Clase que extiende de exception para verificar si un correo está repetido
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class CorreoRepetidoException extends Exception {
    /**
     *  variable que guarda el correo
     */
    private String correoExistente;

    /**
     * Crea una instancia de la clase CorreoRepetidoException
     * @param correoExistente correo a evaluar
     */
    public CorreoRepetidoException(String correoExistente) {
        this.correoExistente = correoExistente;
    }

    /**
     * almacena el correo obtenido
     * @return correoExistente correo de la consulta
     */
    public String getCorreoExistente() {
        return correoExistente;
    }
    
    @Override
    public String getMessage() {
        return "Este correo ya está en uso";
    }
    
    
    
    
}
