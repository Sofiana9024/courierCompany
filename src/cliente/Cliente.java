/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */

package cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 * Clase en la que se desarrollan todas las funciones correspondientes a los clientes
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Cliente {
    
    /**
     * Representa la conexión
     */
    private final Connection con;
    private ArrayList<ArrayList<Object>> lista = new ArrayList<>();
    private final ArrayList<Object> IDCLIENTE = new ArrayList();
    private String idCliente[];
    private int ultIdCliente=0;
    
    /**
     * Crea una instancia de la clase Cliente
     * @param con Conexión
     */
    public Cliente(Connection con){
        this.con = con;
    }
    
    /**
     * Con una sentencia sql se da de alta un registro con la información recopilada del jFrame
     * @param nombre Nombre del cliente
     * @param direccion Dirección del cliente
     * @param telefono teléfono del cliente
     * @param correo Correo del cliente
     */
    public void altaCliente(String nombre, String direccion, String telefono, String correo){
        try{
            Statement sts = con.createStatement();
            sts.addBatch("INSERT INTO cliente(nombre, direccion, telefono, correo, estado) VALUES ( '"+ nombre +"','"+direccion+"','"+telefono+"','"+correo+"','Activo')"); 
            sts.executeBatch();
        }catch(SQLException e){
            System.out.println("Error " + e);
        }
    }
    
    /**
     * Se hace una consulta completa de los clientes registrados
     * la consulta se guarda en un arraylist
     * los datos recopilados se muestran en la consula
     */
    public final void consultaCliente(){
        int reg = 0;
        try{
            getLista().clear();
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM cliente");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                getLista().add(new ArrayList<>());
                getLista().get(reg).add(rs.getInt("idCliente"));
                getLista().get(reg).add(rs.getString("nombre"));
                getLista().get(reg).add(rs.getString("direccion"));
                getLista().get(reg).add(rs.getString("telefono"));
                getLista().get(reg).add(rs.getString("correo"));
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
     * Se hace una consulta del cliente con un id específico
     * la consulta se guarda en un arraylist
     * los datos recopilados se muestran en la consula
     * @param idCliente id del cliente
     * @return String[] arreglo con los datos de la consulta
     */
    public String[] consultaCliente(int idCliente){
        String resul[] = new String[5];
        try{
            Statement sts = con.createStatement();
            sts.execute("SELECT * from cliente where idCliente = "+idCliente+"");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                resul[0] = rs.getString("nombre");
                resul[1] = rs.getString("direccion");
                resul[2] = rs.getString("telefono");
                resul[3] = rs.getString("correo");
                resul[4] = rs.getString("estado");
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
     * @param idCliente id del cliente
     * @param nombre nombre del cliente
     * @param correo correo del cliente
     * @param direccion dirección del cliente
     * @param telefono teléfono del cliente
     * @param estado estado del cliente Activo / inactivo
     */
    public void modificaCliente(int idCliente, String nombre, String correo, String direccion, String telefono, String estado){
        try{
            Statement sts = con.createStatement();
            sts.executeUpdate("UPDATE cliente set nombre= '"+ nombre +"', correo = '"+correo+"' , direccion = '"+direccion+"' , telefono = '"+telefono+"', estado = '"+estado+"' WHERE idCliente="+idCliente);
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se consulta todos los registros de la tabla cliente
     * se obtiene el valor de los id
     * se obtiene el valor del id que tendrá el siguiente registro
     */
    public void obtenerIdCliente(){
        try{
            int cont = 0;
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM cliente");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                IDCLIENTE.add(rs.getInt("idCliente"));
                cont++;
            }
            idCliente = new String[cont];
            for(int i = 0; i<cont;i++ ){
                idCliente[i]=IDCLIENTE.get(i).toString();
            }
            ultIdCliente = getIdCliente().length+1;
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se consulta todos los registros de la tabla cliente en los cuales sea un estado específico
     * se obtiene el valor de los id y se guarda en un arreglo
     * @param estado parámetro que modifica la consulta solo a ciertos registros
     */
    public void obtenerIdCliente(String estado){
        try{
            int cont = 0;
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM cliente WHERE estado = '" + estado + "'");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                IDCLIENTE.add(rs.getInt("idCliente"));
                cont++;
            }
            idCliente = new String[cont];
            for(int i = 0; i<cont;i++ ){
                idCliente[i]=IDCLIENTE.get(i).toString();
            }
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * se generan los datos que aparecerán dentro de una tabla
     * al realizar una consulta
     * se usa cuando se quieren actualizar los datos
     * @return DefaultTableModel
     */
    public final DefaultTableModel actualizaTablaCliente(){
        DefaultTableModel modelo = new DefaultTableModel();
        Object datos[] = new Object[6];
        modelo.addColumn("idCliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Correo");
        modelo.addColumn("Estado");
        
        consultaCliente();
        for (int j = 0; j < getLista().size(); j++) {
            datos[0] = getLista().get(j).get(0);
            datos[1] = getLista().get(j).get(1);
            datos[2] = getLista().get(j).get(2);
            datos[3] = getLista().get(j).get(3);
            datos[4] = getLista().get(j).get(4);
            datos[5] = getLista().get(j).get(5);
            modelo.addRow(datos);
        }
        return modelo;
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
     * Obtiene la conexión
     * @return con Conexión
     */
    public Connection getCon() {
        return con;
    }

    /**
     *Oobtiene el arrayList
     * @return lista Arraylist
     */
    public ArrayList<ArrayList<Object>> getLista() {
        return lista;
    }

    /**
     * Obtiene el arraylist
     * @return IDCLIENTE id de los clientes
     */
    public ArrayList<Object> getIDCLIENTE() {
        return IDCLIENTE;
    }

    /**
     * Obtiene el idCliente
     * @return idCliente id de los clientes
     */
    public String[] getIdCliente() {
        return idCliente;
    }

    /**
     * Obtiene el ultimo id de los clientes registrados
     * @return ultIdCliente id del cliente que es siguiente en los registros
     */
    public int getUltIdCliente() {
        return ultIdCliente;
    }
    
    

}
