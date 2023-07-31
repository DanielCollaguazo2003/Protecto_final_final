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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author XaviO_o
 */
public class ActualizarEmpleado extends javax.swing.JFrame {

    FondoPanel f = new FondoPanel();
   
    public ActualizarEmpleado() {
        f.ubi = "/imagenes/fondogrande.png";
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        direccionPrin = new javax.swing.JTextField();
        DireccionSecu = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        buscarAct = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        regreadd1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        permisosComboBox = new javax.swing.JComboBox<>();
        rolComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        FondoPanel f = new FondoPanel();
        f.ubi = "/imagenes/actualizar.png";
        jPanel1 = f;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(975, 695));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 119, 144));
        jLabel1.setText("ACTUALIZAR EMPLEADO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 340, 40));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel2.setText("Nombres:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, 20));

        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, 40));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel3.setText("Apellidos:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 70, 20));

        apellido.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 410, 40));

        jLabel4.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel4.setText("N° de Documento:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 20));

        jLabel5.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel5.setText("Correo Electronico:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 120, 20));

        correo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 400, 40));

        nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 400, 40));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel7.setText("Dirección Principal:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 20));

        direccionPrin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(direccionPrin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 400, 40));

        DireccionSecu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(DireccionSecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 410, 40));

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel8.setText("Dirección Secundaria:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 170, 20));

        jLabel9.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel9.setText("Telefono Convencional o Celular");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 200, 20));

        telefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 410, 40));

        buscarAct.setBackground(new java.awt.Color(255, 255, 253));
        buscarAct.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        buscarAct.setForeground(new java.awt.Color(28, 119, 144));
        buscarAct.setText("Buscar");
        buscarAct.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        buscarAct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarActMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarActMouseExited(evt);
            }
        });
        buscarAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActActionPerformed(evt);
            }
        });
        jPanel2.add(buscarAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 410, 40));

        Actualizar.setBackground(new java.awt.Color(255, 255, 253));
        Actualizar.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(28, 119, 144));
        Actualizar.setText("Actualizar");
        Actualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        Actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ActualizarMouseExited(evt);
            }
        });
        jPanel2.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 170, 50));

        regreadd1.setBackground(new java.awt.Color(255, 255, 253));
        regreadd1.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        regreadd1.setForeground(new java.awt.Color(28, 119, 144));
        regreadd1.setText("Regresar");
        regreadd1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        regreadd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regreadd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regreadd1MouseExited(evt);
            }
        });
        regreadd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regreadd1ActionPerformed(evt);
            }
        });
        jPanel2.add(regreadd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 170, 50));

        jLabel11.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel11.setText("Permisos");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 110, 20));

        permisosComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Administrados", "General", "Ninguno" }));
        jPanel2.add(permisosComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 200, 40));

        rolComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Empleado Atencion al Client", "Medico Veterinario" }));
        jPanel2.add(rolComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 190, 40));

        jLabel12.setFont(new java.awt.Font("Dubai Medium", 0, 14)); // NOI18N
        jLabel12.setText("Rol que cumple:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 900, 520));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarActMouseEntered
        buscarAct.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_buscarActMouseEntered

    private void buscarActMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarActMouseExited
        buscarAct.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_buscarActMouseExited

    private void buscarActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActActionPerformed

    private void ActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarMouseEntered
        Actualizar.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_ActualizarMouseEntered

    private void ActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarMouseExited
        Actualizar.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_ActualizarMouseExited

    private void regreadd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regreadd1MouseEntered
        regreadd1.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_regreadd1MouseEntered

    private void regreadd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regreadd1MouseExited
        regreadd1.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_regreadd1MouseExited

    private void regreadd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regreadd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regreadd1ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarEmpleado().setVisible(true);
            }
        });
    }

    public JComboBox<String> getPermisosComboBox() {
        return permisosComboBox;
    }

    public JComboBox<String> getRolComboBox() {
        return rolComboBox;
    }
    
    
     public void listenerBuscarEmpleado(ActionListener l){
        buscarAct.addActionListener(l);
    }
    
    public void listenerActualizarEmpleado(ActionListener l){
        Actualizar.addActionListener(l);
    }

    public JTextField getDireccionSecu() {
        return DireccionSecu;
    }

    public JTextField getApellido() {
        return apellido;
    }

    public JTextField getCorreo() {
        return correo;
    }

    public JTextField getDireccionPrin() {
        return direccionPrin;
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getTelefono() {
        return telefono;
    }

    public JTextField getId() {
        return id;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JTextField DireccionSecu;
    private javax.swing.JTextField apellido;
    private javax.swing.JButton buscarAct;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direccionPrin;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> permisosComboBox;
    private javax.swing.JButton regreadd1;
    private javax.swing.JComboBox<String> rolComboBox;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
