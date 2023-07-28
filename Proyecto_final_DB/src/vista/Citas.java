/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

/**
 *
 * @author XaviO_o
 */
public class Citas extends javax.swing.JFrame {

    /**
     * Creates new form Citas
     */
    FondoPanel f = new FondoPanel();
    public Citas() {
        f.ubi = "/imagenes/fondogrande.png";
        this.setContentPane(f);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    class FondoPanel extends JPanel {

        Image img;        
        String ubi = "";
        @Override
        public void paint(Graphics g) {
            img = new ImageIcon(getClass().getResource(ubi)).getImage();
            
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    
        public void setUbi(String ubi) {
            this.ubi = ubi;
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

        FondoPanel f = new FondoPanel();
        f.ubi = "/imagenes/cabCitas.png";
        jPanel1 = f;
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        crearEmp = new javax.swing.JButton();
        crearEmp1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        crearEmp2 = new javax.swing.JButton();
        crearEmp3 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(870, 620));
        setMinimumSize(new java.awt.Dimension(870, 620));
        setPreferredSize(new java.awt.Dimension(870, 620));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 91));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 119, 144));
        jLabel1.setText("REGISTRO DE LAS CITAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 340, 30));

        crearEmp.setBackground(new java.awt.Color(255, 255, 253));
        crearEmp.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        crearEmp.setForeground(new java.awt.Color(28, 119, 144));
        crearEmp.setText("Buscar");
        crearEmp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        crearEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearEmpMouseExited(evt);
            }
        });
        jPanel2.add(crearEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 160, 40));

        crearEmp1.setBackground(new java.awt.Color(255, 255, 253));
        crearEmp1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        crearEmp1.setForeground(new java.awt.Color(28, 119, 144));
        crearEmp1.setText("Regresar");
        crearEmp1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        crearEmp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearEmp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearEmp1MouseExited(evt);
            }
        });
        jPanel2.add(crearEmp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 180, 40));

        jLabel11.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel11.setText("Fecha");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 120, 20));

        jComboBox2.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de mascota", "gato" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 350, 40));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("Correo Electronico:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 120, 20));

        jLabel2.setText("collaguazodaniel48@gmail.com");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 350, 40));

        jLabel3.setText("Daniel Collaguazo");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 350, 40));

        jTextField4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 350, 40));

        jLabel13.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel13.setText("Cliente C.I:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 120, 20));

        jDateChooser1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 180, 40));

        jLabel14.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel14.setText("Nombre de la Mascota:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 150, 20));

        jTextField5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 350, 40));

        jComboBox3.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione al Medico Veterinario", "Juan Casillas" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 350, 40));

        crearEmp2.setBackground(new java.awt.Color(255, 255, 253));
        crearEmp2.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        crearEmp2.setForeground(new java.awt.Color(28, 119, 144));
        crearEmp2.setText("Añadir Cliente");
        crearEmp2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        crearEmp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearEmp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearEmp2MouseExited(evt);
            }
        });
        jPanel2.add(crearEmp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, 180, 40));

        crearEmp3.setBackground(new java.awt.Color(255, 255, 253));
        crearEmp3.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        crearEmp3.setForeground(new java.awt.Color(28, 119, 144));
        crearEmp3.setText("Agendar");
        crearEmp3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        crearEmp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearEmp3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearEmp3MouseExited(evt);
            }
        });
        jPanel2.add(crearEmp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 230, 50));

        jComboBox4.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la Hora", "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00" }));
        jPanel2.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 150, 40));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Nombre:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 60, 20));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Hora:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 40, 20));

        jLabel12.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel12.setText("Veterinario:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 120, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 790, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmpMouseEntered
        crearEmp.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_crearEmpMouseEntered

    private void crearEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmpMouseExited
        crearEmp.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_crearEmpMouseExited

    private void crearEmp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmp1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmp1MouseEntered

    private void crearEmp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmp1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmp1MouseExited

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void crearEmp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmp2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmp2MouseEntered

    private void crearEmp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmp2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmp2MouseExited

    private void crearEmp3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmp3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmp3MouseEntered

    private void crearEmp3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmp3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_crearEmp3MouseExited

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
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearEmp;
    private javax.swing.JButton crearEmp1;
    private javax.swing.JButton crearEmp2;
    private javax.swing.JButton crearEmp3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}