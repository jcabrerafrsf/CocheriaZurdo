/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adherente;

import socio.ConsultaSocios;
import cocheriazurdo.Fecha_Hora;
import cocheriazurdo.conectar;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import socio.AltaSocioYAdhExito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socio.OpcionesSocio;

/**
 *
 * @author juani
 */
public class AltaAdherente extends javax.swing.JFrame {
    int cantidadadh;
    int cantidadadhF;
    int nro_del_socio;
    int cantadh;
    int cantsc;
    int codigo_tarifa;
    Boolean flag;
    private Point clic;
    
    public AltaAdherente() {
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
    }
    
    public AltaAdherente(int nro_adh, int nro_socio) {
        cantidadadh = nro_adh;
        cantidadadhF = nro_adh;
        nro_del_socio = nro_socio;
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
    }
    
    public String getSexo(){
        int varsexo = this.jsexo.getSelectedIndex();
        if(varsexo==0){
            return "MASCULINO";
        }
        else{
            if(varsexo==1){
                return "FEMENINO";
            }
            else{
               if(varsexo==2){
                return "INDEFINIDO";
                }
                else{
                return "NO ESPECIFICADO";
                } 
            }
        }       
    }
    
    public void fechaSistema(){
        
        Fecha_Hora fechaSys = new Fecha_Hora();
        this.jfechaalta.setText(fechaSys.obtenerFechaSystem());
        Date fecha = null;
        Date fecha2 = null;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
        fecha = formatoDelTexto.parse(jfechanac.getText());
        fecha2 = formatoDelTexto.parse(jfechaalta.getText());
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }   
        
        //seteo la edad y la fecha de cobertura
        
        this.jedad.setText(fechaSys.getEdad(fecha));
        this.jfechacobertura.setText(fechaSys.getFechaCobertura(fecha,fecha2));
    }
    
    public void cargarDatos(){
        
        
        cantidadadh--;
                   
        try{
        PreparedStatement pst = cn.prepareStatement("INSERT INTO bdcocheriazurdo.adherentes VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(nro_adherente) FROM bdcocheriazurdo.adherentes");
            rs.last();
            cantadh = rs.getInt("MAX(nro_adherente)");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
            }        
            
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(nro_socio) FROM bdcocheriazurdo.socios");
            rs.last();
            cantsc = rs.getInt("MAX(nro_socio)");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
            }     
            
            try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(nro_socio), codigo_tarifa FROM bdcocheriazurdo.socios");
            rs.last();
            codigo_tarifa = rs.getInt("codigo_tarifa");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            pst.setInt(1,cantadh+1);
            pst.setInt(2, this.nro_del_socio);
            pst.setString(3, this.japellido.getText().toUpperCase());
            pst.setString(4, this.jnombre.getText().toUpperCase());
            pst.setString(5, this.jdni.getText().toUpperCase());
            pst.setString(6, this.jdireccion.getText().toUpperCase());
            pst.setString(7, this.jtelefono.getText().toUpperCase());
            pst.setString(8, getSexo());        
            pst.setString(9, this.jfechanac.getText());
            pst.setString(10, this.jfechaalta.getText());
            pst.setString(11, this.jfechacobertura.getText());
            pst.setDouble(12, this.codigo_tarifa);
            pst.setString(13, "ALTA");
            pst.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion o DNI duplicado - "+e.getMessage());
        }
        
        //PREGUNTA SI EXISTE ALGÚN ADH MAS PARA CARGAR
        if(cantidadadh!=0){
            AltaAdherente AH1 = new AltaAdherente(cantidadadh, nro_del_socio);
            this.dispose();            
        }else{
            AltaSocioYAdhExito AUE = new AltaSocioYAdhExito();
            this.dispose();     
        }
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jnrosocio = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        japellido = new javax.swing.JTextField();
        jnombre = new javax.swing.JTextField();
        jdireccion = new javax.swing.JTextField();
        jsexo = new javax.swing.JComboBox<>();
        jedad = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        CONTINUAR = new javax.swing.JButton();
        j1deN = new javax.swing.JLabel();
        j1den = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jdni = new javax.swing.JFormattedTextField();
        jtelefono = new javax.swing.JTextField();
        jfechanac = new javax.swing.JTextField();
        jfechacobertura = new javax.swing.JTextField();
        jfechaalta = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ALTA DE NUEVO SOCIO TITULAR");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 64, 70));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("ALTA DE ADHERENTES");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/usuario.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NUMERO DE SOCIO:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("APELLIDO:");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DNI:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DIRECCION:");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("TELEFONO:");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("SEXO:");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FECHA DE NACIMIENTO:");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("FECHA ALTA:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("EDAD:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("FECHA COBERTURA:");

        jnrosocio.setEditable(false);
        jnrosocio.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jnrosocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jnrosocioFocusGained(evt);
            }
        });
        jnrosocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnrosocioActionPerformed(evt);
            }
        });

        japellido.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jnombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jdireccion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jsexo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "I" }));

        jedad.setEditable(false);
        jedad.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jedad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jedadFocusGained(evt);
            }
        });

        CONTINUAR.setBackground(new java.awt.Color(153, 255, 153));
        CONTINUAR.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        CONTINUAR.setText("CONTINUAR");
        CONTINUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONTINUARActionPerformed(evt);
            }
        });

        j1den.setBackground(new java.awt.Color(55, 64, 70));
        j1den.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        j1den.setForeground(new java.awt.Color(255, 255, 255));
        j1den.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Adherente por cargar:");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close-circular-button-of-a-cross (1).png"))); // NOI18N
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/minus-sign-in-a-circle (1).png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });

        jdni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jdni.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdniKeyTyped(evt);
            }
        });

        jtelefono.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtelefonoKeyTyped(evt);
            }
        });

        jfechanac.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jfechanac.setText("dd/mm/aaaa");
        jfechanac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jfechanacFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jfechanacFocusLost(evt);
            }
        });
        jfechanac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jfechanacKeyTyped(evt);
            }
        });

        jfechacobertura.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jfechacobertura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jfechacoberturaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jfechacoberturaFocusLost(evt);
            }
        });
        jfechacobertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jfechacoberturaKeyTyped(evt);
            }
        });

        jfechaalta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jfechaalta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jfechaaltaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jfechaaltaFocusLost(evt);
            }
        });
        jfechaalta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jfechaaltaKeyTyped(evt);
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
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(j1den, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CONTINUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j1deN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jedad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jfechaalta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jfechacobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jnrosocio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(japellido, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtelefono))
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jnrosocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(japellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jfechacobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jfechaalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(j1den, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CONTINUAR))
                .addGap(152, 152, 152)
                .addComponent(j1deN))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jedadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jedadFocusGained
        fechaSistema();
    }//GEN-LAST:event_jedadFocusGained

    private void CONTINUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONTINUARActionPerformed
       
        cargarDatos();       
       
    }//GEN-LAST:event_CONTINUARActionPerformed

    private void jnrosocioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnrosocioFocusGained
        System.out.println(nro_del_socio);
        if(this.nro_del_socio == 0){
            jnrosocio.setText("ERROR AL ENCONTRAR EL SOCIO");
        }
        else{
          String nrosc = Integer.toString(nro_del_socio);
          jnrosocio.setText(nrosc);  
          //txtfield para mostrar la cant de socios a cargar
          String ScantAdh = Integer.toString(cantidadadh);
          j1den.setText(ScantAdh);
        }
    }//GEN-LAST:event_jnrosocioFocusGained

    private void jnrosocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnrosocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnrosocioActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        int seleccion = JOptionPane.showConfirmDialog(null, "Realmente desea salir del sistema?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion==0){
           System.exit(0); 
        }else{   
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdniKeyTyped
        
    }//GEN-LAST:event_jdniKeyTyped

    private void jtelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtelefonoKeyTyped
        if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            int cont = jtelefono.getText().length();
            if (cont>=10){
                if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)
                cont--;
                else
                evt.consume();
            }
            else{
                if (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE){
                    if (cont>0)
                    cont--;
                }
                else
                cont++;
            }
        }
        else
        evt.consume();
    }//GEN-LAST:event_jtelefonoKeyTyped

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        clic = evt.getPoint();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // get location of Window
        int thisX = this.getLocation().x;
        int thisY = this.getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = (thisX + evt.getX()) - (thisX + clic.x);
        int yMoved = (thisY + evt.getY()) - (thisY + clic.y);

        // Move window to this position
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jfechanacFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechanacFocusGained
        if (this.jfechanac.getText().equals("dd/mm/aaaa")){
            this.jfechanac.setText("");
        }
    }//GEN-LAST:event_jfechanacFocusGained

    private void jfechanacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechanacFocusLost
        if (this.jfechanac.getText().isEmpty()){
            this.jfechanac.setText("dd/mm/aaaa");
        }else{
            if(jfechanac.getText().length()==10 && jfechanac.getText().charAt(2)==47 && jfechanac.getText().charAt(5)==47){
                fechaSistema();
            }else{
                String fechanacAux=jfechanac.getText();
                if(fechanacAux.length()==8 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(3)==47){
                    jfechanac.setText('0' + fechanacAux.substring(0, 2) + '0' + fechanacAux.substring(2, fechanacAux.length()));
                    fechaSistema();
                }else{
                    if (fechanacAux.length()==9 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(4)==47){
                        jfechanac.setText('0' + fechanacAux.substring(0, fechanacAux.length()));
                        fechaSistema();
                    }else{
                        if(fechanacAux.length()==9 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(4)==47){
                            jfechanac.setText(fechanacAux.substring(0, 3) + '0' + fechanacAux.substring(3, fechanacAux.length()));
                            fechaSistema();
                        }else{
                            //PARA AÑOS DE DOS DIGITOS
                            if(fechanacAux.length()==6 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(3)==47){
                                String año = this.añoDeCuatroDigitos(fechanacAux.substring(4,6));
                                jfechanac.setText('0' + fechanacAux.substring(0, 2) + '0' + fechanacAux.substring(2, 4) + año);
                                fechaSistema();
                            }else{
                                if(fechanacAux.length()==7 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(4)==47){
                                    String año = this.añoDeCuatroDigitos(fechanacAux.substring(5,7));
                                    jfechanac.setText('0' + fechanacAux.substring(0, 5) + año);
                                    fechaSistema();
                                }else{
                                    if(fechanacAux.length()==7 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(4)==47){
                                        String año = this.añoDeCuatroDigitos(fechanacAux.substring(5,7));
                                        jfechanac.setText(fechanacAux.substring(0, 3) + '0' + fechanacAux.substring(3,5) + año);
                                        fechaSistema();
                                    }else{
                                        if(fechanacAux.length()==8 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(5)==47){
                                            String año = this.añoDeCuatroDigitos(fechanacAux.substring(6,8));
                                            jfechanac.setText(fechanacAux.substring(0, 6) + año);
                                            fechaSistema();
                                        }else{
                                            jfechanac.setText("");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jfechanacFocusLost

    private void jfechanacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfechanacKeyTyped
        if (!((evt.getKeyChar()>=48 && evt.getKeyChar()<=57) || evt.getKeyChar()==KeyEvent.VK_SLASH)){
            evt.consume();
        }
    }//GEN-LAST:event_jfechanacKeyTyped

    private void jfechacoberturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechacoberturaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jfechacoberturaFocusGained

    private void jfechacoberturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechacoberturaFocusLost
        if (this.jfechacobertura.getText().isEmpty()){
            
        }else{
            if(jfechacobertura.getText().length()==10 && jfechacobertura.getText().charAt(2)==47 && jfechacobertura.getText().charAt(5)==47){

            }else{
                String fechanacAux=jfechacobertura.getText();
                if(fechanacAux.length()==8 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(3)==47){
                    jfechacobertura.setText('0' + fechanacAux.substring(0, 2) + '0' + fechanacAux.substring(2, fechanacAux.length()));
                }else{
                    if (fechanacAux.length()==9 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(4)==47){
                        jfechacobertura.setText('0' + fechanacAux.substring(0, fechanacAux.length()));
                    }else{
                        if(fechanacAux.length()==9 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(4)==47){
                            jfechacobertura.setText(fechanacAux.substring(0, 3) + '0' + fechanacAux.substring(3, fechanacAux.length()));
                        }else{
                            //PARA AÑOS DE DOS DIGITOS
                            if(fechanacAux.length()==6 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(3)==47){
                                String año = this.añoDeCuatroDigitos(fechanacAux.substring(4,6));
                                jfechacobertura.setText('0' + fechanacAux.substring(0, 2) + '0' + fechanacAux.substring(2, 4) + año);
                            }else{
                                if(fechanacAux.length()==7 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(4)==47){
                                    String año = this.añoDeCuatroDigitos(fechanacAux.substring(5,7));
                                    jfechacobertura.setText('0' + fechanacAux.substring(0, 5) + año);
                                }else{
                                    if(fechanacAux.length()==7 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(4)==47){
                                        String año = this.añoDeCuatroDigitos(fechanacAux.substring(5,7));
                                        jfechacobertura.setText(fechanacAux.substring(0, 3) + '0' + fechanacAux.substring(3,5) + año);
                                    }else{
                                        if(fechanacAux.length()==8 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(5)==47){
                                            String año = this.añoDeCuatroDigitos(fechanacAux.substring(6,8));
                                            jfechacobertura.setText(fechanacAux.substring(0, 6) + año);
                                        }else{
                                            jfechacobertura.setText("");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jfechacoberturaFocusLost

    private void jfechacoberturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfechacoberturaKeyTyped
        if (!((evt.getKeyChar()>=48 && evt.getKeyChar()<=57) || evt.getKeyChar()==KeyEvent.VK_SLASH)){
            evt.consume();
        }
    }//GEN-LAST:event_jfechacoberturaKeyTyped

    private void jfechaaltaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechaaltaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jfechaaltaFocusGained

    private void jfechaaltaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechaaltaFocusLost
        if (this.jfechaalta.getText().isEmpty()){
            
        }else{
            if(jfechaalta.getText().length()==10 && jfechaalta.getText().charAt(2)==47 && jfechaalta.getText().charAt(5)==47){

            }else{
                String fechanacAux=jfechaalta.getText();
                if(fechanacAux.length()==8 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(3)==47){
                    jfechaalta.setText('0' + fechanacAux.substring(0, 2) + '0' + fechanacAux.substring(2, fechanacAux.length()));
                }else{
                    if (fechanacAux.length()==9 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(4)==47){
                        jfechaalta.setText('0' + fechanacAux.substring(0, fechanacAux.length()));
                    }else{
                        if(fechanacAux.length()==9 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(4)==47){
                            jfechaalta.setText(fechanacAux.substring(0, 3) + '0' + fechanacAux.substring(3, fechanacAux.length()));
                        }else{
                            //PARA AÑOS DE DOS DIGITOS
                            if(fechanacAux.length()==6 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(3)==47){
                                String año = this.añoDeCuatroDigitos(fechanacAux.substring(4,6));
                                jfechaalta.setText('0' + fechanacAux.substring(0, 2) + '0' + fechanacAux.substring(2, 4) + año);
                            }else{
                                if(fechanacAux.length()==7 && fechanacAux.charAt(1)==47 && fechanacAux.charAt(4)==47){
                                    String año = this.añoDeCuatroDigitos(fechanacAux.substring(5,7));
                                    jfechaalta.setText('0' + fechanacAux.substring(0, 5) + año);
                                }else{
                                    if(fechanacAux.length()==7 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(4)==47){
                                        String año = this.añoDeCuatroDigitos(fechanacAux.substring(5,7));
                                        jfechaalta.setText(fechanacAux.substring(0, 3) + '0' + fechanacAux.substring(3,5) + año);
                                    }else{
                                        if(fechanacAux.length()==8 && fechanacAux.charAt(2)==47 && fechanacAux.charAt(5)==47){
                                            String año = this.añoDeCuatroDigitos(fechanacAux.substring(6,8));
                                            jfechaalta.setText(fechanacAux.substring(0, 6) + año);
                                        }else{
                                            jfechaalta.setText("");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jfechaaltaFocusLost

    private void jfechaaltaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfechaaltaKeyTyped
        if (!((evt.getKeyChar()>=48 && evt.getKeyChar()<=57) || evt.getKeyChar()==KeyEvent.VK_SLASH)){
            evt.consume();
        }
    }//GEN-LAST:event_jfechaaltaKeyTyped
  
    private String añoDeCuatroDigitos(String añoDeDos){
        if(Integer.parseInt("20"+añoDeDos)>Calendar.getInstance().get(Calendar.YEAR)){
            return "19"+añoDeDos;
        }else{
            return "20"+añoDeDos;
        }
    }    
    
  
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
            java.util.logging.Logger.getLogger(AltaAdherente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaAdherente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaAdherente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaAdherente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaAdherente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CONTINUAR;
    private javax.swing.JLabel j1deN;
    private javax.swing.JTextField j1den;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField japellido;
    private javax.swing.JTextField jdireccion;
    private javax.swing.JFormattedTextField jdni;
    private javax.swing.JTextField jedad;
    private javax.swing.JTextField jfechaalta;
    private javax.swing.JTextField jfechacobertura;
    private javax.swing.JTextField jfechanac;
    private javax.swing.JTextField jnombre;
    private javax.swing.JTextField jnrosocio;
    private javax.swing.JComboBox<String> jsexo;
    private javax.swing.JTextField jtelefono;
    // End of variables declaration//GEN-END:variables

    conectar cc = new conectar();
    Connection cn = cc.ConexionMySql();

}
