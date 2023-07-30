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
import vista.Citas;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class ListenerBuscarClienteCitas implements ActionListener {

    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    Citas vCitas;
    Cliente cli = null;

    @Override
    public void actionPerformed(ActionEvent e) {
/*        try {

            String cedula = vCitas.getCedulacam().getText();
            ps = con.prepareStatement("SELECT * FROM veterinaria.vt_clientes c, veterinaria.vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
            ps.setString(1, cedula);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                String estado = res.getString("cli_estado");
                int codigo = res.getInt("cli_codigo");
                String nombre = res.getString("per_nombre");
                String apellido = res.getString("per_apellido");
                String cedulaCli = res.getString("per_cedula");
                String direccion_p = res.getString("per_direccion_principal");
                String direccion_s = res.getString("per_direccion_secundaria");
                String telefono = res.getString("per_telefono");
                String correo = res.getString("per_correo_electronico");
                cli = new Cliente(estado, codigo, cedulaCli, nombre, apellido, direccion_p, direccion_s, telefono, correo);

                vCitas.getNombreGen().setText(cli.getNombre() + " " + cli.getApellido());
                vCitas.getCedulaGen().setText(cli.getCedula());
                vCitas.getDireccionGen().setText(cli.getDireccion_p() + " " + cli.getDireccion_s());
                vCitas.getTelefonoGen().setText(cli.getTelefono());
                vCitas.getCorreoGen().setText(cli.getCorreo());

            }

            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(vCitas, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }*/
    }

}

