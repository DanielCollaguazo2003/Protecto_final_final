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
import modelo.Empleado;
import modelo.Servicio;
import modelo.Tipo_Mascota;
import vista.Citas;
import vista.Clientes;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class ControladorBox {
    VistaGeneralSistema vGeneral;
    Citas vCitas;
            
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    Servicio s = null;
    Tipo_Mascota t = null;
    Empleado e = null;
    ArrayList<Servicio> listServicios;
    ArrayList<Tipo_Mascota> listTipMascotas;

    public ControladorBox(VistaGeneralSistema vGeneral, Citas vCitas, ConexionOracle conexion, Connection con) {
        this.vGeneral = vGeneral;
        this.conexion = conexion;
        this.con = con;
        this.listServicios = new ArrayList<>();
        this.listTipMascotas = new ArrayList<>();
        this.vCitas = vCitas;
    }
    
    public void serviciosBoxList(){
        try {
            sSQL = "SELECT * FROM veterinaria.vt_servicios";
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
    
    public void tipoMascotaBox() {
        try {
            sSQL = "SELECT * FROM veterinaria.vt_tipos_mascotas";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            while (res.next()) {
                t = new Tipo_Mascota(res.getInt("tip_codigo"), res.getString("tip_nombre"));
                vCitas.getTipoMascota().addItem(t.getNombre());
                listTipMascotas.add(t);
            }
        } catch (SQLException x) {
            System.out.println(x);
        }
    }
    
    public void veterinariosBox() {
        try {
            sSQL = "SELECT emp_codigo, per_nombre||' '||per_apellido nombre " +
                    "FROM veterinaria.vt_personas p, veterinaria.vt_empleados e " +
                    "WHERE (p.per_codigo=e.per_codigo) AND (e.emp_tipo = 'V')";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);
            while (res.next()) {
                String veterinario = res.getInt("emp_codigo") + " " + res.getString("nombre");
                vCitas.getVeterinarioCitas().addItem(veterinario);
            }
        } catch (SQLException x) {
            System.out.println(x);
        }
    }
    
    public ArrayList<Servicio> getListServicios(){
        return listServicios;
    }
}
