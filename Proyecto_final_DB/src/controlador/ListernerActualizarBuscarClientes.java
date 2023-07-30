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
 * @author mateo
 */
public class ListernerActualizarBuscarClientes implements ActionListener {

    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    ActualizarCliente actualizarCli;
    Cliente cli = null;
    int codigoCli;

    public ListernerActualizarBuscarClientes(ConexionOracle conexion, Connection con, ActualizarCliente actualizarCli) {
        this.conexion = conexion;
        this.con = con;
        this.actualizarCli = actualizarCli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String cedula = actualizarCli.getId().getText();
            ps = con.prepareStatement("SELECT * FROM vt_clientes c, vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
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

                cli = new Cliente(estado, cedulaCli, nombre, apellido, direccion_p, direccion_s, telefono, correo);

                actualizarCli.getNombre().setText(cli.getNombre());
                actualizarCli.getApeliido().setText(cli.getApellido());
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
        ps = con.prepareStatement("SELECT cli_codigo FROM vt_clientes c, vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
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
