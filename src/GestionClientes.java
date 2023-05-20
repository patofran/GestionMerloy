
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionClientes extends javax.swing.JFrame {

    Connection conBD = null;
    Statement stm = null;
    String servidor = "jdbc:mysql://localhost:3306/";
    String basedatos = "jardineria";
    String DBuser = "root";
    String DBpass = "1234";
    Statement stmt;
    ResultSet consulta;
    String sql;

    public boolean camposObligatorios(){
        boolean notNuls = true;
        
        if (jTextFieldNombreCli.getText().equals("") || jTextFieldNombreCli.getText().equals(" ")) {
            notNuls = false;
        }
        if (jTextFieldTelefonoCli.getText().equals("") || jTextFieldTelefonoCli.getText().equals(" ")) {
            notNuls = false;
        }
        if (jTextFieldFaxCli.getText().equals("") || jTextFieldFaxCli.getText().equals(" ")) {
            notNuls = false;
        }
        if (jTextFieldCiudadCli.getText().equals("") || jTextFieldCiudadCli.getText().equals(" ")) {
            notNuls = false;
        }
        if (jTextFieldDireccion1Cli.getText().equals("") || jTextFieldDireccion1Cli.getText().equals(" ")) {
            notNuls = false;
        }

        return notNuls;
    }
    
    public boolean camposCorrectos(){
        int codigoEmpleado = 0;
        double limiteCredito = 0;
        boolean numericosBien = true;
        
        if (jTextFieldLimite_credito.getText().equals("") == false) {       
            try {
                limiteCredito = Double.parseDouble(jTextFieldLimite_credito.getText());
            } catch (Exception e) {
                numericosBien = false;
            }
        }
        
        if (jTextFieldCodigoEmpleado.getText().equals("") == false) {
            try {
                codigoEmpleado = Integer.parseInt(jTextFieldCodigoEmpleado.getText());
            } catch (Exception e) {
                numericosBien = false;
            }
        }
        
        return numericosBien;
    }
    
    public void cargarDatos(ResultSet consulta){
        
        try {
            while (consulta.next()) {
                jTextFieldCodigoCli.setText(String.valueOf(consulta.getInt("codigo_cliente")));
                jTextFieldNombreCli.setText(consulta.getString("nombre_cliente"));
                jTextFieldNombreCont.setText(consulta.getString("nombre_contacto"));
                jTextFieldApellidoCont.setText(consulta.getString("apellido_contacto"));
                jTextFieldTelefonoCli.setText(consulta.getString("telefono"));
                jTextFieldFaxCli.setText(consulta.getString("fax"));
                jTextFieldDireccion1Cli.setText(consulta.getString("linea_direccion1"));
                jTextFieldDireccion2Cli.setText(consulta.getString("linea_direccion2"));
                jTextFieldCiudadCli.setText(consulta.getString("ciudad"));
                jTextFieldRegionCli.setText(consulta.getString("region"));
                jTextFieldPaisCli.setText(consulta.getString("pais"));
                jTextFieldCodPostalCli.setText(consulta.getString("codigo_postal"));
                jTextFieldCodigoEmpleado.setText(consulta.getString("codigo_empleado_rep_ventas"));
                jTextFieldLimite_credito.setText(String.valueOf(consulta.getDouble("limite_credito")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
            
    public GestionClientes() {
        initComponents();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conBD = DriverManager.getConnection(servidor + basedatos, DBuser, DBpass);
        } catch (SQLException error) {
            System.out.println("Error al conectar a BD: " + error.getMessage());
        } catch (Exception e){
    
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodigoCli = new javax.swing.JTextField();
        jTextFieldNombreCli = new javax.swing.JTextField();
        jTextFieldNombreCont = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldApellidoCont = new javax.swing.JTextField();
        jTextFieldTelefonoCli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFaxCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDireccion1Cli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldDireccion2Cli = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldRegionCli = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPaisCli = new javax.swing.JTextField();
        jTextFieldCodPostalCli = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldCodigoEmpleado = new javax.swing.JTextField();
        jTextFieldLimite_credito = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldCiudadCli = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonActualizacionCli = new javax.swing.JButton();
        jButtonBuscarCli = new javax.swing.JButton();
        jButtonAltaCli = new javax.swing.JButton();
        jButtonBajaCli = new javax.swing.JButton();
        jButtonFichero = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes Merloy Lerlin");
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 855));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 5, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 1000));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 153, 255));
        jLabelTitulo.setText("GESTION DE LOS CLIENTES");

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel2.setForeground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo Cliente.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre Cliente. *");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre Contacto.");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telefono. *");

        jTextFieldCodigoCli.setEnabled(false);
        jTextFieldCodigoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoCliActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apellido Contacto.");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fax. *");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Direccion 1. *");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Direccion 2.");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Region");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Pais.");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Codigo postal.");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Codigo empleado.");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Limite_credito.");

        jTextFieldCodigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoEmpleadoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ciudad. *");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jTextFieldCodigoCli)
                            .addComponent(jTextFieldNombreCont)
                            .addComponent(jTextFieldTelefonoCli)
                            .addComponent(jTextFieldCiudadCli))
                        .addGap(114, 114, 114)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15)
                            .addComponent(jTextFieldDireccion2Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldLimite_credito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(jTextFieldFaxCli, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldApellidoCont, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNombreCli, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldDireccion1Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldRegionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodPostalCli, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPaisCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPaisCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreCont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidoCont)
                    .addComponent(jTextFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFaxCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCodPostalCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRegionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCiudadCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLimite_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDireccion1Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccion2Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Datos.");

        jButtonActualizacionCli.setBackground(new java.awt.Color(51, 0, 153));
        jButtonActualizacionCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonActualizacionCli.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizacionCli.setText("Actualizacion Cliente");
        jButtonActualizacionCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizacionCliActionPerformed(evt);
            }
        });

        jButtonBuscarCli.setBackground(new java.awt.Color(51, 0, 153));
        jButtonBuscarCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonBuscarCli.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscarCli.setText("Buscar cliente");
        jButtonBuscarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarCliActionPerformed(evt);
            }
        });

        jButtonAltaCli.setBackground(new java.awt.Color(51, 0, 153));
        jButtonAltaCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAltaCli.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAltaCli.setText("Alta cliente");
        jButtonAltaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAltaCliActionPerformed(evt);
            }
        });

        jButtonBajaCli.setBackground(new java.awt.Color(51, 0, 153));
        jButtonBajaCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonBajaCli.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBajaCli.setText("Baja cliente");
        jButtonBajaCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBajaCliActionPerformed(evt);
            }
        });

        jButtonFichero.setBackground(new java.awt.Color(51, 0, 153));
        jButtonFichero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonFichero.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFichero.setText("Facturacion del Cliente");
        jButtonFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFicheroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonActualizacionCli)
                            .addComponent(jButtonAltaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBajaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarCli)
                            .addComponent(jButtonFichero))
                        .addGap(140, 140, 140))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(143, 143, 143)
                        .addComponent(jLabelTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAltaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBajaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonActualizacionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 911, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAltaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAltaCliActionPerformed
        int ultimoCodigo = 0;
        
        //lo primero comprobamos que los campos obligatorios estan puestos
        
        if(camposObligatorios() == false){
            JOptionPane.showMessageDialog(this, "Agunos de los campos (*) obligatorios estan en blanco", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            //despues si ponen alguno de los campos numericos que no son obligatorios comprovamos que sean numeros
            
            if(camposCorrectos() == true){
                
                //en caso se que este todo correcto sacamos el ultimo id de los clientes y añadimos los datos a la tabla
                
                try {
                    stmt = conBD.createStatement();
                    
                    //con este sql sacamos el ultimo id para crear uno nuevo
                    
                    sql = "SELECT codigo_cliente FROM cliente ORDER BY codigo_cliente DESC LIMIT 1";
                    consulta = stmt.executeQuery(sql);
                    
                    if (consulta.next()) {
                        ultimoCodigo = consulta.getInt("codigo_cliente");
                    }
                    
                    //un insert mas lago que dia sin pan 
                    
                    sql = "INSERT INTO `cliente` (`codigo_cliente`, `nombre_cliente`, `nombre_contacto`, `apellido_contacto`, `telefono`, `fax`, `linea_direccion1`, `linea_direccion2`, `ciudad`, `region`, `pais`, `codigo_postal`, `codigo_empleado_rep_ventas`, `limite_credito`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stm = conBD.prepareStatement(sql);
                    ultimoCodigo = ultimoCodigo + 1;
                    
                    //sacamos todos los datos del formulario para meterlos en la base de datos
                    
                    stm.setInt(1, ultimoCodigo);
                    stm.setString(2, jTextFieldNombreCli.getText());
                    stm.setString(3, jTextFieldNombreCont.getText());
                    stm.setString(4, jTextFieldApellidoCont.getText());
                    stm.setString(5, jTextFieldTelefonoCli.getText());
                    stm.setString(6, jTextFieldFaxCli.getText());
                    stm.setString(7, jTextFieldDireccion1Cli.getText());
                    stm.setString(8, jTextFieldDireccion2Cli.getText());
                    stm.setString(9, jTextFieldCiudadCli.getText());
                    stm.setString(10, jTextFieldRegionCli.getText());
                    stm.setString(11, jTextFieldPaisCli.getText());
                    stm.setString(12, jTextFieldCodPostalCli.getText());
                    stm.setInt(13, Integer.parseInt(jTextFieldCodigoEmpleado.getText()));
                    stm.setDouble(14, Double.parseDouble(jTextFieldLimite_credito.getText()));
                    stm.executeQuery();
                    
                    
                    
                    JOptionPane.showMessageDialog(this, "Cliente creado con exito.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                   System.out.println("mal " + ex.getMessage());
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "El campo (Codigo empleado) o el campo (Limite Credito) no tiene el formato correcto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_jButtonAltaCliActionPerformed

    private void jTextFieldCodigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoEmpleadoActionPerformed

    private void jButtonFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFicheroActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButtonFicheroActionPerformed

    private void jButtonActualizacionCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizacionCliActionPerformed
        
        
    }//GEN-LAST:event_jButtonActualizacionCliActionPerformed

    private void jButtonBuscarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCliActionPerformed
        try {
            String opciones[] = {"Por nombre", "Por telefono", "Por codigo"};
            int eleccion = 0, codigo = 0;
            String telefono, nombre;
            PreparedStatement stm;
            //primero miramos la manera de buscar el cliente
            
            eleccion = JOptionPane.showOptionDialog(this, "Indica la forma de buscar un cliente", "Busqueda de los clientes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            switch (eleccion) {
                case 0:
                    nombre = JOptionPane.showInputDialog(this,"Introduce el nombre del cliente");
                    
                    //una vez tenemos el nombre lo buscamos en la base de datos
                    
                    sql = "select * from cliente where nombre_cliente like ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setString(1, nombre);
                    
                    //mostramos los datos del clientes que buscamos
                    
                    consulta = stm.executeQuery();
                    
                    cargarDatos(consulta);
                    break;
                case 1:
                    telefono = JOptionPane.showInputDialog(this,"Introduce el telefono del cliente");
                    
                    //una vez tenemos el nombre lo buscamos en la base de datos
                    
                    sql = "select * from cliente where telefono like ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setString(1, telefono);
                    
                    //mostramos los datos del clientes que buscamos
                    
                    consulta = stm.executeQuery();
                    cargarDatos(consulta);
                    break;
                case 2:
                    telefono = JOptionPane.showInputDialog(this,"Introduce el codigo del cliente");
                    
                    //una vez tenemos el nombre lo buscamos en la base de datos
                    
                    sql = "select * from cliente where codigo_cliente = ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setString(1, telefono);
                    
                    //mostramos los datos del clientes que buscamos
                    
                    consulta = stm.executeQuery();
                    cargarDatos(consulta);
                    break;
                    
                default:            
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBuscarCliActionPerformed

    private void jButtonBajaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaCliActionPerformed

    }//GEN-LAST:event_jButtonBajaCliActionPerformed

    private void jTextFieldCodigoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoCliActionPerformed

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
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizacionCli;
    private javax.swing.JButton jButtonAltaCli;
    private javax.swing.JButton jButtonBajaCli;
    private javax.swing.JButton jButtonBuscarCli;
    private javax.swing.JButton jButtonFichero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldApellidoCont;
    private javax.swing.JTextField jTextFieldCiudadCli;
    private javax.swing.JTextField jTextFieldCodPostalCli;
    private javax.swing.JTextField jTextFieldCodigoCli;
    private javax.swing.JTextField jTextFieldCodigoEmpleado;
    private javax.swing.JTextField jTextFieldDireccion1Cli;
    private javax.swing.JTextField jTextFieldDireccion2Cli;
    private javax.swing.JTextField jTextFieldFaxCli;
    private javax.swing.JTextField jTextFieldLimite_credito;
    private javax.swing.JTextField jTextFieldNombreCli;
    private javax.swing.JTextField jTextFieldNombreCont;
    private javax.swing.JTextField jTextFieldPaisCli;
    private javax.swing.JTextField jTextFieldRegionCli;
    private javax.swing.JTextField jTextFieldTelefonoCli;
    // End of variables declaration//GEN-END:variables

}
