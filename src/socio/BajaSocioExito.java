/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socio;

import adherente.AdhNuevoSocio;
import cocheriazurdo.Fecha_Hora;
import cocheriazurdo.conectar;
import java.awt.Point;
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
public class BajaSocioExito extends javax.swing.JFrame {
    
    int numero_socio;
    int numero_zona;
    int nro_socio_nuevo;
    String fecha_de_nac;
    int edad_final;
    private Point clic;

    public BajaSocioExito(int nro_socio) {
        numero_socio = nro_socio;
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
    }
    
    public BajaSocioExito() {
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
    }
    
    public void fechaSistema(String fe){
        
        Fecha_Hora fechaSys = new Fecha_Hora();
        Date fecha = null;
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
        fecha = formatoDelTexto.parse(fe);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
         
        //parseo la fecha de string a int        
        String edad1 = fechaSys.getEdad(fecha);        
        int edad_final = Integer.parseInt(edad1);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btconfirmar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        bteliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 64, 70));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));
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
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("SOCIO DADO DE BAJA CON ÉXITO");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/negativo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Desea que el adherente sea nuevo socio ?");

        btconfirmar.setBackground(new java.awt.Color(153, 255, 153));
        btconfirmar.setText("CONFIRMAR");
        btconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconfirmarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Desea eliminar los adherentes ?");

        bteliminar.setBackground(new java.awt.Color(255, 153, 153));
        bteliminar.setText("ELIMINAR");
        bteliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bteliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bteliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btconfirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bteliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconfirmarActionPerformed
        
        String datos[] = new String [10];
        
        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery("SELECT apellido, nombre, dni, direccion, telefono, sexo, fecha_nac, fecha_alta, fecha_cobertura FROM adherentes WHERE nro_socio ="+numero_socio+" LIMIT 1");
            System.out.println("");    
               rs1.next();
               datos[0] = rs1.getString("apellido");
               System.out.println(datos[0]);   
               datos[1] = rs1.getString("nombre");  
               System.out.println(datos[0]);
               datos[2] = rs1.getString("dni");
               datos[3] = rs1.getString("direccion");
               datos[4] = rs1.getString("telefono");
               datos[5] = rs1.getString("sexo");
               datos[6] = rs1.getString("fecha_nac");
               datos[7] = rs1.getString("fecha_alta");
               datos[8] = rs1.getString("fecha_cobertura");
               rs1.close();
               
               System.out.println(datos[0]+" "+datos[1]);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
        
        fecha_de_nac=datos[6];
        
        //CARGAR NUEVO SOCIO (VIEJO ADHERENTE)
        
        int cantsocios=0;
        int num_zona=0;
        String local="No especificado";
        int num_adh=0;
        String tipo_plan="No especificado";
        String codigo_tar="No especificado";
        String codigo_os="No especificado";
        double credito_disp=0;
        
        
        try{
        PreparedStatement pst = cn.prepareStatement("INSERT INTO bdcocheriazurdo.socios VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(nro_socio) FROM bdcocheriazurdo.socios");
            rs.last();
            cantsocios = rs.getInt("MAX(nro_socio)");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        pst.setInt(1,cantsocios+1);
        
        //zona
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nro_zona FROM socios WHERE nro_socio="+numero_socio);
            rs.last();
            num_zona = rs.getInt("nro_zona");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        pst.setInt(2, num_zona);        
        pst.setString(3, datos[1]);         
        pst.setString(4, datos[0]);        
        pst.setString(5, datos[2]);        
        pst.setString(6, datos[3]);        
        pst.setString(7, datos[4]);        
        pst.setString(8,datos[5]);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT localidad FROM socios WHERE nro_socio="+numero_socio);
            rs.last();
            local = rs.getString("localidad");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        pst.setString(9, local);

        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT plan FROM socios WHERE nro_socio ="+numero_socio);
            rs.last();
            tipo_plan = rs.getString("plan");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        pst.setString(10, tipo_plan);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT codigo_tarifa FROM socios WHERE nro_socio ="+numero_socio);
            rs.last();
            codigo_tar = rs.getString("codigo_tarifa");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        pst.setString(11, codigo_tar);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT codigo_obrasocial FROM socios WHERE nro_socio ="+numero_socio);
            rs.last();
            codigo_os = rs.getString("codigo_obrasocial");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        pst.setString(12, codigo_os);        
        pst.setString(13, datos[6]);        
        pst.setString(14, datos[7]);
        pst.setString(15, datos[8]);        
        fechaSistema(datos[6]);      
        pst.setInt(16, edad_final);
        
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nro_adherentes FROM socios WHERE nro_socio="+numero_socio);
            rs.last();
            num_adh = rs.getInt("nro_adherentes");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        pst.setInt(17, num_adh);
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT credito FROM socios WHERE nro_socio="+numero_socio);
            rs.last();
            credito_disp = rs.getDouble("credito");
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pst.setDouble(18,credito_disp);        
        pst.setString(19, "ACTIVO");        
        pst.setString(20, "ALTA");

        pst.executeUpdate();
        
        try{
        PreparedStatement pst1 = cn.prepareStatement("DELETE FROM adherentes WHERE nro_socio=? LIMIT 1");
        pst1.setInt(1, numero_socio);
        pst1.executeUpdate();  
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
        nro_socio_nuevo=cantsocios+1;
        
        try{
        PreparedStatement pst2 = cn.prepareStatement("UPDATE adherentes SET nro_socio=? WHERE nro_socio=?");
        pst2.setInt(1, nro_socio_nuevo);
        pst2.setInt(2, numero_socio);
        pst2.executeUpdate();  
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        AdhNuevoSocio ANS = new AdhNuevoSocio();
        this.dispose(); 
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error en la conexion - "+e.getMessage());
        }
        
        
        
    }//GEN-LAST:event_btconfirmarActionPerformed

    private void bteliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bteliminarActionPerformed
        int resultado = JOptionPane.showConfirmDialog(null, "Realmente desea eliminar los adherentes ?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE); 
        
        if(resultado==0){
            try{
        PreparedStatement pst = cn.prepareStatement("DELETE FROM adherentes WHERE nro_socio=?");
        pst.setInt(1, numero_socio);
        pst.executeUpdate();        
        
        SocioyAdhBajaExito SABE = new SocioyAdhBajaExito();
        this.dispose();
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        }else{
            if(resultado==1){
                
            }
        }
        
        
        
    }//GEN-LAST:event_bteliminarActionPerformed

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
            java.util.logging.Logger.getLogger(BajaSocioExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BajaSocioExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BajaSocioExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BajaSocioExito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BajaSocioExito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btconfirmar;
    private javax.swing.JButton bteliminar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
    
    conectar cc = new conectar();
    Connection cn = cc.ConexionMySql();
}
