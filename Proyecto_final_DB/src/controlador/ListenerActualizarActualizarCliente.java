package controlador;

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
 * @author mateo
 */
public class ListenerActualizarActualizarCliente implements ActionListener {

    PreparedStatement ps = null;
    ConexionOracle conexion;
    Connection con;
    ActualizarCliente actualizarCli;
    ListernerActualizarBuscarClientes labc;

    public ListenerActualizarActualizarCliente(ConexionOracle conexion, Connection con, ActualizarCliente actualizarCli) {
        this.conexion = conexion;
        this.con = con;
        this.actualizarCli = actualizarCli;
        this.labc = new ListernerActualizarBuscarClientes(conexion, con, actualizarCli);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String cedula = actualizarCli.getId().getText();
            String nombre = actualizarCli.getNombre().getText();
            String apellido = actualizarCli.getApeliido().getText();
            String direcP = actualizarCli.getDireccionPrin().getText();
            String direcS = actualizarCli.getDireccionSecu().getText();
            String telef = actualizarCli.getTelefono().getText();
            String correo = actualizarCli.getCorreo().getText();
            int codigoCli = labc.getCodigoCliente(cedula);

            String sentencia = "UPDATE veterinaria.vt_personas p SET p.per_cedula = ?, p.per_nombre = ?,"
                    + " p.per_apellido = ?, p.per_direccion_principal = ?,"
                    + " p.per_direccion_secundaria = ?, p.per_telefono = ?,"
                    + " p.per_correo_electronico = ? WHERE EXISTS (SELECT 1"
                    + " FROM vt_clientes c"
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
            ps.close();

        } catch (SQLException ex) {
            System.out.println("Ocurrio un error");
            JOptionPane.showMessageDialog(actualizarCli, "Error al actualizar la Base de Datos");
            
        }

    }

}
