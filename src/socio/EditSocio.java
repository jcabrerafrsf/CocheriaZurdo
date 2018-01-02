/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socio;

import cocheriazurdo.Fecha_Hora;
import cocheriazurdo.conectar;
import socio.OpcionesSocio;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author juani
 */
public class EditSocio extends javax.swing.JFrame {

    int numerosocio=0;
    
    public EditSocio() {
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
    }
    
    public EditSocio(int nrosocio) {

        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setVisible(true);
        String cadena = "";
        numerosocio = nrosocio;
        cadena = String.valueOf(numerosocio);
        jnrosocio.setText(cadena);
        this.setLocationRelativeTo(null);
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
        
        if (fecha.after(fecha2)){
            JOptionPane.showMessageDialog(null,"Se colocó una fecha de nacimiento incorrecta");
            jfechanac.setText(null);
            jfechaalta.setText(null);
            return ;
        }
        
        //seteo la edad y la fecha de cobertura
        
        this.jedad.setText(fechaSys.getEdad(fecha));
        this.jfechacobertura.setText(fechaSys.getFechaCobertura(fecha,fecha2));
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
    
    
    public String setSexo(){
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
    
    
    public String getLocalidad(){
        int varlocalidad = this.jlocalidad.getSelectedIndex();
        switch (varlocalidad){
            case 0: return "BOVRIL";
            case 1: return "SAUCE DE LUNA";
            case 2: return "ALCARAZ";
            case 3: return "COLONIA AVIGDOR";
            case 4: return "MOJONES NORTE";
            case 5: return "MOJONES SUR";
            case 6: return "CONSCRIPTO BERNARDI";
            case 7: return "SIR LEONARD";
            default: return "NO ESPECIFICADO";
        }
    }
    
    public String getPlan(){
        int varplan = this.jplan.getSelectedIndex();
        switch (varplan){
            case 0: return "INDIVIDUAL";
            case 1: return "TITULAR Y ADHERENTE";
            case 2: return "FAMILIAR";
            case 3: return"FAMILIAR CON IOSPER";
            case 4: return "JUBILADOS";
            default: return "NO ESPECIFICADO";
        }
    }
    
    
    //LUEGO DE MODIFICAR LOS TEXTFIELD, HACE UN UPDATE
    public void actualizarDatos(){

       try{
           
        int numerodesocio = Integer.parseInt(this.jnrosocio.getText());
           
        PreparedStatement pst = cn.prepareStatement("UPDATE socios SET nro_socio=?, nro_zona=?, nombre=?, apellido=?, dni=?, direccion=?, telefono=?, sexo=?, localidad=?, plan=?, codigo_tarifa=?, codigo_obrasocial=?, fecha_nac=?, edad=?, nro_adherentes=? WHERE nro_socio="+numerodesocio);
        
        pst.setInt(1,numerodesocio);
        pst.setInt(2, this.jzona.getSelectedIndex()+1);
        pst.setString(3, this.jnombre.getText().toUpperCase());
        pst.setString(4, this.japellido.getText().toUpperCase());
        pst.setString(5, this.jdni.getText().toUpperCase());
        pst.setString(6, this.jdireccion.getText().toUpperCase());
        pst.setString(7, this.jtelefono.getText().toUpperCase());
        pst.setString(8, getSexo());
        pst.setString(9, getLocalidad());
        pst.setString(10, getPlan());
        pst.setString(11, this.jcodigotarifa.getText().toUpperCase());        
        pst.setString(12, this.jcodigoobrasocial.getText().toUpperCase());
        pst.setString(13, this.jfechanac.getText().toUpperCase());
        //NO ACTUALIZO LA FECHA DE ALTA NI COBERTURA POR QUE ES ILÓGICO
        //pst.setString(14, this.jfechaalta.getText().toUpperCase());
        //pst.setString(15, this.jfechacobertura.getText().toUpperCase());
        pst.setString(14, this.jedad.getText().toUpperCase());
        pst.setString(15, this.jnumeroadherentes.getText().toUpperCase());

        pst.executeUpdate();
        pst.close();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion - "+e.getMessage());
        }
       
    }
    
    //SETEA LOS VALORES EN LOS TEXTFIELD
    
    public void cargaDatos(){

       try{
        
        int numerodesocio = Integer.parseInt(this.jnrosocio.getText());
        
        //VER SI EL NRO DE SOCIO EXISTE
        
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT * FROM bdcocheriazurdo.socios WHERE nro_socio="+numerodesocio);
            int existesocio=0;
            
            while(rs1.next()){
                existesocio = rs1.getInt("nro_socio");
            }
            rs1.close();
            
            if(existesocio==0){
                JOptionPane.showMessageDialog(null,"El N° de Socio no existe en la Base de Datos. Consulte desde la opcion 'Consultar'");
                EditSocio EUS = new EditSocio();
                this.dispose();           
                EUS.setVisible(true);
            }
            else{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM bdcocheriazurdo.socios WHERE nro_socio="+numerodesocio);

                String datos[] = new String [20];        
                while(rs.next()){
                        datos[0] = rs.getString("nro_socio");
                        datos[1] = rs.getString("nro_zona");         
                        datos[2] = rs.getString("nombre");
                        datos[3] = rs.getString("apellido");
                        datos[4] = rs.getString("dni");
                        datos[5] = rs.getString("direccion");
                        datos[6] = rs.getString("telefono");
                        datos[7] = rs.getString("sexo");
                        datos[8] = rs.getString("localidad");
                        datos[9] = rs.getString("plan");
                        datos[10] = rs.getString("codigo_tarifa");         
                        datos[11] = rs.getString("codigo_obrasocial");
                        datos[12] = rs.getString("fecha_nac");
                        datos[13] = rs.getString("fecha_alta");
                        datos[14] = rs.getString("fecha_cobertura");
                        datos[15] = rs.getString("edad");
                        datos[16] = rs.getString("nro_adherentes");
                        datos[17] = rs.getString("credito");
                        datos[18] = rs.getString("tipo_socio");
                        datos[19] = rs.getString("estado");
                }
                rs.close();   
                
               

                jnombre.setText(datos[2]);
                japellido.setText(datos[3]);
                jdni.setText(datos[4]);
                
                System.out.println("EL SEXO ES: "+datos[7]);
                                
                if(datos[7]=="MASCULINO"){
                   jsexo.setSelectedIndex(0);
                }
                else{
                    if(datos[7]=="FEMENINO"){
                      jsexo.setSelectedIndex(1);  
                    }
                    else{
                        jsexo.setSelectedIndex(2);
                    }
                }
                
                System.out.println("EL SEXO ES: "+getSexo());
                
                
                
                jfechanac.setText(datos[12]);
                jdireccion.setText(datos[5]);
                jtelefono.setText(datos[6]);
                
                switch (datos[8]){
                    case "BOVRIL": jlocalidad.setSelectedIndex(0);
                    break;
                    case "SAUCE DE LUNA": jlocalidad.setSelectedIndex(1);
                    break;
                    case "ALCARAZ": jlocalidad.setSelectedIndex(2);
                    break;
                    case "COLONIA AVIGDOR": jlocalidad.setSelectedIndex(3);
                    break;
                    case "MOJONES NORTE": jlocalidad.setSelectedIndex(4);
                    break;
                    case "MOJONES SUR": jlocalidad.setSelectedIndex(5);
                    break;
                    case "CONSCRIPTO BERNARDI": jlocalidad.setSelectedIndex(6);
                    break;
                    case "SIR LEONARD": jlocalidad.setSelectedIndex(7);
                    break;
                }

                switch (datos[9]){
                    case "INDIVIDUAL": jplan.setSelectedIndex(0);
                    break;
                    case "TITULAR Y ADHERENTE": jplan.setSelectedIndex(1);
                    break;
                    case "FAMILIAR": jplan.setSelectedIndex(2);
                    break;
                    case "FAMILIAR CON IOSPER": jplan.setSelectedIndex(3);
                    break;
                    case "JUBILADOS": jplan.setSelectedIndex(4);
                    break;
                }

                jnumeroadherentes.setText(datos[16]);
                jzona.setSelectedIndex(Integer.parseInt(datos[1]));
                jcodigotarifa.setText(datos[10]);
                jcodigoobrasocial.setText(datos[11]);
                jedad.setText(datos[15]);
                jfechaalta.setText(datos[13]);
                jfechacobertura.setText(datos[14]);
            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion - "+e.getMessage());
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

        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btEXIT = new javax.swing.JLabel();
        btMINIMIZAR = new javax.swing.JLabel();
        btBACK = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jnrosocio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        japellido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jdni = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jsexo = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jfechanac = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jdireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jlocalidad = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jplan = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jnumeroadherentes = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jcodigotarifa = new javax.swing.JFormattedTextField();
        jLabel17 = new javax.swing.JLabel();
        jcodigoobrasocial = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jedad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jfechaalta = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jfechacobertura = new javax.swing.JFormattedTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btcargar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jzona = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(240, 240, 240));
        jLabel15.setText("CODIGO TARIFA:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 64, 70));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/edituser.png"))); // NOI18N

        btEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close-circular-button-of-a-cross (1).png"))); // NOI18N
        btEXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEXITMouseClicked(evt);
            }
        });

        btMINIMIZAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/minus-sign-in-a-circle (1).png"))); // NOI18N
        btMINIMIZAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMINIMIZARMouseClicked(evt);
            }
        });

        btBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/back-arrow-circular-symbol (1).png"))); // NOI18N
        btBACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBACKMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("MODIFICAR SOCIO");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("N° de Socio:");

        jnrosocio.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jnrosocio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jnrosocioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jnrosocioFocusLost(evt);
            }
        });
        jnrosocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnrosocioActionPerformed(evt);
            }
        });
        jnrosocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jnrosocioKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Consultar Socios:");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("NOMBRE:");

        jnombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jnombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jnombreFocusGained(evt);
            }
        });
        jnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jnombreKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("APELLIDO:");

        japellido.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        japellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                japellidoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("DNI:");

        jdni.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jdni.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdniKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("SEXO: ");

        jsexo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jsexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "I" }));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("FECHA DE NACIMIENTO:");

        jfechanac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.MEDIUM))));
        jfechanac.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jfechanac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jfechanacFocusLost(evt);
            }
        });
        jfechanac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jfechanacKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("DIRECCION:");

        jdireccion.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jdireccionKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("TELEFONO:");

        jtelefono.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jtelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtelefonoKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("LOCALIDAD:");

        jlocalidad.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jlocalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOVRIL", "SAUCE DE LUNA", "ALCARAZ", "COLONIA AVIGDOR", "MOJONES NORTE", "MOJONES SUR", "CONSCRIPTO BERNARDI", "SIR LEONARD" }));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("PLAN:");

        jplan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jplan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INDIVIDUAL", "TITULAR Y ADHERENTE", "FAMILIAR", "FAMILIAR CON OBRA SOCIAL", "JUBILADOS" }));
        jplan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jplanItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("NUMERO DE ADHERENTES:");

        jnumeroadherentes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jnumeroadherentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnumeroadherentesActionPerformed(evt);
            }
        });
        jnumeroadherentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jnumeroadherentesKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(240, 240, 240));
        jLabel16.setText("TARIFA:");

        jcodigotarifa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jcodigotarifa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jcodigotarifa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcodigotarifaKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText("OBRA SOCIAL:");

        jcodigoobrasocial.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jcodigoobrasocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jcodigoobrasocialKeyTyped(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(240, 240, 240));
        jLabel18.setText("EDAD:");

        jedad.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setText("FECHA ALTA:");

        jfechaalta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jfechaalta.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(240, 240, 240));
        jLabel21.setText("FECHA COBERTURA:");

        jfechacobertura.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jfechacobertura.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        btcargar.setBackground(new java.awt.Color(255, 153, 51));
        btcargar.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btcargar.setText("MODIFICAR");
        btcargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcargarActionPerformed(evt);
            }
        });
        btcargar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btcargarKeyPressed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(240, 240, 240));
        jLabel22.setText("ZONA:");

        jzona.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jzona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - OFICINA BOVRIL", "2 - BOVRIL 2", "3 - BOVRIL 3", "4 - BOVRIL 4", "5 - BOVRIL 5", "6 - ALCARAZ", "7 - SIR LEONARD", "8 - MOJONES", "9 - AVIGDOR", "10 - SAUCE DE LUNEA", "11 - CONSCRIPTO BERNARDI", "12 - SOCIO NUEVO" }));
        jzona.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/busqueda24.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jnrosocio, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBACK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMINIMIZAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEXIT))
                    .addComponent(jSeparator4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jplan, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jnumeroadherentes))
                    .addComponent(jSeparator7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(japellido, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdni, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcodigotarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcodigoobrasocial, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btcargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jedad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jfechaalta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jfechacobertura, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBACK)
                    .addComponent(btMINIMIZAR)
                    .addComponent(btEXIT)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jnrosocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(japellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jfechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jplan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jnumeroadherentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jcodigotarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jcodigoobrasocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jzona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jfechaalta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jfechacobertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btcargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEXITMouseClicked
        if (jnrosocio.getText().isEmpty() && japellido.getText().isEmpty() && jdni.getText().isEmpty() && jtelefono.getText().isEmpty() &&
            jdireccion.getText().isEmpty() && jfechanac.getText().isEmpty() && jcodigotarifa.getText().isEmpty() && jcodigoobrasocial.getText().isEmpty()
        ){
            System.exit(0);
        }else{
            int seleccion = JOptionPane.showConfirmDialog(null, "Existen campos con datos cargados. Desea perder los datos y regresar?", "Confirmar regreso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(seleccion == 0){
                System.exit(0);
            }
            else{

            }

        }

    }//GEN-LAST:event_btEXITMouseClicked

    private void btMINIMIZARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMINIMIZARMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btMINIMIZARMouseClicked

    private void btBACKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBACKMouseClicked
        if (jnrosocio.getText().isEmpty() && japellido.getText().isEmpty() && jdni.getText().isEmpty() && jtelefono.getText().isEmpty() &&
            jdireccion.getText().isEmpty() && jfechanac.getText().isEmpty() && jcodigotarifa.getText().isEmpty() && jcodigoobrasocial.getText().isEmpty()
        ){
            OpcionesSocio OS = new OpcionesSocio();
            this.dispose();
            OS.setVisible(true);
        }else{
            int seleccion = JOptionPane.showConfirmDialog(null, "Existen campos con datos cargados. Desea perder los datos y regresar?", "Confirmar regreso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if(seleccion == 0){
                OpcionesSocio OS = new OpcionesSocio();
                this.dispose();
                OS.setVisible(true);
            }
            else{

            }

        }
    }//GEN-LAST:event_btBACKMouseClicked

    private void jnombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnombreFocusGained

    }//GEN-LAST:event_jnombreFocusGained

    private void jnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnombreKeyTyped
        /*if(((evt.getKeyChar()>='A') && (evt.getKeyChar()<='Z')) || ((evt.getKeyChar()>='a') && (evt.getKeyChar()<='z')) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            int cont = jnombre.getText().length();
            if (cont>=30){
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
        evt.consume();*/
    }//GEN-LAST:event_jnombreKeyTyped

    private void japellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_japellidoKeyTyped
       /* if(((evt.getKeyChar()>='A') && (evt.getKeyChar()<='Z')) || ((evt.getKeyChar()>='a') && (evt.getKeyChar()<='z')) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            int cont = japellido.getText().length();
            if (cont>=30){
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
        evt.consume();*/
    }//GEN-LAST:event_japellidoKeyTyped

    private void jdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdniKeyTyped
        /*if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            int cont = jdni.getText().length();
            if (cont>=8){
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
        evt.consume();*/
    }//GEN-LAST:event_jdniKeyTyped

    private void jfechanacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jfechanacFocusLost
        fechaSistema();
    }//GEN-LAST:event_jfechanacFocusLost

    private void jfechanacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfechanacKeyTyped
       /* if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_SLASH)){
            int cont = jfechanac.getText().length();
            if (evt.getKeyChar() == KeyEvent.VK_SLASH){
                if (cont>=3)
                cont=5;
            }
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
        evt.consume();*/
    }//GEN-LAST:event_jfechanacKeyTyped

    private void jdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdireccionKeyTyped
       /* if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || ((evt.getKeyChar()>='A') && (evt.getKeyChar()<='Z')) || ((evt.getKeyChar()>='a') && (evt.getKeyChar()<='z')) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            int cont = jdireccion.getText().length();
            if (cont>=30){
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
        evt.consume();*/
    }//GEN-LAST:event_jdireccionKeyTyped

    private void jtelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtelefonoKeyTyped
       /* if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
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
        evt.consume();*/
    }//GEN-LAST:event_jtelefonoKeyTyped

    private void jplanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jplanItemStateChanged
        switch(this.jplan.getSelectedItem().toString()){
            case "INDIVIDUAL":
            this.jnumeroadherentes.setText("0");
            this.jnumeroadherentes.setEditable(false);
            break;

            case "TITULAR Y ADHERENTE":
            this.jnumeroadherentes.setText("1");
            this.jnumeroadherentes.setEditable(false);
            break;

            default:
            this.jnumeroadherentes.setEditable(true);
            this.jnumeroadherentes.setText("2");
        }
    }//GEN-LAST:event_jplanItemStateChanged

    private void jnumeroadherentesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnumeroadherentesKeyTyped
       /* if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            int cont = jnumeroadherentes.getText().length();
            if (cont>=1){
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
        evt.consume();*/
    }//GEN-LAST:event_jnumeroadherentesKeyTyped

    private void jnumeroadherentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnumeroadherentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnumeroadherentesActionPerformed

    private void jcodigotarifaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodigotarifaKeyTyped
        /*if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            int cont = jcodigotarifa.getText().length();
            if (cont>=2){
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
        evt.consume();*/
    }//GEN-LAST:event_jcodigotarifaKeyTyped

    private void jcodigoobrasocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcodigoobrasocialKeyTyped
        /*if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || ((evt.getKeyChar()>='A') && (evt.getKeyChar()<='Z')) || ((evt.getKeyChar()>='a') && (evt.getKeyChar()<='z')) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE) || (evt.getKeyChar() == KeyEvent.VK_SPACE)){
            int cont = jcodigoobrasocial.getText().length();
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
        evt.consume();*/
    }//GEN-LAST:event_jcodigoobrasocialKeyTyped

    private void btcargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcargarActionPerformed
        actualizarDatos();
        
        int numerodesocio1 = Integer.parseInt(this.jnrosocio.getText());
        
        JOptionPane.showMessageDialog(this, "El socio "+jnombre.getText()+" "+japellido.getText()+" fue actualizado con éxito. Nro. de socio: "+ numerodesocio1);
        
        OpcionesSocio OS = new OpcionesSocio();
        this.dispose();
        OS.setVisible(true);

        
    }//GEN-LAST:event_btcargarActionPerformed

    private void btcargarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btcargarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
         actualizarDatos();
        }
    }//GEN-LAST:event_btcargarKeyPressed

    private void jnrosocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnrosocioKeyTyped
/*        if(((evt.getKeyChar()>=48) && (evt.getKeyChar()<=57)) || (evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)){
            int cont = jdni.getText().length();
            if (cont>=8){
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
        evt.consume();*/
    }//GEN-LAST:event_jnrosocioKeyTyped

    private void jnrosocioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnrosocioFocusLost
        if(jnrosocio.getText().isEmpty()){
            jnrosocio.requestFocus();
        }
        else{
            cargaDatos();  
        }
    }//GEN-LAST:event_jnrosocioFocusLost

    private void jnrosocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnrosocioActionPerformed

    }//GEN-LAST:event_jnrosocioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ConsultaSociosParaEditar CS = new ConsultaSociosParaEditar();
        this.dispose();
        CS.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jnrosocioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jnrosocioFocusGained
        if(jnrosocio.getText().isEmpty()){
            jnrosocio.requestFocus();
        }
        else{
            cargaDatos();  
        }
    }//GEN-LAST:event_jnrosocioFocusGained

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
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditSocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btBACK;
    private javax.swing.JLabel btEXIT;
    private javax.swing.JLabel btMINIMIZAR;
    private javax.swing.JButton btcargar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField japellido;
    private javax.swing.JTextField jcodigoobrasocial;
    private javax.swing.JFormattedTextField jcodigotarifa;
    private javax.swing.JTextField jdireccion;
    private javax.swing.JFormattedTextField jdni;
    private javax.swing.JTextField jedad;
    private javax.swing.JFormattedTextField jfechaalta;
    private javax.swing.JFormattedTextField jfechacobertura;
    private javax.swing.JFormattedTextField jfechanac;
    private javax.swing.JComboBox<String> jlocalidad;
    private javax.swing.JTextField jnombre;
    private javax.swing.JTextField jnrosocio;
    private javax.swing.JTextField jnumeroadherentes;
    private javax.swing.JComboBox<String> jplan;
    private javax.swing.JComboBox<String> jsexo;
    private javax.swing.JTextField jtelefono;
    private javax.swing.JComboBox<String> jzona;
    // End of variables declaration//GEN-END:variables
    conectar cc = new conectar();
    Connection cn = cc.ConexionMySql();

}
