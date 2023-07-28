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
import modelo.DefaultTablaClientes;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class conexionClientes {
    String sSQL = "";
    ConexionOracle conexion;
    Connection con;

    public conexionClientes( ConexionOracle conexion, Connection con) {
        this.conexion = conexion;
        this.con = con;
    }

    public DefaultListaClientes obtenerClientes(DefaultListaClientes lisCli) {
        try {
            
            sSQL = "SELECT * FROM vt_clientes c, vt_personas p WHERE (c.per_codigo=p.per_codigo) AND (c.cli_estado='A')";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Cliente c = new Cliente(res.getString("cli_estado"),
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
    
}
