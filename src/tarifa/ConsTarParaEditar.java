/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarifa;

import cocheriazurdo.conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import socio.ConsultaSocios;

/**
 *
 * @author juani
 */
public class ConsTarParaEditar extends javax.swing.JFrame {

    /**
     * Creates new form ConsTarParaEditar
     */
    public ConsTarParaEditar() {
        initComponents();
        this.setVisible(true);
        setIconImage(new ImageIcon(getClass().getResource("/recursos/logocz.png")).getImage());
        this.setLocationRelativeTo(null);
        mostrarDatos();
    }

    void mostrarDatos(){
        
        DefaultTableModel modelo = new DefaultTableModel(){
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
        }
        };
        modelo.addColumn("N° TARIFA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("ESTADO");
        tbtarifas.setModel(modelo);
        String datos[] = new String [6];
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM bdcocheriazurdo.tarifas");
            
            while(rs.next()){
                datos[0] = rs.getString("nro_tarifa");        
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("precio");
                datos[3] = rs.getString("estado");
                modelo.addRow(datos);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSocios.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btEXIT = new javax.swing.JLabel();
        btMINIMIZAR1 = new javax.swing.JLabel();
        btBACK = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtarifas = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jContinuar = new javax.swing.JButton();
        jnrotarifa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(55, 64, 70));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));

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

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONSULTA DE TARIFAS");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/busqueda24.png"))); // NOI18N

        tbtarifas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbtarifas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbtarifasFocusGained(evt);
            }
        });
        tbtarifas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtarifasMouseClicked(evt);
            }
        });
        tbtarifas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbtarifasCaretPositionChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tbtarifas);

        jContinuar.setBackground(new java.awt.Color(153, 255, 153));
        jContinuar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jContinuar.setText("CONTINUAR");
        jContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jContinuarActionPerformed(evt);
            }
        });

        jnrotarifa.setEditable(false);
        jnrotarifa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jnrotarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnrotarifaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("N° DE TARIFA A EDITAR:");

        jCancelar.setBackground(new java.awt.Color(255, 153, 153));
        jCancelar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jCancelar.setText("CANCELAR");
        jCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btBACK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMINIMIZAR1)
                        .addGap(7, 7, 7)
                        .addComponent(btEXIT))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jnrotarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jContinuar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCancelar)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btBACK)
                    .addComponent(btMINIMIZAR1)
                    .addComponent(btEXIT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jContinuar)
                    .addComponent(jnrotarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        Tarifas TF = new Tarifas();
        this.dispose();
        TF.setVisible(true);
    }//GEN-LAST:event_btBACKMouseClicked

    private void tbtarifasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbtarifasFocusGained
        int indice = tbtarifas.getSelectedRow();
        indice++;
        jnrotarifa.setText(Integer.toString(indice));
    }//GEN-LAST:event_tbtarifasFocusGained

    private void tbtarifasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtarifasMouseClicked
        int indice = tbtarifas.getSelectedRow();
        indice++;
        jnrotarifa.setText(Integer.toString(indice));
    }//GEN-LAST:event_tbtarifasMouseClicked

    private void tbtarifasCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbtarifasCaretPositionChanged
        int indice = tbtarifas.getSelectedRow();
        indice++;
        jnrotarifa.setText(Integer.toString(indice));
    }//GEN-LAST:event_tbtarifasCaretPositionChanged

    private void jContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jContinuarActionPerformed
        if(jnrotarifa.getText().isEmpty() || jnrotarifa.getText().equals("0")){
            JOptionPane.showMessageDialog(null,"Se debe especificar un N° de tarifa");
        }else{
            EditarTarifa ED = new EditarTarifa(jnrotarifa.getText());
            this.dispose();
            ED.setVisible(true);   
        }
    }//GEN-LAST:event_jContinuarActionPerformed

    private void jCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarActionPerformed
        Tarifas TF = new Tarifas();
        this.dispose();
        TF.setVisible(true);
    }//GEN-LAST:event_jCancelarActionPerformed

    private void jnrotarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnrotarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnrotarifaActionPerformed

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
            java.util.logging.Logger.getLogger(ConsTarParaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsTarParaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsTarParaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsTarParaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsTarParaEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btBACK;
    private javax.swing.JLabel btEXIT;
    private javax.swing.JLabel btMINIMIZAR1;
    private javax.swing.JButton jCancelar;
    private javax.swing.JButton jContinuar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jnrotarifa;
    private javax.swing.JTable tbtarifas;
    // End of variables declaration//GEN-END:variables
    conectar cc = new conectar();
    Connection cn = cc.ConexionMySql();
}
