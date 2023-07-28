/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author XaviO_o
 */
public class VistaLogin extends javax.swing.JFrame {

    /**
     * Creates new form VistaLogin
     */
    public VistaLogin() {
        initComponents();
        //this.setExtendedState(6);
        this.setLocationRelativeTo(null);
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
        user = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        remember = new javax.swing.JCheckBox();
        olvido = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        create = new javax.swing.JButton();
        sesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(799, 599));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 380, 40));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 380, 40));

        jLabel7.setForeground(new java.awt.Color(73, 80, 87));
        jLabel7.setText("Contraseña");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 70, -1));

        jLabel6.setForeground(new java.awt.Color(73, 80, 87));
        jLabel6.setText("Usuario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        remember.setForeground(new java.awt.Color(73, 80, 87));
        remember.setText("Recuerdame");
        remember.setBorder(null);
        remember.setContentAreaFilled(false);
        jPanel1.add(remember, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        olvido.setForeground(new java.awt.Color(116, 120, 141));
        olvido.setText("¿Olvidaste la contraseña?");
        olvido.setBorder(null);
        olvido.setBorderPainted(false);
        olvido.setContentAreaFilled(false);
        olvido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                olvidoActionPerformed(evt);
            }
        });
        jPanel1.add(olvido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 190, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, -1));

        create.setBackground(new java.awt.Color(255, 252, 252));
        create.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        create.setForeground(new java.awt.Color(0, 116, 165));
        create.setText("Crear Usuario");
        create.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createMouseExited(evt);
            }
        });
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel1.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 180, 40));

        sesion.setBackground(new java.awt.Color(255, 252, 255));
        sesion.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        sesion.setForeground(new java.awt.Color(0, 116, 165));
        sesion.setText("Iniciar sesión");
        sesion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sesionMouseExited(evt);
            }
        });
        sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesionActionPerformed(evt);
            }
        });
        jPanel1.add(sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 180, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cabecera2_0.png"))); // NOI18N
        jLabel1.setToolTipText("");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 420, 400));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondopatas.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void olvidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olvidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_olvidoActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createActionPerformed

    private void sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sesionActionPerformed

    private void sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionMouseEntered
       sesion.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_sesionMouseEntered

    private void sesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sesionMouseExited
        sesion.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_sesionMouseExited

    private void createMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseExited
        create.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_createMouseExited

    private void createMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseEntered
        create.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_createMouseEntered

    public void listener_login(ActionListener l){
       sesion.addActionListener(l);
    }

    public JPasswordField getPassword() {
        return password;
    }

    public JTextField getUser() {
        return user;
    }
     
    public void listenerCrearUser(ActionListener l){
        create.addActionListener(l);
    }

    public JButton getSesion() {
        return sesion;
    }
    
    //Metodo para iniciar sesion por una tecla
    public void listenerIniSesion(KeyListener l){
        sesion.addKeyListener(l);
    }    
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
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton olvido;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox remember;
    private javax.swing.JButton sesion;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
