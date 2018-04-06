/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planes;

import cobradores.*;
import cocheriazurdo.conectar;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socio.ConsultaSocios;
import zonas.Zonas;

/**
 *
 * @author juani
 */
public class CargarPlan extends javax.swing.JFrame {

    private Point clic;
    
    public CargarPlan() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage()); 
        cargarMaxCobrador();
    }

    public void cargarMaxCobrador(){
        
        int maxPlan=0;
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(nro_plan) FROM bdcocheriazurdo.planes");
            rs.last();
            maxPlan = rs.getInt("MAX(nro_plan)");
            String maxP = Integer.toString(maxPlan+1);
            jnroplan.setText(maxP);
        }catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
        public void levantarNuevoPlan(){
        
        try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO bdcocheriazurdo.planes VALUES(?,?,?)");

            int nro_plan = Integer.parseInt(jnroplan.getText());

            pst.setInt(1, nro_plan);
            pst.setString(2, jnombre.getText().toUpperCase());
            pst.setString(3, null);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null,"Plan creado con éxito"); 

            Planes p = new Planes();
            this.dispose();

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage()+"El número de plan ya está cargado o hay un problema en la base de datos"); 
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        JL = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btEXIT = new javax.swing.JLabel();
        btMINIMIZAR1 = new javax.swing.JLabel();
        btBACK = new javax.swing.JLabel();
        jnroplan = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jContinuar = new javax.swing.JButton();
        jCancelar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        jnombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 64, 70));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2)));
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
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CARGAR PLAN");

        JL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/flecha-hacia-arriba.png"))); // NOI18N

        btEXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/close-circular-button-of-a-cross (1).png"))); // NOI18N
        btEXIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEXITMouseClicked(evt);
            }
        });

        btMINIMIZAR1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/minus-sign-in-a-circle (1).png"))); // NOI18N
        btMINIMIZAR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMINIMIZAR1MouseClicked(evt);
            }
        });

        btBACK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/back-arrow-circular-symbol (1).png"))); // NOI18N
        btBACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBACKMouseClicked(evt);
            }
        });

        jnroplan.setEditable(false);
        jnroplan.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jnroplan.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("N° DE PLAN:");

        jContinuar.setBackground(new java.awt.Color(153, 255, 153));
        jContinuar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jContinuar.setText("CONTINUAR");
        jContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jContinuarActionPerformed(evt);
            }
        });
        jContinuar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jContinuarKeyPressed(evt);
            }
        });

        jCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jCancelar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jCancelar.setText("CANCELAR");
        jCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarActionPerformed(evt);
            }
        });
        jCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCancelarKeyPressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("NOMBRE:");

        jnombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(JL, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(btBACK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMINIMIZAR1)
                                .addGap(7, 7, 7)
                                .addComponent(btEXIT))
                            .addComponent(jSeparator1)))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jnombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jContinuar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jnroplan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btBACK)
                            .addComponent(btMINIMIZAR1)
                            .addComponent(btEXIT)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jnroplan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jContinuar)
                    .addComponent(jCancelar))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEXITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEXITMouseClicked
        int seleccion = JOptionPane.showConfirmDialog(null, "Realmente desea salir del sistema?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion==0){
            System.exit(0);
        }else{
        }
    }//GEN-LAST:event_btEXITMouseClicked

    private void btMINIMIZAR1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMINIMIZAR1MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btMINIMIZAR1MouseClicked

    private void btBACKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBACKMouseClicked
        int seleccion = JOptionPane.showConfirmDialog(null, "Realmente desea volver atrás?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion==0){
            Planes p = new Planes();
            this.dispose();
        }else{
        }
    }//GEN-LAST:event_btBACKMouseClicked

    private void jContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jContinuarActionPerformed
        if(jnroplan.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Hubo un problema al cargar el número de plan. Reintente");
        }else{
            if(jnombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Se debe especificar un nombre");
            }else{
                levantarNuevoPlan();
            }
        }
    }//GEN-LAST:event_jContinuarActionPerformed

    private void jContinuarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jContinuarKeyPressed

    }//GEN-LAST:event_jContinuarKeyPressed

    private void jCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarActionPerformed
        int seleccion = JOptionPane.showConfirmDialog(null, "Realmente desea cancelar la operación?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(seleccion==0){
            Planes p = new Planes();
            this.dispose();
        }else{
        }
    }//GEN-LAST:event_jCancelarActionPerformed

    private void jCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCancelarKeyPressed

    }//GEN-LAST:event_jCancelarKeyPressed

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

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        clic = evt.getPoint();
    }//GEN-LAST:event_jPanel1MousePressed

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
            java.util.logging.Logger.getLogger(CargarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarPlan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarPlan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL;
    private javax.swing.JLabel btBACK;
    private javax.swing.JLabel btEXIT;
    private javax.swing.JLabel btMINIMIZAR1;
    private javax.swing.JButton jCancelar;
    private javax.swing.JButton jContinuar;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jnombre;
    private javax.swing.JTextField jnroplan;
    // End of variables declaration//GEN-END:variables
    conectar cc = new conectar();
    Connection cn = cc.ConexionMySql();
}
