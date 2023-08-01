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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author XaviO_o
 */
public class Clientes extends javax.swing.JFrame {

    FondoPanel f = new FondoPanel();
    public Clientes() {
        
        f.ubi = "/imagenes/fondogrande.png";
        this.setContentPane(f);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        f.ubi = "/imagenes/controlClientes.png";
        jPanel1 = f;
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        ActualizarEmp = new javax.swing.JButton();
        crearEmp = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        eliminarEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1215, 780));
        setSize(new java.awt.Dimension(1215, 780));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 126));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(28, 119, 144));
        jLabel1.setText("CONTROL DE LOS CLIENTES");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 340, 30));

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1110, -1));

        ActualizarEmp.setBackground(new java.awt.Color(255, 255, 253));
        ActualizarEmp.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        ActualizarEmp.setForeground(new java.awt.Color(28, 119, 144));
        ActualizarEmp.setText("Actualizar");
        ActualizarEmp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        ActualizarEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ActualizarEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ActualizarEmpMouseExited(evt);
            }
        });
        jPanel2.add(ActualizarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 510, 230, 50));

        crearEmp.setBackground(new java.awt.Color(255, 255, 253));
        crearEmp.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        crearEmp.setForeground(new java.awt.Color(28, 119, 144));
        crearEmp.setText("Crear");
        crearEmp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        crearEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearEmpMouseExited(evt);
            }
        });
        jPanel2.add(crearEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 230, 50));

        jButton3.setBackground(new java.awt.Color(255, 255, 253));
        jButton3.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(28, 119, 144));
        jButton3.setText("Crear");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 230, 50));

        eliminarEmp.setBackground(new java.awt.Color(255, 255, 253));
        eliminarEmp.setFont(new java.awt.Font("Dubai Medium", 0, 24)); // NOI18N
        eliminarEmp.setForeground(new java.awt.Color(28, 119, 144));
        eliminarEmp.setText("Eliminar");
        eliminarEmp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(180, 245, 245), 2, true));
        eliminarEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarEmpMouseExited(evt);
            }
        });
        jPanel2.add(eliminarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 230, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1160, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    public void setModeloTabla(TableModel m) {
        tablaClientes.setModel(m);
    }
    private void crearEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmpMouseEntered
        crearEmp.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_crearEmpMouseEntered

    private void crearEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearEmpMouseExited
        crearEmp.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_crearEmpMouseExited

    private void eliminarEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarEmpMouseEntered
        eliminarEmp.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_eliminarEmpMouseEntered

    private void eliminarEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarEmpMouseExited
        eliminarEmp.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_eliminarEmpMouseExited

    private void ActualizarEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarEmpMouseEntered
        ActualizarEmp.setBackground(new Color(180,245,245));
    }//GEN-LAST:event_ActualizarEmpMouseEntered

    private void ActualizarEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarEmpMouseExited
        ActualizarEmp.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_ActualizarEmpMouseExited

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }
    
    public void addActionListenerBotonCrear(ActionListener a){
        crearEmp.addActionListener(a);
    }
    
    public void addActionListeneractuaizarCrear(ActionListener a){
        ActualizarEmp.addActionListener(a);
    }
    
    public void addActionListenerBotonEliminar(ActionListener a){
        eliminarEmp.addActionListener(a);
    }

    public JTable getTablaClientes() {
        return tablaClientes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarEmp;
    private javax.swing.JButton crearEmp;
    private javax.swing.JButton eliminarEmp;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
