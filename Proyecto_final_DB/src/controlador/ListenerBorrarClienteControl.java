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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import modelo.DefaultTablaClientes;
import vista.Clientes;
import vista.CrearClientes;

/**
 *
 * @author Anthony Moya
 */
public class ListenerBorrarClienteControl implements ActionListener {

    Clientes c;
    Connection con;
    CrearClientes cr;
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    DefaultListaClientes listaClientes;
    DefaultTablaClientes defaultTableClientes;

    public ListenerBorrarClienteControl(Clientes c, Connection con, CrearClientes cr, ConexionOracle conexion, DefaultListaClientes listaClientes) {
        this.c = c;
        this.con = con;
        this.cr = cr;
        this.conexion = conexion;
        this.listaClientes = listaClientes;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        extraerFacturasClientes();
    }

    private void extraerFacturasClientes() {
        int cliente = 0;
        int cantidadFacturas = 0;
        int fila = c.getTablaClientes().getSelectedRow();
        int codigoCliente = (int) c.getTablaClientes().getValueAt(fila, 0);
        try {
            ps = con.prepareStatement("""
                                      SELECT c.cli_codigo as cliente, nvl(COUNT(cf.fac_codigo),0) as numFac
                                      FROM veterinaria.vt_clientes c, veterinaria.vt_cabeceras_facturas cf
                                      WHERE (c.cli_codigo = cf.cli_codigo(+)) AND c.cli_codigo = ?
                                      GROUP BY c.cli_codigo""");
            ps.setInt(1, codigoCliente);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                cliente = res.getInt("cliente");
                cantidadFacturas = res.getInt("numFac");
            }
            res = ps.executeQuery();
            if (res.next() == false) {
                JOptionPane.showMessageDialog(c, "Error!");
            }

            if (cantidadFacturas == 0) {
                borrarUsuario(cliente);

            } else {
                desactivarUsuario(cliente);
            }
            Cliente cli = listaClientes.getElementAt(fila);
            listaClientes.fireIntervalRemoved(cli, fila);
            c.repaint();
        } catch (SQLException x) {
            System.out.println(x);

        }
    }

    public void borrarUsuario(int cliente) {
        try {
            ps = con.prepareStatement("""
                                      DELETE FROM veterinaria.vt_clientes
                                      WHERE cli_codigo = ? """);
            ps.setInt(1, cliente);

            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(cr, "Usuario Eliminado con Exito");

            } else {
                JOptionPane.showMessageDialog(cr, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactivarUsuario(int cliente) {
        try {
            ps = con.prepareStatement("""
                                      UPDATE veterinaria.vt_clientes
                                      SET cli_estado = 'I'
                                      WHERE cli_codigo = ?""");
            ps.setInt(1, cliente);

            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(cr, "Usuario Desactivado con Exito");
            } else {
                JOptionPane.showMessageDialog(cr, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
