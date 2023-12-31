/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author XaviO_o
 */
public class CrearClientes extends javax.swing.JFrame {

    FondoPanel f = new FondoPanel();
    public CrearClientes() {
        f.ubi="/imagenes/fondogrande.png";
        this.setContentPane(f);
        initComponents();
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

        FondoPanel f = new FondoPanel();
        f.ubi = "/imagenes/añadir.png";
        jPanel1 = f;
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNDoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCorreoRep = new javax.swing.JTextField();
        jComboBoxCodigoP = new javax.swing.JComboBox<>();
        jTextFieldNombres = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDirPrincipal = new javax.swing.JTextField();
        jTextFieldDirSec = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldNumCell = new javax.swing.JTextField();
        jComboBoxTipoDoc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        regreadd = new javax.swing.JButton();
        crearadd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(975, 695));
        setMinimumSize(new java.awt.Dimension(975, 695));
        setPreferredSize(new java.awt.Dimension(975, 695));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 100));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 119, 144));
        jLabel1.setText("DATOS DEL CLIENTE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 340, 40));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, 20));

        jTextFieldNDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldNDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 410, 40));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 70, 20));

        jTextFieldApellidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 410, 40));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("N° de Documento:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 120, 20));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Correo Electronico:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 20));

        jTextFieldCorreo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 400, 40));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel6.setText("Repetir Correo Electronico:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 170, 20));

        jTextFieldCorreoRep.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldCorreoRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 410, 40));

        jComboBoxCodigoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+593", "+095", "+895" }));
        jComboBoxCodigoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCodigoPActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxCodigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 130, 40));

        jTextFieldNombres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 400, 40));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Dirección Principal:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 20));

        jTextFieldDirPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldDirPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 400, 40));

        jTextFieldDirSec.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldDirSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 410, 40));

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel8.setText("Dirección Secundaria:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 170, 20));

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel9.setText("Telefono Convencional o Celular");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, 20));

        jTextFieldNumCell.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(jTextFieldNumCell, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 270, 40));

        jComboBoxTipoDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cedula" }));
        jComboBoxTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoDocActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, 40));

        jLabel11.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel11.setText("Tipo de Documento:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 20));

        regreadd.setBackground(new java.awt.Color(255, 255, 253));
        regreadd.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        regreadd.setForeground(new java.awt.Color(28, 119, 144));
        regreadd.setText("Regresar");
        regreadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        regreadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regreaddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regreaddMouseExited(evt);
            }
        });
        regreadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regreaddActionPerformed(evt);
            }
        });
        jPanel2.add(regreadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 140, 40));

        crearadd.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        crearadd.setForeground(new java.awt.Color(28, 119, 144));
        crearadd.setText("Crear");
        crearadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        crearadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearaddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearaddMouseExited(evt);
            }
        });
        jPanel2.add(crearadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, 140, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 900, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCodigoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCodigoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCodigoPActionPerformed

    private void jComboBoxTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoDocActionPerformed

    private void regreaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regreaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regreaddActionPerformed

    private void crearaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearaddMouseExited
        crearadd.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_crearaddMouseExited

    private void crearaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearaddMouseEntered
        crearadd.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_crearaddMouseEntered

    private void regreaddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regreaddMouseExited
        regreadd.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_regreaddMouseExited

    private void regreaddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regreaddMouseEntered
        regreadd.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_regreaddMouseEntered
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
            java.util.logging.Logger.getLogger(CrearClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearClientes().setVisible(true);
            }
        });
    }

    public JComboBox<String> getjComboBoxCodigoP() {
        return jComboBoxCodigoP;
    }

    public void setjComboBoxCodigoP(JComboBox<String> jComboBoxCodigoP) {
        this.jComboBoxCodigoP = jComboBoxCodigoP;
    }

    public JComboBox<String> getjComboBoxTipoDoc() {
        return jComboBoxTipoDoc;
    }

    public void setjComboBoxTipoDoc(JComboBox<String> jComboBoxTipoDoc) {
        this.jComboBoxTipoDoc = jComboBoxTipoDoc;
    }

    public JTextField getjTextFieldApellidos() {
        return jTextFieldApellidos;
    }

    public void setjTextFieldApellidos(JTextField jTextFieldApellidos) {
        this.jTextFieldApellidos = jTextFieldApellidos;
    }

    public JTextField getjTextFieldCorreo() {
        return jTextFieldCorreo;
    }

    public void setjTextFieldCorreo(JTextField jTextFieldCorreo) {
        this.jTextFieldCorreo = jTextFieldCorreo;
    }

    public JTextField getjTextFieldCorreoRep() {
        return jTextFieldCorreoRep;
    }

    public void setjTextFieldCorreoRep(JTextField jTextFieldCorreoRep) {
        this.jTextFieldCorreoRep = jTextFieldCorreoRep;
    }

    public JTextField getjTextFieldDirPrincipal() {
        return jTextFieldDirPrincipal;
    }

    public void setjTextFieldDirPrincipal(JTextField jTextFieldDirPrincipal) {
        this.jTextFieldDirPrincipal = jTextFieldDirPrincipal;
    }

    public JTextField getjTextFieldDirSec() {
        return jTextFieldDirSec;
    }

    public void setjTextFieldDirSec(JTextField jTextFieldDirSec) {
        this.jTextFieldDirSec = jTextFieldDirSec;
    }

    public JTextField getjTextFieldNDoc() {
        return jTextFieldNDoc;
    }

    public void setjTextFieldNDoc(JTextField jTextFieldNDoc) {
        this.jTextFieldNDoc = jTextFieldNDoc;
    }

    public JTextField getjTextFieldNombres() {
        return jTextFieldNombres;
    }

    public void setjTextFieldNombres(JTextField jTextFieldNombres) {
        this.jTextFieldNombres = jTextFieldNombres;
    }

    public JTextField getjTextFieldNumCell() {
        return jTextFieldNumCell;
    }

    public void setjTextFieldNumCell(JTextField jTextFieldNumCell) {
        this.jTextFieldNumCell = jTextFieldNumCell;
    }

    
    
    public void addActionListenerCrear(ActionListener a) {
        regreadd.addActionListener(a);
    }
    
    public void addActionListenerCrearUsuario(ActionListener a){
        crearadd.addActionListener(a);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearadd;
    private javax.swing.JComboBox<String> jComboBoxCodigoP;
    private javax.swing.JComboBox<String> jComboBoxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldCorreoRep;
    private javax.swing.JTextField jTextFieldDirPrincipal;
    private javax.swing.JTextField jTextFieldDirSec;
    private javax.swing.JTextField jTextFieldNDoc;
    private javax.swing.JTextField jTextFieldNombres;
    private javax.swing.JTextField jTextFieldNumCell;
    private javax.swing.JButton regreadd;
    // End of variables declaration//GEN-END:variables
}
