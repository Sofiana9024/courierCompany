/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */

package paquete;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import javax.swing.table.DefaultTableModel;


/**
 * Clase en la que se definen los métodos correspondientes a los paqutes, esto incluye la creación de archivos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class Paquete {
    
    ArrayList<String> palabras = new ArrayList<String>(Arrays.asList("comida", "saludable", "ejercicio", "físico", "marketing", "digital", "tecnología", "móvil", "viajes", "baratos", "moda", "sostenible", "películas", "acción", "recetas", "vegetarianas", "crianza", "consciente", "finanzas", "personales", "juegos", "mesa", "arte", "contemporáneo", "meditación", "guiada", "fotografía", "paisajes", "energías", "renovables", "decoración", "minimalista", "entrenamiento", "fuerza", "innovación", "tecnológica", "historia", "arte", "ecología"));
    private final Connection con;
    private ArrayList<ArrayList<Object>> lista = new ArrayList<>();
    private final ArrayList<Object> IDPAQUETE = new ArrayList();
    private String idPaquete[];
    private int ultIdPaquete=0;
    private Random rand = new Random();
    
    /**
     * Crea una instancia de la clase Paquete
     * @param con Conexión
     */
    public Paquete(Connection con){
        this.con = con;
    }
    
    /**
     * Con una sentencia sql se da de alta un registro con la información recopilada del jFrame
     * @param direccionE de entrega
     * @param pClave palabra clave del paquete
     * @param idCliente id del cliente
     * @param nomCliente nombre del cliente
     * @param idEmpleado  id del empleado
     */
    public void altaPaquete(String direccionE, String pClave, int idCliente, String nomCliente, int idEmpleado){
        try{
            Statement sts = con.createStatement();
            sts.addBatch("INSERT INTO paquete(idEmpleado, idCliente, nombreCliente, direccion, pClave, estado) VALUES ( "+idEmpleado+", "+idCliente+", '"+nomCliente+"', '"+ direccionE +"','"+pClave+"','Activo' )"); 
            sts.executeBatch();
        }catch(SQLException e){
            System.out.println("Error " + e);
        }
    }
    
    /**
     * Se hace una consulta general de los paqutes 
     * los datos recopilados se muestran en la consula
     */
    public final void consultaPaquete(){
        int reg = 0;
        try{
            getLista().clear();
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM paquete");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                    getLista().add(new ArrayList<>());
                    getLista().get(reg).add(rs.getInt("idPaquete"));
                    getLista().get(reg).add(rs.getInt("idCliente"));
                    getLista().get(reg).add(rs.getInt("idEmpleado"));
                    getLista().get(reg).add(rs.getString("nombreCliente"));
                    getLista().get(reg).add(rs.getString("direccion"));
                    getLista().get(reg).add(rs.getString("pClave"));
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
     * Consulta de los paquetes por empleado
     * @param id del empleado
     */

    public final void consultaPaquete(int id){
        int reg = 0;
        try{
            getLista().clear();
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM paquete");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                if(rs.getInt("idEmpleado") == id){
                    getLista().add(new ArrayList<>());
                    getLista().get(reg).add(rs.getInt("idPaquete"));
                    getLista().get(reg).add(rs.getInt("idCliente"));
                    getLista().get(reg).add(rs.getInt("idEmpleado"));
                    getLista().get(reg).add(rs.getString("nombreCliente"));
                    getLista().get(reg).add(rs.getString("direccion"));
                    getLista().get(reg).add(rs.getString("pClave"));
                    getLista().get(reg).add(rs.getString("estado"));
                    reg++;
                }  
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
     * Consulta los paqutes cuando tienen cierto estado
     * @param estado estaod de los paquetes activo / en proceso / entregado
     */
    public final void consultaPaquete(String estado){
        int reg = 0;
        try{
            getLista().clear();
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM paquete WHERE estado = '" + estado + "'");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                    getLista().add(new ArrayList<>());
                    getLista().get(reg).add(rs.getInt("idPaquete"));
                    getLista().get(reg).add(rs.getInt("idCliente"));
                    getLista().get(reg).add(rs.getInt("idEmpleado"));
                    getLista().get(reg).add(rs.getString("nombreCliente"));
                    getLista().get(reg).add(rs.getString("direccion"));
                    getLista().get(reg).add(rs.getString("pClave"));
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
     * Consulta los paqutes cuando tienen cierto id de empleado
     * @param idPaquete id del paquete
     * @return resul arreglo con los datos del paquete
     */
    public String[] consultaPaqueteS(int idPaquete){
        String resul[] = new String[7];
        try{
            Statement sts = con.createStatement();
            sts.execute("SELECT * from paquete where idPaquete= "+idPaquete+"");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                resul[0] = rs.getString("idPaquete");
                resul[1] = rs.getString("idCliente");
                resul[2] = rs.getString("idEmpleado");
                resul[3] = rs.getString("nombreCliente");
                resul[4] = rs.getString("direccion");
                resul[5] = rs.getString("pClave");
                resul[6] = rs.getString("estado");
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
     * @param idPaquete id del paquete
     * @param direccion dirección de entrega
     * @param estado estado del paquete
     * @param pClave palabra clave
     * @param idCliente id del cliente a quien es propietario del paquete
     * @param nomCliente nombre del cliente
     * @param idEmpleado id del empleado que hace la entrega
     */
    public void modificaPaquete(int idPaquete, String direccion, String estado, String pClave,  int idCliente, String nomCliente, int idEmpleado){
        try{
            Statement sts = con.createStatement();
            sts.executeUpdate("UPDATE paquete set direccion= '"+direccion+"', estado= '"+estado+"', pClave= '"+pClave+"', idCliente= "+idCliente+", idEmpleado= "+idEmpleado+", nombreCliente= '"+nomCliente+"' WHERE idPaquete="+idPaquete);
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se consulta todos los registros de la tabla paquete
     * se obtiene el valor de los id
     * se obtiene el valor del id que tendrá el siguiente registro
     */
    public void obtenerIdPaquete(){
        try{
            int cont = 0;
            Statement sts = con.createStatement();
            sts.execute("SELECT * FROM paquete");
            ResultSet rs = sts.getResultSet();
            while(rs.next()){
                IDPAQUETE.add(rs.getInt("idPaquete"));
                cont++;
            }
            idPaquete = new String[cont];
            for(int i = 0; i<cont;i++ ){
                idPaquete[i]=IDPAQUETE.get(i).toString();
            }
            ultIdPaquete = getIdPaquete().length+1;
        }catch(SQLException ex){
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Se actualizan los elementos de la tabla dependiendo
     * opcion empleado, consultas tomando de referencia al empleado
     * opcion estado, consultas tomando de referencia el estado del paquete
     * @param opcion empleaodo / estado
     * @param estado activo / en proceso / entregado
     * @param idEmpleado id del empleado
     * @return modelo información para latabla
     */
    public final DefaultTableModel actualizaTablaPaquete(String opcion, String estado, int idEmpleado){
        DefaultTableModel modelo = new DefaultTableModel();
        Object datos[] = new Object[7];
        modelo.addColumn("Id Paquete");
        modelo.addColumn("Id Cliente");
        modelo.addColumn("Id Empleado");
        modelo.addColumn("Nom. Cliente");
        modelo.addColumn("Dirección");
        modelo.addColumn("P. Clave");
        modelo.addColumn("Estado");
        
        if("empleado".equals(opcion)){
            consultaPaquete(idEmpleado);
        }else if("estado".equals(opcion)){
            consultaPaquete(estado);
        }else{
           consultaPaquete(); 
        }
        
        
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
     * Desde una banco de palabras clave se obtiene una y se le agrega el id
     * para crear una palabra clave opcional para el usuario
     * @param id id del paquete
     * @return pclave string con la palabra clave
     */
    public String Pclave(String id){
        String pclave = "";
        int indice = rand.nextInt(palabras.size());
        return pclave = pclave + palabras.get(indice) + id;
    }

    /**
     *Oobtiene el arrayList
     * @return lista Arraylist
     */
    public ArrayList<ArrayList<Object>> getLista() {
        return lista;
    }

    /**
     * Obtiene el idPaquete
     * @return idPaquete id de los paquetes
     */
    public ArrayList<Object> getIDPAQUETE() {
        return IDPAQUETE;
    }

    /**
     * Obtiene el idPaquete
     * @return idPaquete id de los paquetes
     */
    public String[] getIdPaquete() {
        return idPaquete;
    }

    /**
     * Obtiene el ultimo id de los paquetes registrados
     * @return ultIdPaquete id del paquete que es siguiente en los registros
     */
    public int getUltIdPaquete() {
        return ultIdPaquete;
    }
    
    

}
