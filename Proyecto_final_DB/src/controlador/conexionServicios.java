/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Cliente;
import modelo.DefaultListaServicios;
import modelo.Servicio;

/**
 *
 * @author Jeiso
 */
public class conexionServicios {
    String sSQL = "";
    ConexionOracle conexion;
    Connection con;

    public conexionServicios(ConexionOracle conexion, Connection con) {
        this.conexion = conexion;
        this.con = con;
    }
    
    public DefaultListaServicios obtenerServicios (DefaultListaServicios listSer){
        try {
            
            sSQL = "SELECT * FROM vt_servicios";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Servicio s = new Servicio(res.getInt("ser_codigo"),
                                    res.getString("ser_nombre"),
                                    res.getString("ser_descripcion"),
                                    res.getFloat("ser_precio"),
                                    res.getString("ser_iva"));
                                    
                listSer.addServicio(s);
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
