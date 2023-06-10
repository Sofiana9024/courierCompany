/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */

package empleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.Random;

/**
 * Clase en la que se desarrollan todos los métodos referentes al empleado y que se usan en los frames
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Empleado {
    
    private final Connection con;
    private ArrayList<ArrayList<Object>> lista = new ArrayList<>();
    private final ArrayList<Object> IDEMPLEADO = new ArrayList();
    private String idEmpleado[];
    private int ultIdEmpleado=0;
    private Random rand = new Random();
    
    /**
     * Crea una instancia de la clase Empleado
     * @param con Conexion
     */
    public Empleado(Connection con){
        this.con = con;
    }
    
    /**
     * Con una sentencia sql se da de alta un registro con la información recopilada del jFrame
     * @param nombre del empleado
     * @param direccion del empleado
     * @param telefono del empleado
     * @param correo del empleado
     * @param rol  del empleado
     */
    public void altaEmpleado(String nombre, String direccion, String telefono, String correo, String rol){
        try{
            Statement sts = con.createStatement();
//            correo.toLowerCase()
            sts.addBatch("INSERT INTO empleado(nombre, direccion, telefono, correo, rol, estado) VALUES ( '"+ nombre +"','"+direccion+"','"+telefono+"','"+correo+"','"+rol+"','activo')"); 
            sts.executeBatch();
        }catch(SQLException e){
            System.out.println("Error " + e);
        }
    }
    
    /**
     * se hace una consulta de todos los registros de la tabla empleado
     */
    public final void consultaEmpleado(){
        int reg = 0;
        try{
            getLista().clear();
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM empleado");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                getLista().add(new ArrayList<>());
                getLista().get(reg).add(rs.getInt("idEmpleado"));
                getLista().get(reg).add(rs.getString("nombre"));
                getLista().get(reg).add(rs.getString("direccion"));
                getLista().get(reg).add(rs.getString("telefono"));
                getLista().get(reg).add(rs.getString("correo"));
                getLista().get(reg).add(rs.getString("rol"));
                getLista().get(reg).add(rs.getString("estado"));
                reg++;
            }
            Iterator miIterator = getLista().iterator();
            while(miIterator.hasNext()){
                System.out.println(miIterator.next()+ "\t");
            }
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se hace una consulta del empleado con un id específico
     * los datos recopilados se muestran en la consula
     * @param idEmpleado id del empleado
     * @return resul un arreglo con los datos de la consulta
     */
    public String[] consultaEmpleado(int idEmpleado){
        String resul[] = new String[6];
        try{
            Statement sts = con.createStatement();
            sts.execute("SELECT * from empleado where idEmpleado= "+idEmpleado+"");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                resul[0] = rs.getString("nombre");
                resul[1] = rs.getString("direccion");
                resul[2] = rs.getString("telefono");
                resul[3] = rs.getString("correo");
                resul[4] = rs.getString("rol");
                resul[5] = rs.getString("estado");
            }
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }catch(NumberFormatException ex){
            System.out.println(ex);
        }
        return resul;
    }
    
    /**
     * A partir de los datos obtenidos del jFrane se realiza una modificacion a los registros
     * se utiliza una sentencia sql
     * @param idEmpleado id del empleado
     * @param nombre del empleado
     * @param correo del empleado
     * @param direccion del empleado
     * @param telefono del empleado
     * @param rol del empleado
     * @param estado  del empleado
     */
    public void modificaEmpleado(int idEmpleado, String nombre, String correo, String direccion, String telefono, String rol, String estado){
        try{
            Statement sts = con.createStatement();
            sts.executeUpdate("UPDATE empleado set nombre= '"+nombre+"', correo='"+correo+"' , direccion = '"+direccion+"', telefono = '"+telefono+"', rol = '"+rol+"', estado = '"+estado+"' WHERE idEmpleado="+idEmpleado);
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se consulta todos los registros de la tabla empleado
     * se obtiene el valor de los id
     * se obtiene el valor del id que tendrá el siguiente registro
     */
    public void obtenerIdEmpleado(){
        try{
            IDEMPLEADO.clear();
            int cont = 0;
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM empleado");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                IDEMPLEADO.add(rs.getInt("idEmpleado"));
                cont++;
            }
            idEmpleado = new String[cont];
            for(int i = 0; i<cont;i++ ){
                idEmpleado[i]=IDEMPLEADO.get(i).toString();
            }
            ultIdEmpleado = getIdEmpleado().length+2;
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se consulta todos los registros de la tabla empleado en los cuales sea un estado específico y el rol sea de entrega
     * se obtiene el valor de los id y se guarda en un arreglo
     * @param estado parámetro que modifica la consulta solo a ciertos registros
     */
    public void obtenerIdEmpleado(String estado){
        try{
            IDEMPLEADO.clear();
            int cont = 0;
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM empleado WHERE estado = '" + estado + "' AND rol = 'entrega'");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                IDEMPLEADO.add(rs.getInt("idEmpleado"));
                cont++;
            }
            idEmpleado = new String[cont];
            for(int i = 0; i<cont;i++ ){
                idEmpleado[i]=IDEMPLEADO.get(i).toString();
            }
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * se generan los datos que aparecerán dentro de una tabla
     * al realizar una consulta
     * se usa al actualizar datos
     * @return modelo información que muestra la tabla
     */
    public final DefaultTableModel actualizaTablaEmpleado(){
        DefaultTableModel modelo = new DefaultTableModel();
        Object datos[] = new Object[7];
        modelo.addColumn("idEmpleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Rol");
        modelo.addColumn("Estado");
        
        consultaEmpleado();
        for (int j = 0; j < getLista().size(); j++) {
            datos[0] = getLista().get(j).get(0);
            datos[1] = getLista().get(j).get(1);
            datos[2] = getLista().get(j).get(2);
            datos[3] = getLista().get(j).get(3);
            datos[4] = getLista().get(j).get(4);
            datos[5] = getLista().get(j).get(5);
            datos[6] = getLista().get(j).get(6);
            modelo.addRow(datos);
        }
        return modelo;
    }
    
    /**
     * Función que genera un correo 
     * @param nombre toma 4 valores del nombre proporcionado
     * @param idEmpleado concatena el id del empleado despues de los 4 caracteres
     * @return junto.toLowerCase();
     */
    public String correo(String nombre, String idEmpleado){
        String correo = "";
        char[] nombres = nombre.toCharArray();
        String letra;
        
        do{
            char letraAleatoria = nombres[rand.nextInt(nombres.length)];
            letra = Character.toString(letraAleatoria);
            if(!" ".equals(letra)){
                correo = correo + letra;
            }
        }while(correo.length() < 4);
        String junto = correo + idEmpleado + "@fedex.com";
        
        
        return junto.toLowerCase();
        
    }
    
    /**
     * Se comprueba si lo ingresado son números
     * @param telefono telefono del cliente
     * @return boolean true / falase
     */
    public static boolean soloNums(String telefono) {
        try {
            Integer.parseInt(telefono);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Oobtiene el arrayList
     * @return the lista retorna el arraylis
     */
    public ArrayList<ArrayList<Object>> getLista() {
        return lista;
    }
    
    /**
     * Obtiene el idEmpleado
     * @return the idEmpleado retorna el id del empleado
     */
    public String[] getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Obtiene el ultimo id de los empleados registrados
     * @return the ultIdEmpleado retorna el siguiente id de empleado a asignar
     */
    public int getUltIdEmpleado() {
        return ultIdEmpleado;
    }
}
