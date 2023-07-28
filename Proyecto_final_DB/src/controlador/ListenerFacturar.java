/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class ListenerFacturar implements ActionListener{
String sSQL = "";
    ConexionOracle conexion;
    VistaLogin vl;
    PreparedStatement ps = null;
    Connection con = conexion.conectar();
    VistaGeneralSistema vGeneral;
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    private void agregarFacturaBD(){
        try {
            
            ps = con.prepareStatement("INSERT INTO vt_cabeceras_facturas VALUES(det_codigo_seq, TO_TIMESTAMP('2022-05-03 15:14:09.654321', 'YYYY-MM-DD HH24:MI:SS.FF'), 12.3, 2.3, 14.6, 1, 3);");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                //JOptionPane.showMessageDialog(vl, "Inicio de sesion exitosa!");
                vl.setVisible(false);
                // vGeneral.setVisible(true);
                vl.getUser().setText("");
                vl.getPassword().setText("");
                verfificar = true;
                vGeneral.getUsuarioLabel().setText(res.getString("nombre") + "(" + res.getString("prm_nombre") + ")");
                conexion.desconectar();
                
            }
            
            res = ps.executeQuery();
            
            if (res.next() == false) {
                JOptionPane.showMessageDialog(vl, "Inicio de sesion Fallida!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }
}
