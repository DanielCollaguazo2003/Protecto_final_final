/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionListener;
import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.ActualizarCliente;
/**
 *
 * @author XaviO_o
 */
public class ListenerActualizarActualizar implements ActionListener{

    PreparedStatement ps = null;
    ConexionOracle conexion;
    Connection con;
    ActualizarCliente actualizarCli;
    ListenerBucarActualizar labc;

    public ListenerActualizarActualizar(ConexionOracle conexion, Connection con, ActualizarCliente actualizarCli) {
        this.conexion = conexion;
        this.con = con;
        this.actualizarCli = actualizarCli;
        this.labc = new ListenerBucarActualizar(conexion, con, actualizarCli);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String cedula = actualizarCli.getId().getText();
            String nombre = actualizarCli.getNombre().getText();
            String apellido = actualizarCli.getApellido().getText();
            String direcP = actualizarCli.getDireccionPrin().getText();
            String direcS = actualizarCli.getDireccionSecu().getText();
            String telef = actualizarCli.getTelefono().getText();
            String correo = actualizarCli.getCorreo().getText();
            int codigoCli = labc.getCodigoCliente(cedula);

            String sentencia = "UPDATE veterinaria.vt_personas p SET p.per_cedula = ?, p.per_nombre = ?,"
                    + " p.per_apellido = ?, p.per_direccion_principal = ?,"
                    + " p.per_direccion_secundaria = ?, p.per_telefono = ?,"
                    + " p.per_correo_electronico = ? WHERE EXISTS (SELECT 1"
                    + " FROM veterinaria.vt_clientes c"
                    + " WHERE p.per_codigo = c.per_codigo"
                    + " AND c.cli_codigo = ? )";

            ps = con.prepareStatement(sentencia);

            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direcP);
            ps.setString(5, direcS);
            ps.setString(6, telef);
            ps.setString(7, correo);
            ps.setInt(8, codigoCli);

            System.out.println("El codigo es " + codigoCli);

            int tuplaejecutada = ps.executeUpdate();
            con.setAutoCommit(false);
            ps.close();
            
            if (tuplaejecutada == 1) {
                con.commit();
                JOptionPane.showMessageDialog(actualizarCli, "Actualizado Exitosamente!!");
                actualizarCli.getApellido().setText("");
                actualizarCli.getNombre().setText("");
                actualizarCli.getId().setText("");
                actualizarCli.getTelefono().setText("");
                actualizarCli.getDireccionPrin().setText("");
                actualizarCli.getDireccionSecu().setText("");
                actualizarCli.getCorreo().setText("");
                actualizarCli.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(actualizarCli, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(actualizarCli, "Error al actualizar la Base de Datos");
            
        }

    }
    
}
