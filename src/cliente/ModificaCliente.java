/*
 * Universidad Politécnica de San Luis Potosí
 * Programación III Java 
 * Programación Orientada a Objetos
 */
package cliente;
import excepciones.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *  JFrame que muestra los datos para la modificacion de los clientes permitiendo modificar algunos datos
 * @author Ana Sofía Rodríguez Castillo, 178815@upslp.edu.mx
 * @author Ana Sofía Rodriguez Castillo
 * @author 178815@upslp.edu.mx
 * @version 1.0
 */
public class ModificaCliente extends javax.swing.JFrame {
    
    /**
     * Representa la conexión
     */
    private final Connection con;
    /**
     * Variable que guarda el id del cliente
     */
    private int registro;
    /**
     * Variable de para el correo anteriormente registrado
     */
    private String correoTemp;
    /**
     * Variable de tipo cliente
     */
    private final Cliente cliente;
    
    class FondoPanel extends javax.swing.JPanel{
        private java.awt.Image imagen;
        
        @Override
        public void paint(java.awt.Graphics g){
            imagen = new javax.swing.ImageIcon(//img\\Inicio.gif
            getClass().getResource("/imgCliente/ModificaCliente.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }
    /**
     * Creates new form ModificaCliente
     * Se crea una instancia de la clase ModificaCliente
     * Inicializa algunos de los valores que aparecen en el pane
     * Establece la posicion del pane
     * @param con Conexion
     */
    public ModificaCliente(Connection con) {
        this.con = con;
        cliente = new Cliente(this.con);
        initComponents();
        actualizaTabla();
        cliente.obtenerIdCliente();
        txtIdCliente.setModel(new javax.swing.DefaultComboBoxModel(cliente.getIdCliente()));
        this.setTitle("Modifica Cliente");
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
        txtIdCliente = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtEstado = new javax.swing.JComboBox<>();
        Datos = new javax.swing.JScrollPane();
        Datoss = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtIdCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        txtEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));

        Datoss.setModel(new javax.swing.table.DefaultTableModel(
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
        Datos.setViewportView(Datoss);

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIdCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre)
                        .addComponent(txtDireccion)
                        .addComponent(txtTelefono)
                        .addComponent(txtCorreo)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnGuardar))
                    .addComponent(Datos, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
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

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        registro = Integer.parseInt(txtIdCliente.getSelectedItem().toString());
        String resul[] = cliente.consultaCliente(registro);
        txtNombre.setText(resul[0]);
        txtDireccion.setText(resul[1]);
        txtTelefono.setText(resul[2]);
        correoTemp = resul[3];
        txtCorreo.setText(resul[3]);
        txtEstado.setSelectedItem(resul[4]);
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try{
            if(txtNombre.getText().equals("") || txtDireccion.getText().equals("") || txtTelefono.getText().equals("") || txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Faltan datos por llenar");
            }else{
                registro = Integer.parseInt(txtIdCliente.getSelectedItem().toString());
                cliente.modificaCliente(registro, txtNombre.getText(), txtCorreo.getText(), txtDireccion.getText(), txtTelefono.getText(), txtEstado.getSelectedItem().toString());
                JOptionPane. showMessageDialog(this,"Registro modificado");
                actualizaTabla();
            }  
        }catch(Exception err){
            
        }finally{
            txtNombre.setText("");
            txtCorreo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            actualizaTabla();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        try{
            correoR();
        }catch(CorreoRepetidoException  e){
            JOptionPane.showMessageDialog(null, e.getMessage() + "\n Lo regresaremos a su valor original", "Advertencia", JOptionPane.WARNING_MESSAGE);
            txtCorreo.setText(correoTemp);
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    /**
     * funcion busca repeticiones del correo
     * consulta sql que excluye el correo del registro implicado
     * @throws CorreoRepetidoException  exceción propia
     */
    public void correoR() throws CorreoRepetidoException{
        
        try {
            Statement sts = con.createStatement();
            String consulta = "SELECT * FROM cliente WHERE idCliente <> " + registro + "";
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
     * Función que actualiza la tabla del cliente, usando la variable de nombre Datos
     */
    public final void actualizaTabla(){
        DefaultTableModel modelo = cliente.actualizaTablaCliente();
        this.Datoss.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Tabla en la que aparecen las consultas
    */
    private javax.swing.JScrollPane Datos;
    /**
    * Tabla en la que aparecen las consultas
    */
    private javax.swing.JTable Datoss;
    /**
    * boton que llama al método de modifica
    */
    private javax.swing.JButton btnGuardar;
    /**
    * panel de fondo
    */
    private javax.swing.JPanel jPanel1;
    /**
    * textfield para modificar correo
    */
    private javax.swing.JTextField txtCorreo;
    /**
    * textfield para modificar dirección
    */
    private javax.swing.JTextField txtDireccion;
    /**
    * combo box para elegir estado
    */
    private javax.swing.JComboBox<String> txtEstado;
    /**
    * combo box para elegir id cliente
    */
    private javax.swing.JComboBox<String> txtIdCliente;
    /**
    * textfield para modificar nombre
    */
    private javax.swing.JTextField txtNombre;
    /**
    * textfield para modificar teléfono
    */
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
