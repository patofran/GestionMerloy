
import java.io.BufferedWriter;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author patof
 */
public class FacturacionClientes extends javax.swing.JFrame {

    Connection conBD = null;
    Statement stm = null;
    String servidor = "jdbc:mysql://localhost:3306/";
    String basedatos = "jardineria";
    String DBuser = "root";
    String DBpass = "1234";
    Statement stmt;
    String sql;
    /**
     * Creates new form FacturacionClientes
     */
    public FacturacionClientes() {
        initComponents();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conBD = DriverManager.getConnection(servidor + basedatos, DBuser, DBpass);
        } catch (SQLException error) {
            System.out.println("Error al conectar a BD: " + error.getMessage());
        } catch (Exception e){
    
        }
        
        try {
            
            stmt = conBD.createStatement();
            
            sql = "select c.codigo_cliente, c.nombre_cliente, sum(p.total) as Facturacion_Total from cliente c join pago p on c.codigo_cliente = p.codigo_cliente group by  c.codigo_cliente, c.nombre_cliente";
            ResultSet rs = stmt.executeQuery(sql);
            
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("codigo_cliente");
            modelo.addColumn("nombre_cliente");
            modelo.addColumn("Facturacion_Total");
            
            String datos[] = new String[3];
            int cantDatosRecogidos = 0;
            
            while(rs.next()){
                cantDatosRecogidos++;
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelo.addRow(datos);
            }
            
            if (cantDatosRecogidos == 0) {
               JOptionPane.showMessageDialog(this, "No se tienen datos en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }

            jTableFacturacion.setModel(modelo);
        }catch (Exception error) {
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFacturacion = new javax.swing.JTable();
        jButtonCrearTxt = new javax.swing.JButton();
        jButtonVorverClientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Facturacion de los clientes");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 5, true));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 153, 255));
        jLabelTitulo.setText("Facturacion de los clientes");

        jTableFacturacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableFacturacion);

        jButtonCrearTxt.setBackground(new java.awt.Color(51, 0, 153));
        jButtonCrearTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCrearTxt.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCrearTxt.setText("Generar infrome");
        jButtonCrearTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearTxtActionPerformed(evt);
            }
        });

        jButtonVorverClientes.setBackground(new java.awt.Color(51, 0, 153));
        jButtonVorverClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonVorverClientes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVorverClientes.setText("Abrir Clientes");
        jButtonVorverClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVorverClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCrearTxt)
                            .addComponent(jButtonVorverClientes)))
                    .addComponent(jLabelTitulo))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCrearTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonVorverClientes)))
                .addContainerGap(77, Short.MAX_VALUE))
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

    private void jButtonCrearTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearTxtActionPerformed
        // TODO add your handling code here:
        try {
            File fichero = new File("Facturacion clientes.txt");
            FileWriter escrito = new FileWriter(fichero);
            
            escrito.write("Farturacion total de cada cliente.\n");
            for (int i = 0; i < 125; i++) {
                escrito.write("-");   
            }
            escrito.write("\n");
            escrito.write(String.format("|%-40s|", "codigo cliente"));
            escrito.write(String.format("|%-40s|", "nombre cliente"));
            escrito.write(String.format("|%-40s|", "Facturacion total"));
            escrito.write("\n");
            
            for (int i = 0; i < jTableFacturacion.getRowCount(); i++) {
                for (int j = 0; j < jTableFacturacion.getColumnCount(); j++) {
                    escrito.write(String.format("|%-40s|", jTableFacturacion.getValueAt(i, j)));
                }
                escrito.write("\n");
            }
            for (int i = 0; i < 125; i++) {
                escrito.write("-");   
            }

            escrito.close();
            System.out.println("Archivo guardado exitosamente.");
        } catch (IOException e) {

        }
    }//GEN-LAST:event_jButtonCrearTxtActionPerformed

    private void jButtonVorverClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVorverClientesActionPerformed
        GestionClientes gest = new GestionClientes();
        gest.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonVorverClientesActionPerformed

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
            java.util.logging.Logger.getLogger(FacturacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturacionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrearTxt;
    private javax.swing.JButton jButtonVorverClientes;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFacturacion;
    // End of variables declaration//GEN-END:variables
}
