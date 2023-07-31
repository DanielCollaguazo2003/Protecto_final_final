/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import modelo.DefaultListaServicios;
import modelo.DefaultTablaClientes;
import modelo.Servicio;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class conexionTablas {

    String sSQL = "";
    ConexionOracle conexion;
    Connection con;

    public conexionTablas(ConexionOracle conexion, Connection con) {
        this.conexion = conexion;
        this.con = con;
    }

    public DefaultListaClientes obtenerClientes(DefaultListaClientes lisCli) {
        try {

            sSQL = "SELECT * FROM veterinaria.vt_clientes c, veterinaria.vt_personas p WHERE (c.per_codigo=p.per_codigo) AND (c.cli_estado='A')";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Cliente c = new Cliente(res.getString("cli_estado"),
                        res.getInt("cli_codigo"),
                        res.getString("per_cedula"),
                        res.getString("per_nombre"),
                        res.getString("per_apellido"),
                        res.getString("per_direccion_principal"),
                        res.getString("per_direccion_secundaria"),
                        res.getString("per_telefono"),
                        res.getString("per_correo_electronico"));
                lisCli.addElement(c);
                System.out.println(c.toString());
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

        return lisCli;
    }

    public DefaultListaServicios obtenerServicios(DefaultListaServicios listSer) {
        try {

            sSQL = "SELECT * FROM veterinaria.vt_servicios";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Servicio s = new Servicio(res.getInt("ser_codigo"),
                        res.getString("ser_nombre"),
                        res.getString("ser_descripcion"),
                        res.getFloat("ser_precio"),
                        res.getString("ser_iva"));

                listSer.addElement(s);
                System.out.println(s);
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

        return listSer;
    }

}
