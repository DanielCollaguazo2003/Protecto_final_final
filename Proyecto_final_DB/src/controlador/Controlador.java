/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.ComboBoxUI;
import modelo.Cliente;
import modelo.Servicio;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class Controlador {
    VistaGeneralSistema vGeneral;
    
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    Servicio s = null;
    ArrayList<Servicio> listServicios;

    public Controlador(VistaGeneralSistema vGeneral, ConexionOracle conexion, Connection con) {
        this.vGeneral = vGeneral;
        this.conexion = conexion;
        this.con = con;
        this.listServicios = new ArrayList<>();
        
    }
    
    public void serviciosBoxList(){
        try {
            sSQL = "SELECT * FROM vt_servicios";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            while (res.next()) {
                s = new Servicio(res.getInt("ser_codigo"), res.getString("ser_nombre"),res.getString("ser_descripcion"),res.getFloat("ser_precio"),res.getString("ser_iva"));
                vGeneral.getServicioBox().addItem(String.valueOf(s.getCodigo_s()) + " " + s.getNombre());
                listServicios.add(s);
            }
        } catch (SQLException x) {
            System.out.println(x);
        }
    }
    
    public ArrayList<Servicio> getListServicios(){
        return listServicios;
    }
}
