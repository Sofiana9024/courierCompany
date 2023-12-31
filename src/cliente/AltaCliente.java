/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */
package cliente;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * JFrame que muestra y da los datos para poder dar de alta un usuario
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class AltaCliente extends javax.swing.JFrame {
    
    /**
     * Representa la conexión
     */
    private final Connection con;
    
    /**
     * Representa una variable de tipo cliente
     */
    private final Cliente cliente;
    
    /**
     * Funcion que establece el fondo del panel
     */
    class FondoPanel extends javax.swing.JPanel{
        
        /**
         * variable de tipo java.awt.Image para definir una imagen
         */
        private java.awt.Image imagen;
        
        @Override
        /**
         * Función que sobreescribe un mentodo para el fondo
         */
        public void paint(java.awt.Graphics g){
            imagen = new javax.swing.ImageIcon(//img\\Inicio.gif
            getClass().getResource("/imgCliente/AltaCliente.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    /**
     * Creates new form AltaCliente
     * Inicializa algunos de los valores que aparecen en el pane
     * Establece la posicion del pane
     * @param con Conexión
     */
    public AltaCliente(Connection con) {
        this.con = con;
        cliente = new Cliente(this.con);
        initComponents();
        actualizaTabla();
        cliente.obtenerIdCliente();
        txtIdCliente.setEditable(false);
        txtIdCliente.setText(String.valueOf(cliente.getUltIdCliente()));
        this.setTitle("Alta Cliente");
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
        /**
        * textfield que muestra el id de cliente
        */
        txtIdCliente = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1150, 580));

        /**
        * No se puede editar el campo
        */
        txtIdCliente.setEditable(false);

        /**
        * se define la fuente y propiedades
        */
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        /**
        * texto que aparece en pantalla
        */
        btnGuardar.setText("Guardar");
        /**
        * evento
        */
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        /**
        * boton que llama al método de alta
        */

        /**
        * formato de la tabla
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(152, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCliente)
                            .addComponent(txtNombre)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnGuardar)
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );

        /**
        * textfield para ingresar el nombre
        */
        /**
        * textfield para ingresar la dirección
        */

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

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Funcion que guarda el nuevo registro teniendo todos los datos necesarios
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            if(txtNombre.getText().equals("") || txtDireccion.getText().equals("") || txtTelefono.getText().equals("") || txtCorreo.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Faltan datos por llenar");
            }else{
                if(Cliente.soloNums(txtTelefono.getText())){
                    cliente.altaCliente(txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText());
                    JOptionPane.showMessageDialog(this, "Registro guardado :D");
                }else{
                    JOptionPane.showMessageDialog(this, "Solo ingrese números en el teléfono");
                }
                
            }
        }catch(Exception err){
            
        }finally{
            txtNombre.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtCorreo.setText("");
            cliente.obtenerIdCliente();
            txtIdCliente.setText(String.valueOf(cliente.getUltIdCliente()));
            actualizaTabla();
        }
        actualizaTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * Función que actualiza la tabla del cliente, usando la tabla de nombre Datos
     */
    public final void actualizaTabla(){
        DefaultTableModel modelo = cliente.actualizaTablaCliente();
        this.Datos.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Tabla cen la que aparecen los datos
    */
    private javax.swing.JTable Datos;
    /**
    * boton que llama al método de alta
    */
    private javax.swing.JButton btnGuardar;
    /**
    * panel de fondo
    */
    private javax.swing.JPanel jPanel1;
    /**
    * scroll panel
    */
    private javax.swing.JScrollPane jScrollPane1;
    /**
    * textfield para ingresar el correo
    */
    private javax.swing.JTextField txtCorreo;
    /**
    * textfield para ingresar la dirección
    */
    private javax.swing.JTextField txtDireccion;
    /**
    * textfield que muestra el id de cliente
    */
    private javax.swing.JTextField txtIdCliente;
    /**
    * textfield para ingresar el nombre
    */
    private javax.swing.JTextField txtNombre;
    /**
    * textfield para ingresar  el teléfono
    */
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
