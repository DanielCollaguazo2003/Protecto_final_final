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
import vista.*;

/**
 *
 * @author XaviO_o
 */
public class ListenerBucarActualizar implements ActionListener{
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    ActualizarCliente actualizarCli;
    Cliente cli = null;
    int codigoCli;

    public ListenerBucarActualizar(ConexionOracle conexion, Connection con, ActualizarCliente actualizarCli) {
        this.conexion = conexion;
        this.con = con;
        this.actualizarCli = actualizarCli;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String cedula = actualizarCli.getId().getText();
            ps = con.prepareStatement("SELECT * FROM veterinaria.vt_clientes c, veterinaria.vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
            ps.setString(1, cedula);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                codigoCli = res.getInt("cli_codigo");
                String codigo = res.getString("per_codigo");
                String estado = res.getString("cli_estado");
                String nombre = res.getString("per_nombre");
                String apellido = res.getString("per_apellido");
                String cedulaCli = res.getString("per_cedula");
                String direccion_p = res.getString("per_direccion_principal");
                String direccion_s = res.getString("per_direccion_secundaria");
                String telefono = res.getString("per_telefono");
                String correo = res.getString("per_correo_electronico");

                cli = new Cliente(estado,codigoCli, cedulaCli, nombre, apellido, direccion_p, direccion_s, telefono, correo);

                actualizarCli.getNombre().setText(cli.getNombre());
                actualizarCli.getApellido().setText(cli.getApellido());
                actualizarCli.getId().setText(cli.getCedula());
                actualizarCli.getDireccionPrin().setText(cli.getDireccion_p());
                actualizarCli.getDireccionSecu().setText(cli.getDireccion_s());
                actualizarCli.getTelefono().setText(cli.getTelefono());
                actualizarCli.getCorreo().setText(cli.getCorreo());

            }

            System.out.println("Al buscar el codigo " + codigoCli);
            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(actualizarCli, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

    }

    public int getCodigoCliente(String cliente) throws SQLException {
        int codigoCliente = -1; // Valor predeterminado en caso de que el cliente no se encuentre

        String cedula = actualizarCli.getId().getText();
        ps = con.prepareStatement("SELECT cli_codigo FROM veterinaria.vt_clientes c, veterinaria.vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
        ps.setString(1, cedula);
        ResultSet res = ps.executeQuery();

        if (res.next()) {
            codigoCliente = res.getInt("cli_codigo");
        }

        res.close();
        ps.close();

        return codigoCliente;
    }

}
