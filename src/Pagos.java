import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


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
    
    public void BusquedaPago(ResultSet rs){
        
        try {
            while (rs.next()) {
                jTextFieldCodigo.setText(String.valueOf(rs.getInt("codigo_cliente")));
                jComboBoxPago.setSelectedItem(rs.getString("forma_pago"));
                jTextFieldId.setText(rs.getString("id_transaccion"));
                jTextFieldFechaPago.setText(rs.getString("fecha_pago"));
                jTextFieldTotal.setText(String.valueOf(rs.getDouble("total")));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al buscar el pago");
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabelSeccion1 = new javax.swing.JLabel();
        jButtonRealizarPago = new javax.swing.JButton();
        jButtonActualizarPago = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonGestionCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pagos Clientes Merloy Lerlin");
        setResizable(false);

        jPanelVentana.setBackground(new java.awt.Color(102, 102, 255));
        jPanelVentana.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 5, true));
        jPanelVentana.setForeground(new java.awt.Color(255, 255, 255));

        jButtonEliminarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonEliminarPago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonEliminarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminarPago.setText("Eliminar pago");
        jButtonEliminarPago.setMaximumSize(new java.awt.Dimension(129, 27));
        jButtonEliminarPago.setMinimumSize(new java.awt.Dimension(129, 27));
        jButtonEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarPagoActionPerformed(evt);
            }
        });

        jButtonBuscarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonBuscarPago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        jLabelMetodopago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMetodopago.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMetodopago.setText("Metodo de pago");

        jComboBoxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paypal", "Transferencia", "Cheque" }));
        jComboBoxPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagoActionPerformed(evt);
            }
        });

        jLabelCodigocliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCodigocliente.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigocliente.setText("Codigo del cliente");

        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jLabelFechapago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFechapago.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFechapago.setText("Fecha de pago");

        jLabelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setText("Total");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id transaccion");

        jTextFieldId.setEditable(false);

        javax.swing.GroupLayout jPanelRealizarPagoLayout = new javax.swing.GroupLayout(jPanelRealizarPago);
        jPanelRealizarPago.setLayout(jPanelRealizarPagoLayout);
        jPanelRealizarPagoLayout.setHorizontalGroup(
            jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRealizarPagoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRealizarPagoLayout.createSequentialGroup()
                        .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCodigocliente)
                            .addComponent(jLabel1))
                        .addGap(14, 14, 14)
                        .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCodigo)
                            .addComponent(jTextFieldId)))
                    .addGroup(jPanelRealizarPagoLayout.createSequentialGroup()
                        .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRealizarPagoLayout.createSequentialGroup()
                                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFechapago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelMetodopago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanelRealizarPagoLayout.createSequentialGroup()
                                .addComponent(jLabelTotal)
                                .addGap(100, 100, 100)))
                        .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTotal)
                            .addComponent(jTextFieldFechaPago)
                            .addComponent(jComboBoxPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );
        jPanelRealizarPagoLayout.setVerticalGroup(
            jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRealizarPagoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigocliente)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMetodopago)
                    .addComponent(jComboBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechapago)
                    .addComponent(jTextFieldFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelRealizarPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotal)
                    .addComponent(jTextFieldTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabelSeccion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSeccion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSeccion1.setText("REALIZACION E ACTUALIZACION DE PAGOS");

        jButtonRealizarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonRealizarPago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRealizarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRealizarPago.setText("Realizar pago");
        jButtonRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarPagoActionPerformed(evt);
            }
        });

        jButtonActualizarPago.setBackground(new java.awt.Color(51, 0, 153));
        jButtonActualizarPago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonActualizarPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizarPago.setText("Actualizacion pago");
        jButtonActualizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarPagoActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Limpiar Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonGestionCliente.setBackground(new java.awt.Color(51, 0, 153));
        jButtonGestionCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonGestionCliente.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGestionCliente.setText("Gestion Cliente");
        jButtonGestionCliente.setMaximumSize(new java.awt.Dimension(129, 27));
        jButtonGestionCliente.setMinimumSize(new java.awt.Dimension(129, 27));
        jButtonGestionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGestionClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelVentanaLayout = new javax.swing.GroupLayout(jPanelVentana);
        jPanelVentana.setLayout(jPanelVentanaLayout);
        jPanelVentanaLayout.setHorizontalGroup(
            jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVentanaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(225, 225, 225))
            .addGroup(jPanelVentanaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVentanaLayout.createSequentialGroup()
                        .addComponent(jLabelSeccion1)
                        .addContainerGap())
                    .addGroup(jPanelVentanaLayout.createSequentialGroup()
                        .addComponent(jPanelRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVentanaLayout.createSequentialGroup()
                                .addComponent(jButtonActualizarPago)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVentanaLayout.createSequentialGroup()
                                .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButtonBuscarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonEliminarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonGestionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37))))))
        );
        jPanelVentanaLayout.setVerticalGroup(
            jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentanaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabelSeccion1)
                .addGap(18, 18, 18)
                .addGroup(jPanelVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelRealizarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelVentanaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonRealizarPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBuscarPago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminarPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGestionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonActualizarPago)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarPagoActionPerformed

    try {
        
        stm=conBD.createStatement();
        String id = "SELECT * FROM pago WHERE id_transaccion != 'ak-std-000035' ORDER BY id_transaccion";
        String forma_pago =(String)jComboBoxPago.getSelectedItem();
        int codigo=Integer.parseInt(jTextFieldCodigo.getText());
        String fecha =jTextFieldFechaPago.getText();
        String nuevoid="";
        
        if(fecha.matches("((198[0-9]|199[0-9]|200[0-9]|201[0-9]|202[0-2])|2023)[-](0[1-9]|1[0-2])[-](0[1-9]|[12][0-9]|3[01])")){
            
        
        rs= stm.executeQuery(id);
        int cont=0;
        
        while(rs.next()){
            cont++;
            nuevoid=rs.getString("id_transaccion");
        
        
        }
        String numero=nuevoid.substring(11,13);
        int numerosuma=Integer.parseInt(numero)+1;
        id_transaccion="ak-std-0000"+numerosuma;
        
        if(numerosuma==35){
            
        id_transaccion="ak-std-0000"+(numerosuma+1);
        
        }
        
        sql = "INSERT INTO pago VALUES("+codigo+",'"+forma_pago+"','"+id_transaccion+"','"+fecha+"',"+jTextFieldTotal.getText()+")";
        stm.executeUpdate(sql);
        JOptionPane.showMessageDialog(this, "Pago creado correctamente");
        
        }
        
        else{
        
        JOptionPane.showMessageDialog(this,"La fecha no tiene un formato correcto","Realizacion de pago cancelado",JOptionPane.ERROR_MESSAGE);
            
        }
        
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Error al realizar el pago");
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
           
            if(fecha.matches("((198[0-9]|199[0-9]|200[0-9]|201[0-9]|202[0-2])|2023)[-](0[1-9]|1[0-2])[-](0[1-9]|[12][0-9]|3[01])")){
            
                id_transaccion=jTextFieldId.getText();
            
                if(jTextFieldId.getText().isEmpty()){
             
                    JOptionPane.showMessageDialog(this,"Busca un pago antes de querer actualizarlo","Error en la actualizacion",JOptionPane.ERROR_MESSAGE);
            
                }
             
                else{
                    sql = "UPDATE pago set codigo_cliente='"+codigo+"', forma_pago='"+forma_pago+"', fecha_pago='"+fecha+"', total='"+total+"' WHERE id_transaccion LIKE '"+id_transaccion+"'";    
            
                    stm.executeUpdate(sql);
                    stm.close();
                    JOptionPane.showMessageDialog(this,"Pago actualizado correctamente","Actualizcion realizada",JOptionPane.INFORMATION_MESSAGE);

                }        
            }    
            
            else{
            
            JOptionPane.showMessageDialog(this,"La fecha no tiene un formato correcto","Actualizacion cancelada",JOptionPane.ERROR_MESSAGE);
            }
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error con la actualizacion de datos debe rellenar todos los campos correctamente");
        }
        
        
    }//GEN-LAST:event_jButtonActualizarPagoActionPerformed

    private void jButtonBuscarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPagoActionPerformed
    
        try{
            stm = conBD.createStatement();
            id_transaccion=JOptionPane.showInputDialog(this,"Introduce el id de la transaccion para busacar el pago y cargarlo en la tabla");
            
            
            sql = "SELECT * FROM pago WHERE id_transaccion LIKE '"+id_transaccion+"'";
    
            if(id_transaccion.matches("[a][k][-][s][t][d][-][0][0][0][0][0-9][0-9]")){
            
                rs = stm.executeQuery(sql);
            
                 BusquedaPago(rs);
            
            }
                 
            else{
                    
                JOptionPane.showMessageDialog(this,"No se puede buscar el pago introduce el id correctamente","OPERACION CANCELADO", JOptionPane.ERROR_MESSAGE);

                    }    
           

        }
            catch(Exception e){
            
            JOptionPane.showMessageDialog(this, "Error en la busqueda del pago");
        }
        
    }//GEN-LAST:event_jButtonBuscarPagoActionPerformed

    private void jButtonEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarPagoActionPerformed

        try{
            
            
        stm = conBD.createStatement();
        
        if(jTextFieldId.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(this,"Busque un pago antes de intentar eliminarlo","Pago no encontrado", JOptionPane.ERROR_MESSAGE);
                    
            
        }
        
        else{
            int opcion=JOptionPane.showConfirmDialog(this, "Esta seguro?", "Confirmacion del borrado",JOptionPane.YES_NO_OPTION, EXIT_ON_CLOSE);


                switch (opcion) {
                    case 0:{

                        JOptionPane.showMessageDialog(this,"No se puede borrar debido a que el pago esta restringido","OPERACION CANCELADO", JOptionPane.ERROR_MESSAGE);

                        break;
                    }    
                    case 1:{

                        JOptionPane.showMessageDialog(this,"Se ha cancelado el borrado");

                        break;
                    }
                    default:
                        
                        JOptionPane.showMessageDialog(this,"Se ha cancelado el borrado");

                        
                        break;
                }

        }
        }
        
        catch(SQLException e){
            
            Logger.getLogger(Pagos.class.getName()).log(Level.SEVERE, null, e);
           }
    }//GEN-LAST:event_jButtonEliminarPagoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        jTextFieldId.setText("");
        jTextFieldCodigo.setText("");
        jComboBoxPago.setSelectedIndex(0);
        jTextFieldFechaPago.setText("");
        jTextFieldTotal.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonGestionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGestionClienteActionPerformed
        GestionClientes cli = new GestionClientes();
        cli.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonGestionClienteActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonActualizarPago;
    private javax.swing.JButton jButtonBuscarPago;
    private javax.swing.JButton jButtonEliminarPago;
    private javax.swing.JButton jButtonGestionCliente;
    private javax.swing.JButton jButtonRealizarPago;
    private javax.swing.JComboBox<String> jComboBoxPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCodigocliente;
    private javax.swing.JLabel jLabelFechapago;
    private javax.swing.JLabel jLabelMetodopago;
    private javax.swing.JLabel jLabelSeccion1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanelRealizarPago;
    private javax.swing.JPanel jPanelVentana;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldFechaPago;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldTotal;
    // End of variables declaration//GEN-END:variables
}
