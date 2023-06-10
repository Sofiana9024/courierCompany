/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java
 * Programación Orientada a Objetos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 */
package paquete;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame que proporciona al usuario información de los paquetes por el estado en el que se encuentran
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class ConsultaPktXEstado extends javax.swing.JFrame {
    /**
     * Representa la conexión
     */
    private final Connection con;
    /**
     * Variable de tipo paquete
     */
    private final Paquete paquete;
    
    class FondoPanel extends javax.swing.JPanel{
        private java.awt.Image imagen;
        
        @Override
        public void paint(java.awt.Graphics g){
            imagen = new javax.swing.ImageIcon(
            getClass().getResource("/imgPkt/ConsultaPktXEstado.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    /**
     * Creates new form ConsultaPktXEstado
     * @param con Conexion
     */
    public ConsultaPktXEstado(Connection con) {
        this.con = con;
        paquete = new Paquete(this.con);
        initComponents();
        actualizaTabla(0);
        
        this.setTitle("Paquetes por Estado");
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

        /**
        * panel de fondo
        */
        javax.swing.JPanel jPanel1 = new FondoPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        txtEstado = new javax.swing.JComboBox<>();
        btnTodosLosPkts = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "En proceso", "Entregado" }));
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        btnTodosLosPkts.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTodosLosPkts.setText("Todos los paquetes");
        btnTodosLosPkts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosLosPktsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnTodosLosPkts))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnTodosLosPkts)
                .addContainerGap(315, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        /**
        * panel de fondo
        */

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        Archivo objArchivo1 = new Archivo(con,txtEstado.getSelectedItem().toString(),3);
        Archivo objArchivo2 = new Archivo(con,txtEstado.getSelectedItem().toString(),3);
        objArchivo1.setPriority(1);
        objArchivo2.setPriority(10);
        objArchivo1.start();
        objArchivo2.start();
        actualizaTabla(0);
        
        actualizaTabla(1);
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void btnTodosLosPktsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosLosPktsActionPerformed
        Archivo objArchivo1 = new Archivo(con,1);
        Archivo objArchivo2 = new Archivo(con,1);
        objArchivo1.setPriority(1);
        objArchivo2.setPriority(10);
        objArchivo1.start();
        objArchivo2.start();
        actualizaTabla(0);
    }//GEN-LAST:event_btnTodosLosPktsActionPerformed

    /**
     *Cuando el valor es diferente de cero se actualiza la tabla dependiendo del estado de lo contrario se actualiza completa
     * @param op opcion de consulta 1 consulta por empleado
     * opcion 0 consulta general
     */

    public final void actualizaTabla(int op){
        DefaultTableModel modelo;
        if(op != 0){
             modelo = paquete.actualizaTablaPaquete("estado", txtEstado.getSelectedItem().toString(), 0);
        }else{
             modelo = paquete.actualizaTablaPaquete("", "", 0);
        }
        this.Datos.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Tabla en la que aparecen las consultas
    */
    private javax.swing.JTable Datos;
    /**
    * boton que llama al método de generar pdf sobre las consultas generales
    */
    private javax.swing.JButton btnTodosLosPkts;
    /**
    * texto que aparece en pantalla
    */
    private javax.swing.JLabel jLabel1;
    /**
    * scroll panel
    */
    private javax.swing.JScrollPane jScrollPane1;
    /**
    * textfield que muestra las opciones de estado
    */
    private javax.swing.JComboBox<String> txtEstado;
    // End of variables declaration//GEN-END:variables
}
