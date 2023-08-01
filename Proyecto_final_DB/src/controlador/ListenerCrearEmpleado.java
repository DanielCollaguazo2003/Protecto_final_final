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
import modelo.DefaultListaEmplados;
import modelo.Empleado;
import modelo.Permiso;
import vista.CrearEmpleados;
import vista.Empleados;

/**
 *
 * @author Anthony Moya
 */
public class ListenerCrearEmpleado implements ActionListener {

    Connection con;
    CrearEmpleados ce;
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    DefaultListaEmplados defaultListaEmplados;
    Empleados empVista;
    ListenerCrearClienteSistema lcs;
    Empleado e;

    public ListenerCrearEmpleado(Connection con, CrearEmpleados ce, ConexionOracle conexion, DefaultListaEmplados defaultListaEmplados, Empleados empVista, ListenerCrearClienteSistema lcs) {
        this.con = con;
        this.ce = ce;
        this.conexion = conexion;
        this.defaultListaEmplados = defaultListaEmplados;
        this.empVista = empVista;
        this.lcs = lcs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String permiso = (String) ce.getjComboBoxPermiso().getSelectedItem();
        String rol = (String) ce.getjComboBoxRol().getSelectedItem();
        char codigoRol = rol.charAt(0);
        boolean validarCedula = lcs.idValidator(ce.getjTextFieldNDoc().getText());
        boolean validacionMail = lcs.correoValidator(ce.getjTextFieldCorreo().getText());
        String valVet = (String) ce.getjComboBoxRol().getSelectedItem();
        if (validarCedula == true && validacionMail == true && validacion() == true) {
            if (valVet.equals(("Veterinario")) && (permiso.equals("Administrador") || permiso.equals("General"))) {
                JOptionPane.showMessageDialog(ce, "Un veterinario no puede tener Permisos Administativos o Generales");
            } else {
                ingresoPersonas(0);
                int codigoPersona = extraercodigoPersona();
                int codigoPermiso = extraerCodigoPermiso(permiso);
                ingresoEmpleados(codigoPermiso, codigoPersona, codigoRol);
                conexionTablas conTablas = new conexionTablas(conexion, con);
                defaultListaEmplados.clearAllElements();
                conTablas.obtenerEmpleados(defaultListaEmplados);
            }
        } else {
            JOptionPane.showMessageDialog(ce, "Datos Invalidos");
        }
    }

    public boolean validacion() {
        return !"".equals(ce.getjTextFieldNDoc().getText())
                && !"".equals(ce.getjTextFieldNombres().getText()) && !"".equals(ce.getjTextFieldApellidos().getText())
                && !"".equals(ce.getjTextFieldCorreo().getText()) && !"".equals(ce.getjTextFieldDirPrincipal().getText())
                && !"".equals(ce.getjTextFieldDirSec().getText()) && !"".equals(ce.getjTextFieldNumCell().getText())
                && !"seleccionar".equals((String) ce.getjComboBoxPermiso().getSelectedItem());
    }

    public void ingresoPersonas(int codigo) {
        String cedula = ce.getjTextFieldNDoc().getText();
        String nombre = ce.getjTextFieldNombres().getText();
        String apellido = ce.getjTextFieldApellidos().getText();
        String correo = ce.getjTextFieldCorreo().getText();
        String direccion_p = ce.getjTextFieldDirPrincipal().getText();
        String direccion_s = ce.getjTextFieldDirSec().getText();
        String telefono = ce.getjTextFieldNumCell().getText();
        try {
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_personas VALUES(veterinaria.proximo_valor_per_seq, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion_p);
            ps.setString(5, direccion_s);
            ps.setString(6, telefono);
            ps.setString(7, correo);

            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(ce, "Usuario Ingresado con Exito");

            } else {
                JOptionPane.showMessageDialog(ce, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int extraercodigoPersona() {
        int codigo = 0;
        try {
            sSQL = "SELECT per_codigo FROM veterinaria.vt_personas ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("per_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }

    private int extraerCodigoPermiso(String rol) {
        int codigo = 0;
        try {
            ps = con.prepareStatement("""
                                      SELECT prm_codigo FROM veterinaria.vt_permisos
                                      WHERE prm_nombre LIKE (?)""");
            ps.setString(1, rol);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                codigo = res.getInt("prm_codigo");
            }
            res = ps.executeQuery();
            if (res.next() == false) {
                JOptionPane.showMessageDialog(ce, "Error!");
            }
        } catch (SQLException x) {
            System.out.println(x);

        }
        return codigo;
    }

    public void ingresoEmpleados(int extraerCodigoPermiso, int extraerCodigoPersona, char tipoRol) {
        try {
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_empleados VALUES(veterinaria.proximo_valor_emp_seq, ?, ?, ?)");
            ps.setObject(1, tipoRol);
            ps.setInt(2, extraerCodigoPersona);
            ps.setInt(3, extraerCodigoPermiso);

            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(ce, "Empleado Ingresado con Exito");

            } else {
                JOptionPane.showMessageDialog(ce, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
