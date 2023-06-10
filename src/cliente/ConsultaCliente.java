/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */
package cliente;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame que muestra la consulta de los clientes, una tabla con los datos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class ConsultaCliente extends javax.swing.JFrame {
    
    /**
     * Representa la conexión
     */
    private final Connection con;
    /**
     * Variable de tipo cliente
     */
    private final Cliente cliente;
    
    class FondoPanel extends javax.swing.JPanel{
        private java.awt.Image imagen;
        
        @Override
        public void paint(java.awt.Graphics g){
            imagen = new javax.swing.ImageIcon(
            getClass().getResource("/imgCliente/ConsultaCliente.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    /**
     * Creates new form ConsultaCliente
     * Crea una instancia de la clase Consulta cliente
     * Inicializa algunos de los valores que aparecen en el pane
     * Establece la posicion del pane
     * @param con Conexión
     */
    public ConsultaCliente(Connection con) {
        this.con = con;
        cliente = new Cliente(this.con);
        initComponents();
        actualizaTabla();
        this.setTitle("Consulta Cliente");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        /**
        * Formato de la tabla
        */
        Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        /**
        * scroll panel
        */
        jScrollPane1.setViewportView(Datos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Función que actualiza la tabla del paquete, usando la variable de nombre Datos
     */
    public final void actualizaTabla(){
        DefaultTableModel modelo = cliente.actualizaTablaCliente();
        this.Datos.setModel(modelo);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Tabla en la que aparecen los datos
    */
    private javax.swing.JTable Datos;
    /**
    * panel de fondo
    */
    private javax.swing.JPanel jPanel1;
    /**
    * scroll panel
    */
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
