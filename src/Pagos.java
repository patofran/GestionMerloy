import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Pagos extends javax.swing.JFrame {
    
    Connection conBD = null;
    Statement stm = null;
    String servidor = "jdbc:mysql://localhost:3306/";
    String bd = "jardineria";
    String usuer = "root";
    String password = "daniel110704";
    String sql;
    String id_transaccion;
    ResultSet rs;
    
    public Pagos() {
        initComponents();
         
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conBD = DriverManager.getConnection(servidor + bd, usuer, password);
            
            
        } catch (SQLException error) {
            System.out.println("Error al conectar a BD: " + error.getMessage());
        } catch (Exception e){
        

        }
             
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelVentana = new javax.swing.JPanel();
        jButtonEliminarPago = new javax.swing.JButton();
        jButtonBuscarPago = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelRealizarPago = new javax.swing.JPanel();
        jLabelMetodopago = new javax.swing.JLabel();
        jComboBoxPago = new javax.swing.JComboBox<>();
        jLabelCodigocliente = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelFechapago = new javax.swing.JLabel();
        jTextFieldFechaPago = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jTextFieldTotal = new javax.swing.JTextField();
        jLabelSeccion1 = new javax.swing.JLabel();
        jButtonRealizarPago = new javax.swing.JButton();
        jButtonActualizarPago = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBuscarPago = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pagos Clientes Merloy Lerlin");
        setResizable(false);

        jPanelVentana.setBackground(new java.awt.Color(102, 102, 255));
        jPanelVentana.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 5, true));
        jPanelVentana.setForeground(new java.awt.Color(255, 255, 255));

        jButtonEliminarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonEliminarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEliminarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminarPago.setText("Eliminar pago");
        jButtonEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPagoActionPerformed(evt);
            }
        });

        jButtonBuscarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonBuscarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarPago.setText("Buscar pago");
        jButtonBuscarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPagoActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 153, 255));
        jLabelTitulo.setText("PAGOS");

        jPanelRealizarPago.setBackground(new java.awt.Color(102, 102, 255));
        jPanelRealizarPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 204), 2));
        jPanelRealizarPago.setForeground(new java.awt.Color(255, 255, 255));

        jLabelMetodopago.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMetodopago.setText("Metodo de pago");

        jComboBoxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paypal", "Transferencia", "Cheque" }));
        jComboBoxPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagoActionPerformed(evt);
            }
        });

        jLabelCodigocliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigocliente.setText("Codigo del cliente");

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabelFechapago.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechapago.setText("Fecha de pago");

        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setText("Total");

        javax.swing.GroupLayout jPanelRealizarPagoLayout = new javax.swing.GroupLayout(jPanelRealizarPago);
        jPanelRealizarPago.setLayout(jPanelRealizarPagoLayout);
        jPanelRealizarPagoLayout.setHorizontalGroup(
            jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRealizarPagoLayout.createSequentialGroup()
                .addGap(0, 61, Short.MAX_VALUE)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMetodopago)
                    .addGroup(jPanelRealizarPagoLayout.createSequentialGroup()
                        .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigocliente)
                            .addComponent(jLabelFechapago))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelTotal))
                .addGap(41, 41, 41))
        );
        jPanelRealizarPagoLayout.setVerticalGroup(
            jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRealizarPagoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigocliente)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMetodopago)
                    .addComponent(jComboBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechapago)
                    .addComponent(jTextFieldFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabelSeccion1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSeccion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeccion1.setText("REALIZACION E ACTUALIZACION DE PAGOS");

        jButtonRealizarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonRealizarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRealizarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRealizarPago.setText("Realizar pago");
        jButtonRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarPagoActionPerformed(evt);
            }
        });

        jButtonActualizarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonActualizarPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonActualizarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizarPago.setText("Actualizacion pago");
        jButtonActualizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarPagoActionPerformed(evt);
            }
        });

        jTableBuscarPago.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableBuscarPago);

        javax.swing.GroupLayout jPanelVentanaLayout = new javax.swing.GroupLayout(jPanelVentana);
        jPanelVentana.setLayout(jPanelVentanaLayout);
        jPanelVentanaLayout.setHorizontalGroup(
            jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVentanaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(229, 229, 229))
            .addGroup(jPanelVentanaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelVentanaLayout.createSequentialGroup()
                        .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSeccion1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEliminarPago)
                            .addComponent(jButtonBuscarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonActualizarPago))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanelVentanaLayout.setVerticalGroup(
            jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentanaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabelSeccion1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVentanaLayout.createSequentialGroup()
                        .addComponent(jButtonRealizarPago)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarPago)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminarPago)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonActualizarPago))
                    .addComponent(jPanelRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVentana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarPagoActionPerformed

    try {
        
        stm=conBD.createStatement();
        String id = "SELECT id_transaccion FROM pago";
        String forma_pago =(String)jComboBoxPago.getSelectedItem();
        int codigo=Integer.parseInt(jTextFieldCodigo.getText());
        String nuevoid="";
        rs= stm.executeQuery(id);
        int cont=0;
        
        while(rs.next()){
            cont++;
            nuevoid=rs.getString("id_transaccion");
            System.out.println(nuevoid);
        
        
        }
        String numero=nuevoid.substring(11,13);
        int numerosuma=Integer.parseInt(numero)+1;
        id_transaccion="ak-std-0000"+numerosuma;
        
         System.out.println(id_transaccion);
        
        sql = "INSERT INTO pago VALUES("+codigo+",'"+forma_pago+"','"+id_transaccion+"','"+jTextFieldFechaPago.getText()+"',"+jTextFieldTotal.getText()+")";
        stm.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "Cliente creado correctamente");
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al crear el pago");
        }       
    }//GEN-LAST:event_jButtonRealizarPagoActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jComboBoxPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPagoActionPerformed

    private void jButtonActualizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarPagoActionPerformed

try{
            stm = conBD.createStatement();
            int codigo=Integer.parseInt(jTextFieldCodigo.getText());
            String forma_pago =(String)jComboBoxPago.getSelectedItem();
            String fecha =jTextFieldFechaPago.getText();
            float total=Float.parseFloat(jTextFieldTotal.getText());
            id_transaccion=JOptionPane.showInputDialog(this,"Introduce el id de la transaccion para actualizar el pago");
            
            String sql = "UPDATE pago set codigo_cliente='"+codigo+"', forma_pago='"+forma_pago+"', fecha_pago='"+fecha+"', total='"+total+"' WHERE id_transaccion LIKE '"+id_transaccion+"'";
                
            
            stm.executeUpdate(sql);
            stm.close();
}
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error con la actualizacion de datos debe rellenar todos los campos correctamente");
        }
        
        
    }//GEN-LAST:event_jButtonActualizarPagoActionPerformed

    private void jButtonBuscarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPagoActionPerformed
    
        try{
            stm = conBD.createStatement();
            id_transaccion=JOptionPane.showInputDialog(this,"Introduce el id de la transaccion para busacar el pago y cargarlo en la tabla");
            
            
            String sql = "SELECT * FROM pago WHERE id_transaccion LIKE '"+id_transaccion+"'";
    
            rs = stm.executeQuery(sql);
            DefaultTableModel modelo = new DefaultTableModel(); 
        
            modelo.addColumn("Codigo cliente");
            modelo.addColumn("Forma pago");
            modelo.addColumn("id transaccion");
            modelo.addColumn("fecha pago");
            modelo.addColumn("total");
            
            String datos[] = new String[5];

            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                
                modelo.addRow(datos);
            }
            
            jTableBuscarPago.setModel(modelo);

        }
            catch(Exception e){
            
            JOptionPane.showMessageDialog(this, "Error en la busqueda del pago");
        }
        
    }//GEN-LAST:event_jButtonBuscarPagoActionPerformed

    private void jButtonEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPagoActionPerformed

        try{
        stm = conBD.createStatement();
        id_transaccion=JOptionPane.showInputDialog(this,"Introduce el id de la transaccion para eliminar el pago");

        String sql = "DELETE FROM pago WHERE id_transaccion LIKE "+id_transaccion+"";
        
        stm.executeUpdate(sql);
        
        }
        
        catch(Exception e){
            
            JOptionPane.showMessageDialog(this, "Error en la eliminacion del pago debido a que esta restringido");
        }
    }//GEN-LAST:event_jButtonEliminarPagoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarPago;
    private javax.swing.JButton jButtonBuscarPago;
    private javax.swing.JButton jButtonEliminarPago;
    private javax.swing.JButton jButtonRealizarPago;
    private javax.swing.JComboBox<String> jComboBoxPago;
    private javax.swing.JLabel jLabelCodigocliente;
    private javax.swing.JLabel jLabelFechapago;
    private javax.swing.JLabel jLabelMetodopago;
    private javax.swing.JLabel jLabelSeccion1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanelRealizarPago;
    private javax.swing.JPanel jPanelVentana;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBuscarPago;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldFechaPago;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
