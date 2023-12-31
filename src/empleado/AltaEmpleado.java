/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */
package empleado;
import excepciones.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *  JFrame que permite dar de alta un empleado pidiendo ciertos datos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class AltaEmpleado extends javax.swing.JFrame {
    
    /**
     * Representa la conexión
     */
    private final Connection con;
    /**
     * Variable de tipo empleado
     */
    private final Empleado empleado;
    
    class FondoPanel extends javax.swing.JPanel{
        private java.awt.Image imagen;
        
        @Override
        public void paint(java.awt.Graphics g){
            imagen = new javax.swing.ImageIcon(
            getClass().getResource("/imgEmpleado/AltaEmpleado.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    /**
     * Creates new form AltaEmpleado
     * Crea una instancia de la clase AltaEmpleado
     * @param con Conexión
     */
    public AltaEmpleado(Connection con) {
        this.con = con;
        empleado = new Empleado(this.con);
        initComponents();
        actualizaTabla();
        empleado.obtenerIdEmpleado();
        txtIdEmpleado.setEditable(false);
        txtIdEmpleado.setText(String.valueOf(empleado.getUltIdEmpleado()));
        txtCorreo.setEditable(false);
        this.setTitle("Alta Empleado");
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
        jPanel1 = new FondoPanel();
        txtIdEmpleado = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        /**
        * scroll panel
        */
        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        txtRol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        /**
        * No se puede editar el campo
        */
        txtIdEmpleado.setEditable(false);

        /**
        * evento accionado
        */
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        /**
        * se define la fuente y propiedades
        */
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        /**
        * texto que aparece en pantalla
        */
        btnGuardar.setText("Guardar");
        /**
        * evento accionado
        */
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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

        txtRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrega", "Registro" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtDireccion)
                            .addComponent(txtTelefono)
                            .addComponent(txtCorreo)
                            .addComponent(txtRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnGuardar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            if(txtNombre.getText().equals("") || txtDireccion.getText().equals("") || txtTelefono.getText().equals("") || txtCorreo.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Faltan datos por llenar");
            }else{
                if(Empleado.soloNums(txtTelefono.getText())){
                    empleado.altaEmpleado(txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(),txtCorreo.getText(), txtRol.getSelectedItem().toString());
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
            empleado.obtenerIdEmpleado();
            txtIdEmpleado.setText(String.valueOf(empleado.getUltIdEmpleado()));
            actualizaTabla();
        }
        actualizaTabla();
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        String correo = empleado.correo(txtNombre.getText(), txtIdEmpleado.getText());
        txtCorreo.setText(correo);
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        try{
            correoR();
        }catch(CorreoRepetidoException e){
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n Le asignaremos un nuevo correo", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtCorreo.setText(empleado.correo(txtNombre.getText(), txtIdEmpleado.getText()));
        }
    }//GEN-LAST:event_txtCorreoFocusLost
    
    /**
     * Función que realiza una consulta de los correos cuando este coincide con otro registrado se lanza una excepción
     * @throws CorreoRepetidoException  Excepción propia
     */
    public void correoR() throws CorreoRepetidoException{
        try {
            Statement sts = con.createStatement();
            String consulta = "SELECT * FROM empleado";
            ResultSet rs = sts.executeQuery(consulta);
            
            while(rs.next()){
                if(rs.getString("correo").equals(txtCorreo.getText())){
                        throw new CorreoRepetidoException(rs.getString("correo"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getNextException());
        }
    }
    
    /**
     * Función que actualiza la tabla del empleado, usando la variable de nombre Datos
     */
    public final void actualizaTabla(){
        DefaultTableModel modelo = empleado.actualizaTablaEmpleado();
        this.Datos.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Tabla en la que aparecen los datos
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
    * textfield para ingresar correo
    */
    private javax.swing.JTextField txtCorreo;
    /**
    * textfield para ingresar la dirección
    */
    private javax.swing.JTextField txtDireccion;
    /**
    * textfield que muestra el id de empleado
    */
    private javax.swing.JTextField txtIdEmpleado;
    /**
    * textfield para ingresar nombre
    */
    private javax.swing.JTextField txtNombre;
    /**
    * textfield para seleccionar el rol
    */
    private javax.swing.JComboBox<String> txtRol;
    /**
    * textfield para ingresar teléfono
    */
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
