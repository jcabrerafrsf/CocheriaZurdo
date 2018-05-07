package reportes;

import cocheriazurdo.conectar;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import socio.ConsultaSocios;


public class Comprobantes extends javax.swing.JFrame {

    JasperReport reporte;
    JasperPrint jasperPrint = null;
    
    public Comprobantes() {
        initComponents();
        this.setVisible(true);
    }
    
    public int actualizarEdad(int nro_socio){
        
        System.out.println("ACTULIZANDO EDAD");
        
        int numerosocio = nro_socio;
        
        String fechaNacimiento=null;
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs1 = st.executeQuery("SELECT fecha_nac FROM bdcocheriazurdo.socios WHERE nro_socio="+numerosocio);
            
            while(rs1.next()){
                fechaNacimiento = rs1.getString("fecha_nac");
            }
            rs1.close();
            
            System.out.println("LA FECHA DE NAC ES:"+fechaNacimiento);
            
        }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date fecha = null;   
        
        try {                 
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formatoDelTexto.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //PARA OBTENER LA EDAD A PARTIR DE LA FECHA DE NAC
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            StringBuilder result = new StringBuilder();
            if (fecha != null) {
                Calendar c = new GregorianCalendar();
                c.setTime(fecha);
                result.append(calcularEdad(c));
            }
            System.out.println("LA EDAD ES"+result.toString());
            return Integer.parseInt(result.toString());
        }else{
            return 0;
        }
        
    }
        
    private int calcularEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();
        int diffYear = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diffMonth = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDay = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);
        // Si está en ese año pero todavía no los ha cumplido
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear = diffYear - 1;
        }
        return diffYear;
    }
    
    public void seteoPrecio(int nro_socio, int edad, double precios[]){
        
        System.out.println("ENTRO A SETEO__PRECIO");
        
        if(edad>=0 && edad<=10){
                                    
            try {
                PreparedStatement pst; 
                pst = cn.prepareStatement("UPDATE bdcocheriazurdo.socios SET pago='"+precios[0]+"' WHERE nro_socio='"+nro_socio+"';");
                pst.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage()+"- Problema para actualizar el pago");
                Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
            }            
            
        }else{
            if(edad>=11 && edad<=20){
                try {
                    PreparedStatement pst; 
                    pst = cn.prepareStatement("UPDATE bdcocheriazurdo.socios SET pago='"+precios[1]+"' WHERE nro_socio='"+nro_socio+"';");
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage()+"- Problema para actualizar el pago");
                    Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if(edad>=21 && edad<=30){
                    
                    System.out.println("ENTRO A IF DE 21 A 30");
                    
                    try {
                        PreparedStatement pst; 
                        pst = cn.prepareStatement("UPDATE bdcocheriazurdo.socios SET pago='"+precios[2]+"' WHERE nro_socio='"+nro_socio+"';");
                        pst.executeUpdate();
                        
                         System.out.println("UPDATE PAGO");
                        
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage()+"- Problema para actualizar el pago");
                        Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    if(edad>=31 && edad<=40){
                        try {
                            PreparedStatement pst; 
                            pst = cn.prepareStatement("UPDATE bdcocheriazurdo.socios SET pago='"+precios[3]+"' WHERE nro_socio='"+nro_socio+"';");
                            pst.executeUpdate();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage()+"- Problema para actualizar el pago");
                            Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        if(edad>=41 && edad<=50){
                            try {
                                PreparedStatement pst; 
                                pst = cn.prepareStatement("UPDATE bdcocheriazurdo.socios SET pago='"+precios[4]+"' WHERE nro_socio='"+nro_socio+"';");
                                pst.executeUpdate();
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null,ex.getMessage()+"- Problema para actualizar el pago");
                                Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else{
                            if(edad>=51 && edad<=60){
                                try {
                                    PreparedStatement pst; 
                                    pst = cn.prepareStatement("UPDATE bdcocheriazurdo.socios SET pago='"+precios[5]+"' WHERE nro_socio='"+nro_socio+"';");
                                    pst.executeUpdate();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex.getMessage()+"- Problema para actualizar el pago");
                                    Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }else{
                                if(edad>=61 && edad<=70){
                
                                }else{
                                    if(edad>=71 && edad<=80){
                
                                    }else{
                                        if(edad>=81 && edad<=90){
                
                                        }else{
                                            if(edad>=91 && edad<=100){
                
                                            }else{
                                                //seteo un precio >100
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }     
            }
        }
    }
    
    public void setPagosIndividual(){
            
        double precios[]= new double [15];
        int nro_socio; 
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT T.precio_int1, T.precio_int2, T.precio_int3, T.precio_int4, T.precio_int5, T.precio_int6, T.precio_int7, T.precio_int8, T.precio_int9, T.precio_int10, S.nro_socio FROM socios S, tarifas T WHERE S.codigo_tarifa = T.nro_tarifa AND S.plan=1 AND S.estado='ALTA' AND T.estado='ALTA'");
            
            while(rs.next()){
                precios[0] = rs.getDouble("precio_int1");
                precios[1] = rs.getDouble("precio_int2");
                precios[2] = rs.getDouble("precio_int3");
                precios[3] = rs.getDouble("precio_int4");
                precios[4] = rs.getDouble("precio_int5");
                precios[5] = rs.getDouble("precio_int6");
                precios[6] = rs.getDouble("precio_int7");
                precios[7] = rs.getDouble("precio_int8");
                precios[8] = rs.getDouble("precio_int9");
                precios[9] = rs.getDouble("precio_int10");
                nro_socio = rs.getInt("nro_socio");
                
                int edad = actualizarEdad(nro_socio);
                
                //SETEA EL PRECIO A PAGAR EN EL CAMPO "pago" de la BD tabla socios
                seteoPrecio(nro_socio, edad, precios);
                
            }
            }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("REPORTE PLAN INDIVIDUAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("REPORTE TIT Y ADH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("REPORTE PLAN FAMILIAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("REPORTE PLAN JUBILADO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            
            setPagosIndividual();
            
            JasperReport jasperReport = JasperCompileManager.compileReport("C:\\reportes\\Reporte.jrxml");
            jasperPrint = JasperFillManager.fillReport(jasperReport, null, cc.ConexionMySql());
            
            JasperViewer viewer = new JasperViewer(jasperPrint);
            viewer.setTitle("Comprobantes");
            viewer.setVisible(true); 
            
        } catch (JRException ex) {
            
            Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comprobantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    // End of variables declaration//GEN-END:variables
    
    conectar cc = new conectar();
    Connection cn = cc.ConexionMySql();
    
}
