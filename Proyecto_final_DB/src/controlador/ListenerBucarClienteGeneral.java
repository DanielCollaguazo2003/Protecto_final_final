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
import modelo.Cliente;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class ListenerBucarClienteGeneral implements ActionListener{
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    VistaGeneralSistema vGeneral;
    Cliente cli = null;
    public ListenerBucarClienteGeneral(ConexionOracle conexion, Connection con, VistaGeneralSistema vGeneral) {
        this.conexion = conexion;
        this.con = con;
        this.vGeneral = vGeneral;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String cedula = vGeneral.getCedulacam().getText();
            ps = con.prepareStatement("SELECT * FROM veterinaria.vt_clientes c, veterinaria.vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
            ps.setString(1, cedula);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                String estado = res.getString("cli_estado");
                String nombre = res.getString("per_nombre");
                String apellido = res.getString("per_apellido");
                String cedulaCli = res.getString("per_cedula");
                String direccion_p = res.getString("per_direccion_principal");
                String direccion_s = res.getString("per_direccion_secundaria");
                String telefono = res.getString("per_telefono");
                String correo = res.getString("per_correo_electronico");
                cli = new Cliente(estado, cedulaCli, nombre, apellido, direccion_p, direccion_s, telefono, correo);
                
                vGeneral.getNombreGen().setText(cli.getNombre()+" "+cli.getApellido());
                vGeneral.getCedulaGen().setText(cli.getCedula());
                vGeneral.getDireccionGen().setText(cli.getDireccion_p()+" "+cli.getDireccion_s());
                vGeneral.getTelefonoGen().setText(cli.getTelefono());
                vGeneral.getCorreoGen().setText(cli.getCorreo());

            }

            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(vGeneral, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }
    
    public Cliente getCliente(){
        return cli;
    }
    
}
