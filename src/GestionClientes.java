
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
    
    public boolean campoCodigoCorrecto(){
        int codigoEmpleado = 0;
        boolean numericosBien = true;
        
        if (jTextFieldCodigoEmpleado.getText().equals("") == false) {
            try {
                codigoEmpleado = Integer.parseInt(jTextFieldCodigoEmpleado.getText());
            } catch (Exception e) {
                numericosBien = false;
            }
        }
        
        return numericosBien;
    }
    
    public boolean campoLimite(){
        double limiteCredito = 0;
        boolean numericosBien = true;
        
        if (jTextFieldLimite_credito.getText().equals("") == false) {       
            try {
                limiteCredito = Double.parseDouble(jTextFieldLimite_credito.getText());
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
    
    public void limpiarDatos(){    
        jTextFieldCodigoCli.setText("");
        jTextFieldNombreCli.setText("");
        jTextFieldNombreCont.setText("");
        jTextFieldApellidoCont.setText("");
        jTextFieldTelefonoCli.setText("");
        jTextFieldFaxCli.setText("");
        jTextFieldDireccion1Cli.setText("");
        jTextFieldDireccion2Cli.setText("");
        jTextFieldCiudadCli.setText("");
        jTextFieldRegionCli.setText("");
        jTextFieldPaisCli.setText("");
        jTextFieldCodPostalCli.setText("");
        jTextFieldCodigoEmpleado.setText("");
        jTextFieldLimite_credito.setText("");
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
    
    public String toString(ArrayList array) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        
        for (int i = 0; i < array.size(); i++) {
            if (i > 0) {
                sb.append("");
            }
            sb.append(array.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelcodigoCli = new javax.swing.JLabel();
        jLabelNombreCli = new javax.swing.JLabel();
        jLabelNombreContacto = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldCodigoCli = new javax.swing.JTextField();
        jTextFieldNombreCli = new javax.swing.JTextField();
        jTextFieldNombreCont = new javax.swing.JTextField();
        jLabelApellidoContacto = new javax.swing.JLabel();
        jTextFieldApellidoCont = new javax.swing.JTextField();
        jTextFieldTelefonoCli = new javax.swing.JTextField();
        jLabelFax = new javax.swing.JLabel();
        jTextFieldFaxCli = new javax.swing.JTextField();
        jLabelDirreccion1 = new javax.swing.JLabel();
        jTextFieldDireccion1Cli = new javax.swing.JTextField();
        jLabelDirreccion2 = new javax.swing.JLabel();
        jTextFieldDireccion2Cli = new javax.swing.JTextField();
        jLabelRegion = new javax.swing.JLabel();
        jTextFieldRegionCli = new javax.swing.JTextField();
        jLabelpais = new javax.swing.JLabel();
        jLabelCP = new javax.swing.JLabel();
        jTextFieldPaisCli = new javax.swing.JTextField();
        jTextFieldCodPostalCli = new javax.swing.JTextField();
        jLabelLimiteCredito = new javax.swing.JLabel();
        jTextFieldCodigoEmpleado = new javax.swing.JTextField();
        jTextFieldLimite_credito = new javax.swing.JTextField();
        jLabelCiudad = new javax.swing.JLabel();
        jLabelCodigoEmpleado = new javax.swing.JLabel();
        jTextFieldCiudadCli = new javax.swing.JTextField();
        jLabelDatos = new javax.swing.JLabel();
        jButtonActualizacionCli = new javax.swing.JButton();
        jButtonBuscarCli = new javax.swing.JButton();
        jButtonAltaCli = new javax.swing.JButton();
        jButtonBajaCli = new javax.swing.JButton();
        jButtonFichero = new javax.swing.JButton();
        jButtonCambiarLimite = new javax.swing.JButton();
        jButtonAsignarEmpleado = new javax.swing.JButton();
        jButtonMostrarClientes = new javax.swing.JButton();
        jButtonPagos = new javax.swing.JButton();

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

        jLabelcodigoCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelcodigoCli.setForeground(new java.awt.Color(255, 255, 255));
        jLabelcodigoCli.setText("Codigo Cliente.");

        jLabelNombreCli.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombreCli.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreCli.setText("Nombre Cliente. *");

        jLabelNombreContacto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelNombreContacto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombreContacto.setText("Nombre Contacto.");

        jLabelTelefono.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Telefono. *");

        jTextFieldCodigoCli.setEnabled(false);
        jTextFieldCodigoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoCliActionPerformed(evt);
            }
        });

        jLabelApellidoContacto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelApellidoContacto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellidoContacto.setText("Apellido Contacto.");

        jLabelFax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFax.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFax.setText("Fax. *");

        jLabelDirreccion1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDirreccion1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDirreccion1.setText("Direccion 1. *");

        jLabelDirreccion2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelDirreccion2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDirreccion2.setText("Direccion 2.");

        jLabelRegion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelRegion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRegion.setText("Region");

        jLabelpais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelpais.setForeground(new java.awt.Color(255, 255, 255));
        jLabelpais.setText("Pais.");

        jLabelCP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCP.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCP.setText("Codigo postal.");

        jLabelLimiteCredito.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLimiteCredito.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLimiteCredito.setText("Limite_credito.");

        jTextFieldCodigoEmpleado.setEnabled(false);
        jTextFieldCodigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoEmpleadoActionPerformed(evt);
            }
        });

        jLabelCiudad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCiudad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCiudad.setText("Ciudad. *");

        jLabelCodigoEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelCodigoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCodigoEmpleado.setText("Codigo empleado ventas.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelcodigoCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelNombreContacto, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                        .addComponent(jLabelTelefono)
                                        .addComponent(jLabelDirreccion1)
                                        .addComponent(jTextFieldCodigoCli)
                                        .addComponent(jTextFieldNombreCont)
                                        .addComponent(jTextFieldTelefonoCli))
                                    .addComponent(jTextFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(114, 114, 114))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelCodigoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFax)
                            .addComponent(jLabelApellidoContacto)
                            .addComponent(jLabelLimiteCredito)
                            .addComponent(jTextFieldDireccion2Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDirreccion2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldLimite_credito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                .addComponent(jTextFieldFaxCli, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldApellidoCont, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldNombreCli, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabelNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldDireccion1Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelpais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPaisCli)
                    .addComponent(jTextFieldCodPostalCli)
                    .addComponent(jTextFieldCiudadCli)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRegion)
                            .addComponent(jLabelCP)
                            .addComponent(jLabelCiudad)
                            .addComponent(jTextFieldRegionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelpais)
                    .addComponent(jLabelNombreCli)
                    .addComponent(jLabelcodigoCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombreCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPaisCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidoContacto)
                    .addComponent(jLabelNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCiudad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNombreCont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidoCont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCiudadCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jLabelFax)
                    .addComponent(jLabelCP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldFaxCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldCodPostalCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldTelefonoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRegion)
                    .addComponent(jLabelLimiteCredito)
                    .addComponent(jLabelCodigoEmpleado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRegionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLimite_credito, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirreccion1)
                    .addComponent(jLabelDirreccion2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDireccion1Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccion2Cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabelDatos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDatos.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDatos.setText("Datos.");

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

        jButtonCambiarLimite.setBackground(new java.awt.Color(51, 0, 153));
        jButtonCambiarLimite.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCambiarLimite.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCambiarLimite.setText("Modificar limite credito");
        jButtonCambiarLimite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCambiarLimiteActionPerformed(evt);
            }
        });

        jButtonAsignarEmpleado.setBackground(new java.awt.Color(51, 0, 153));
        jButtonAsignarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonAsignarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAsignarEmpleado.setText("Asignar empleado de ventas");
        jButtonAsignarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarEmpleadoActionPerformed(evt);
            }
        });

        jButtonMostrarClientes.setBackground(new java.awt.Color(51, 0, 153));
        jButtonMostrarClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonMostrarClientes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonMostrarClientes.setText("Generar listado de los clientes");
        jButtonMostrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarClientesActionPerformed(evt);
            }
        });

        jButtonPagos.setBackground(new java.awt.Color(51, 0, 153));
        jButtonPagos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonPagos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPagos.setText("Realizar Pagos");
        jButtonPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagosActionPerformed(evt);
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
                            .addComponent(jButtonFichero)
                            .addComponent(jButtonCambiarLimite)
                            .addComponent(jButtonAsignarEmpleado)
                            .addComponent(jButtonMostrarClientes)
                            .addComponent(jButtonPagos))
                        .addGap(140, 140, 140))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelDatos)
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
                        .addComponent(jLabelDatos)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAltaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBajaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonActualizacionCli, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCambiarLimite, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAsignarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMostrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
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
                    
                    sql = "INSERT INTO `cliente` (`codigo_cliente`, `nombre_cliente`, `nombre_contacto`, `apellido_contacto`, `telefono`, `fax`, `linea_direccion1`, `linea_direccion2`, `ciudad`, `region`, `pais`, `codigo_postal`, `limite_credito`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
                    stm.setDouble(13, Double.parseDouble(jTextFieldLimite_credito.getText()));
                    stm.executeUpdate();
                    
                    JOptionPane.showMessageDialog(this, "Cliente creado con exito.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    
                    limpiarDatos();
                    
                } catch (Exception ex) {
                   System.out.println("mal " + ex.getMessage());
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "El campo (Codigo empleado) o el campo (Limite Credito) no tiene el formato correcto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_jButtonAltaCliActionPerformed

    private void jButtonFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFicheroActionPerformed
        
        //mostramos la venta del fichero y guardamos clientes
        
        FacturacionClientes fact = new FacturacionClientes();
        fact.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonFicheroActionPerformed

    private void jButtonActualizacionCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizacionCliActionPerformed

        //lo primero comprobamos que los campos obligatorios estan puestos
        
        if(camposObligatorios() == false){
            JOptionPane.showMessageDialog(this, "Los campos (*) obligatorios no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            //despues si ponen alguno de los campos numericos que no son obligatorios comprovamos que sean numeros
            
            if(campoCodigoCorrecto() == true){
                
                //en caso se que este todo correcto actualizamos el cliente en cuestion
                
                try {
                    //un update mas lago que dia sin pan 
                    
                    sql = "UPDATE cliente SET nombre_cliente = ?, nombre_contacto = ?, apellido_contacto = ?, telefono = ?, fax = ?, linea_direccion1 = ?, linea_direccion2 = ?, ciudad = ?, region = ?, pais = ?, codigo_postal = ? WHERE (codigo_cliente = ?);";
                    PreparedStatement stm = conBD.prepareStatement(sql);
                    
                    //sacamos todos los datos del formulario para meterlos en la base de datos
                    
                    stm.setString(1, jTextFieldNombreCli.getText());
                    stm.setString(2, jTextFieldNombreCont.getText());
                    stm.setString(3, jTextFieldApellidoCont.getText());
                    stm.setString(4, jTextFieldTelefonoCli.getText());
                    stm.setString(5, jTextFieldFaxCli.getText());
                    stm.setString(6, jTextFieldDireccion1Cli.getText());
                    stm.setString(7, jTextFieldDireccion2Cli.getText());
                    stm.setString(8, jTextFieldCiudadCli.getText());
                    stm.setString(9, jTextFieldRegionCli.getText());
                    stm.setString(10, jTextFieldPaisCli.getText());
                    stm.setString(11, jTextFieldCodPostalCli.getText());
                    stm.setInt(12,Integer.parseInt(jTextFieldCodigoCli.getText()) );
                    stm.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Cliente actualizado con exito.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    
                    //con esto dejamos los campos vacios para poder trabajar de otras formas
                    
                    limpiarDatos();
                    
                } catch (Exception ex) {
                   System.out.println("mal " + ex.getMessage());
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "El campo (Codigo empleado) no tiene el formato correcto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }    
    }//GEN-LAST:event_jButtonActualizacionCliActionPerformed

    private void jButtonBuscarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarCliActionPerformed
        try {
            String opciones[] = {"Por nombre", "Por telefono", "Por codigo"};
            int eleccion = 0, codigo = 0;
            String telefono, nombre;
            PreparedStatement stm;
            
            //primero miramos la manera de buscar el cliente
            
            eleccion = JOptionPane.showOptionDialog(this, "Indica la forma de buscar un cliente", "Busqueda de los clientes", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, 0);
            
            //segun nuestra elecion buscamos el cliente en la base de datos
            
            switch (eleccion) {
                case 0:
                    nombre = JOptionPane.showInputDialog(this,"Introduce el nombre del cliente");
                    
                    //una vez tenemos el nombre lo buscamos en la base de datos
                    
                    sql = "select * from cliente where nombre_cliente like ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setString(1, nombre);
                    
                    //comprobamos que el cliente existe y si esta lo mostramos
                    
                    consulta = stm.executeQuery();
                    if (consulta.next()) {
                        consulta = stm.executeQuery();
                        cargarDatos(consulta);
                    } else {
                        JOptionPane.showMessageDialog(this, "no se tiene ningun cliente con ese nombre", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    break;
                case 1:
                    telefono = JOptionPane.showInputDialog(this,"Introduce el telefono del cliente");
                    
                    //una vez tenemos el nombre lo buscamos en la base de datos
                    
                    sql = "select * from cliente where telefono like ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setString(1, telefono);
                    
                    //comprobamos que el cliente existe y si esta lo mostramos
                    
                    consulta = stm.executeQuery();
                    if (consulta.next()) {
                        consulta = stm.executeQuery();
                        cargarDatos(consulta);
                    } else {
                        JOptionPane.showMessageDialog(this, "no se tiene ningun cliente con ese telefono", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog(this,"Introduce el codigo del cliente"));
                    
                    //una vez tenemos el nombre lo buscamos en la base de datos
                    
                    sql = "select * from cliente where codigo_cliente = ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setInt(1, codigo);
                    
                    //comprobamos que el clinte que se busca existe en la base de datos
                    
                    consulta = stm.executeQuery();
                    if (consulta.next()) {
                        
                        //en el caso de exista lo mostramos
                        
                        consulta = stm.executeQuery();
                        cargarDatos(consulta);
                    } else {
                        JOptionPane.showMessageDialog(this, "no se tiene ningun cliente con ese codigo", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                    
                default:            
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBuscarCliActionPerformed

    private void jButtonBajaCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBajaCliActionPerformed
        try {
            String opciones[] = {"Si", "No"};
            int eleccion = 0;   
            PreparedStatement stm;
            
            //preguntamos si el cliente que desea eliminar es el que se esta actualmente cargado en los datos

            eleccion = JOptionPane.showOptionDialog(this, "Desea eliminar el cliente mostrado actualmente", "eliminar un cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, 0);

            switch (eleccion) {
                case 0:
                    
                    //ahora comprobamos que se tiene constancia de un cliente
                    
                    if(jTextFieldCodigoCli.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this, "no se tiene constancia de ningun cliente el los datos", "error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        
                        //en caso de querer que este sea el cliente a eliminar debemos comprobar que no tenga pagos y para eso comprobamos el codigo en los pagos
                        
                        int clienteActual = Integer.parseInt(jTextFieldCodigoCli.getText());
                        sql = "select * from pago where codigo_cliente = ?";
                        stm = conBD.prepareStatement(sql);                   
                        stm.setInt(1, clienteActual);
                        consulta = stm.executeQuery();
                        
                        if(consulta.next()) {
                          JOptionPane.showMessageDialog(this, "este cliente no se puede borrar debido a que esta ligado a otras tablas", "error",JOptionPane.ERROR_MESSAGE);
                        }else{
                            
                            //si no ha realizado ningun pago ya podemos realizar el borrado
                            
                            sql = "DELETE FROM cliente WHERE (codigo_cliente = ?);";
                            stm = conBD.prepareStatement(sql);
                            stm.setInt(1, Integer.parseInt(jTextFieldCodigoCli.getText()));
                            stm.executeUpdate();
                            
                            //por ultimo mostramos un mensaje de informacion
                            
                            JOptionPane.showMessageDialog(this, "Cliente eliminado con exito.", "Info", JOptionPane.INFORMATION_MESSAGE);
                            
                            limpiarDatos();
                        }
                    }
                    
                    break;
                case 1:
                    JOptionPane.showMessageDialog(this, "En ese caso puede buscar otro cliente desde el boton (Buscar Cliente)");
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBajaCliActionPerformed

    private void jTextFieldCodigoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoCliActionPerformed

    private void jTextFieldCodigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoEmpleadoActionPerformed
        
    }//GEN-LAST:event_jTextFieldCodigoEmpleadoActionPerformed

    private void jButtonCambiarLimiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCambiarLimiteActionPerformed
        
        //lo primero es comprobar si se tiene un cliente para hacer la operacion
        
        if(jTextFieldCodigoCli.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "no se tiene constancia de ningun cliente el los datos", "error", JOptionPane.ERROR_MESSAGE);
        }else {
            
            //una vez se tiene el cliente solo hacemos un update mas pequeño para solo cambiar el limite de credito
            
            Double nuevoLimite = Double.parseDouble(JOptionPane.showInputDialog(this, "Indica el limite nuevo del cliente actual"));
            try {

                sql = "UPDATE cliente SET limite_credito = ? WHERE (codigo_cliente = ?);";
                PreparedStatement stm = conBD.prepareStatement(sql);

                stm.setDouble(1, nuevoLimite);
                stm.setInt(2, Integer.parseInt(jTextFieldCodigoCli.getText()));
                stm.executeUpdate();

                JOptionPane.showMessageDialog(this, "Limite del cliente actualizado con exito.", "Info", JOptionPane.INFORMATION_MESSAGE);        
                limpiarDatos();

            } catch (Exception ex) {
               System.out.println("mal " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonCambiarLimiteActionPerformed

    private void jButtonAsignarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarEmpleadoActionPerformed
        try {                                                       
            stmt = conBD.createStatement();
            ArrayList<String> empleados = new ArrayList<>();
            boolean empCorrecto = false;
            PreparedStatement stm;
            
            //primero tenemos que sacar todos nombres de los empleados
        
            sql = "select codigo_empleado, nombre from empleado where puesto like 'Representante Ventas'";
            consulta = stmt.executeQuery(sql);

            while (consulta.next()) {
                empleados.add(consulta.getInt("codigo_empleado") + " " + consulta.getString("nombre"));
            }

            //tenemos que tener un cliente el los datos cargados
            
            if(jTextFieldCodigoCli.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "no se tiene constancia de ningun cliente el los datos", "error", JOptionPane.ERROR_MESSAGE);
            }else {
                
                //hacemos un bucle para en caso de poner un numero de un empleado correcto pedirlo otra vez
                
                do {                    
                    int resultado = Integer.parseInt(JOptionPane.showInputDialog(this, "Indica el numero representante de ventas que le corrresponda: \n" + toString(empleados)));
                    sql = "select * from cliente where codigo_cliente like ?";
                    stm = conBD.prepareStatement(sql);                   
                    stm.setInt(1, resultado);
                    consulta = stm.executeQuery();
                    
                    //hacfemos un bucle que pide el codigo y si lo pide mal se repite
                    
                    if (consulta.next()) {
                        
                        sql = "UPDATE Cliente SET codigo_empleado_rep_ventas = ? WHERE (codigo_cliente = ?);";  
                        stm = conBD.prepareStatement(sql);
                        stm.setInt(1, resultado);
                        stm.setInt(2, Integer.parseInt(jTextFieldCodigoCli.getText()));
                        stm.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Empleado asignado con exito.", "Info", JOptionPane.INFORMATION_MESSAGE);        
                        limpiarDatos();
                        empCorrecto = true;
                    } else {
                        JOptionPane.showMessageDialog(this, "No se tiene consta de ningun empleado con ese numero asignado por favor intentelo de nuevo", "error", JOptionPane.ERROR_MESSAGE);
                    }
                } while (empCorrecto == false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAsignarEmpleadoActionPerformed

    private void jButtonMostrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarClientesActionPerformed
        //pasamos de clientes a la tabla de todos los clientes
        
        TablaClientes tabla = new TablaClientes();
        tabla.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonMostrarClientesActionPerformed

    private void jButtonPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagosActionPerformed
        // boton para pasar de clientes a pagos
        Pagos pago = new Pagos();
        pago.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonPagosActionPerformed

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
    private javax.swing.JButton jButtonAsignarEmpleado;
    private javax.swing.JButton jButtonBajaCli;
    private javax.swing.JButton jButtonBuscarCli;
    private javax.swing.JButton jButtonCambiarLimite;
    private javax.swing.JButton jButtonFichero;
    private javax.swing.JButton jButtonMostrarClientes;
    private javax.swing.JButton jButtonPagos;
    private javax.swing.JLabel jLabelApellidoContacto;
    private javax.swing.JLabel jLabelCP;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelCodigoEmpleado;
    private javax.swing.JLabel jLabelDatos;
    private javax.swing.JLabel jLabelDirreccion1;
    private javax.swing.JLabel jLabelDirreccion2;
    private javax.swing.JLabel jLabelFax;
    private javax.swing.JLabel jLabelLimiteCredito;
    private javax.swing.JLabel jLabelNombreCli;
    private javax.swing.JLabel jLabelNombreContacto;
    private javax.swing.JLabel jLabelRegion;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelcodigoCli;
    private javax.swing.JLabel jLabelpais;
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
