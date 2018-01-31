package tarifa;

import cocheriazurdo.PantallaPrincipal;
import java.awt.Point;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import socio.OpcionesSocio;

public class Tarifas extends javax.swing.JFrame {

    private Point clic;
    
    public Tarifas() {
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        btEXIT = new javax.swing.JLabel();
        btMINIMIZAR1 = new javax.swing.JLabel();
        btBACK = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jCargar = new javax.swing.JButton();
        jEliminar = new javax.swing.JButton();
        jConsultar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jEditar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(55, 64, 70));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));
        jPanel6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel6MouseDragged(evt);
            }
        });
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel6MousePressed(evt);
            }
        });

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

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CONSULTAR");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("CARGAR");

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("EDITAR");

        jCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/flecha-hacia-arriba.png"))); // NOI18N
        jCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCargarActionPerformed(evt);
            }
        });
        jCargar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCargarKeyPressed(evt);
            }
        });

        jEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/flecha-hacia-abajo.png"))); // NOI18N
        jEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEliminarActionPerformed(evt);
            }
        });
        jEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEliminarKeyPressed(evt);
            }
        });

        jConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/busqueda.png"))); // NOI18N
        jConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConsultarActionPerformed(evt);
            }
        });
        jConsultar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jConsultarKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("ELIMINAR");

        jEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/editar.png"))); // NOI18N
        jEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarActionPerformed(evt);
            }
        });
        jEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jEditarKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TARIFAS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/etiqueta-del-precio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jCargar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jEditar))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btBACK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btMINIMIZAR1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEXIT)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btEXIT)
                            .addComponent(btMINIMIZAR1)
                            .addComponent(btBACK)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCargar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jConsultar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jEditar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        PantallaPrincipal PP = new PantallaPrincipal();
        this.dispose();
    }//GEN-LAST:event_btBACKMouseClicked

    private void jCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCargarActionPerformed
        CargarTarifa CT = new CargarTarifa();
        this.dispose();
    }//GEN-LAST:event_jCargarActionPerformed

    private void jEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEliminarActionPerformed
        EliminarTarifa ET = new EliminarTarifa();
        this.dispose();
    }//GEN-LAST:event_jEliminarActionPerformed

    private void jConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConsultarActionPerformed
        ConsultarTarifas CF = new ConsultarTarifas();
        this.dispose();
    }//GEN-LAST:event_jConsultarActionPerformed

    private void jEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarActionPerformed
        EditarTarifa ET = new EditarTarifa();
        this.dispose();
    }//GEN-LAST:event_jEditarActionPerformed

    private void jCargarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCargarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            CargarTarifa CT = new CargarTarifa();
            this.dispose();
        }
    }//GEN-LAST:event_jCargarKeyPressed

    private void jEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEliminarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EliminarTarifa ET = new EliminarTarifa();
            this.dispose();
        }
    }//GEN-LAST:event_jEliminarKeyPressed

    private void jConsultarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jConsultarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ConsultarTarifas CF = new ConsultarTarifas();
            this.dispose();
        }
    }//GEN-LAST:event_jConsultarKeyPressed

    private void jEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jEditarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            EditarTarifa ET = new EditarTarifa();
            this.dispose();
        }
    }//GEN-LAST:event_jEditarKeyPressed

    private void jPanel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MousePressed
        clic = evt.getPoint();
    }//GEN-LAST:event_jPanel6MousePressed

    private void jPanel6MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseDragged
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
    }//GEN-LAST:event_jPanel6MouseDragged

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
            java.util.logging.Logger.getLogger(Tarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarifas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarifas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btBACK;
    private javax.swing.JLabel btEXIT;
    private javax.swing.JLabel btMINIMIZAR1;
    private javax.swing.JButton jCargar;
    private javax.swing.JButton jConsultar;
    private javax.swing.JButton jEditar;
    private javax.swing.JButton jEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
