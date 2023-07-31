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
import modelo.Empleado;
import modelo.Permiso;
import vista.ActualizarCliente;
import vista.ActualizarEmpleado;

/**
 *
 * @author XaviO_o
 */
public class ListenerBuscarActualizarEmpleado implements ActionListener {

    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    ActualizarEmpleado actualizarEmp;
    Empleado emp = null;
    int codigoEmp;
    Permiso per = null;

    public ListenerBuscarActualizarEmpleado(ConexionOracle conexion, Connection con, ActualizarEmpleado actualizarEmp) {
        this.conexion = conexion;
        this.con = con;
        this.actualizarEmp = actualizarEmp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            int index = 0;
            String cedula = actualizarEmp.getId().getText();
            ps = con.prepareStatement("""
                                      SELECT * 
                                      FROM veterinaria.vt_empleados e, veterinaria.vt_personas p, veterinaria.vt_permisos pr 
                                      WHERE (e.per_codigo=p.per_codigo) and (pr.prm_codigo=e.prm_codigo) and  (p.per_cedula=?)
                                      """);
            ps.setString(1, cedula);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                codigoEmp = res.getInt("emp_codigo");
                int prmCodigo = res.getInt("prm_codigo");
                String nombre = res.getString("per_nombre");
                String apellido = res.getString("per_apellido");
                String cedulaEmp = res.getString("per_cedula");
                String direccion_p = res.getString("per_direccion_principal");
                String direccion_s = res.getString("per_direccion_secundaria");
                String telefono = res.getString("per_telefono");
                String correo = res.getString("per_correo_electronico");
                String tipo = res.getString("emp_tipo");

                per = extraerPermiso(prmCodigo);
                emp = new Empleado(tipo, codigoEmp, per, cedulaEmp, nombre, apellido, direccion_p, direccion_s, telefono, correo);

                actualizarEmp.getNombre().setText(emp.getNombre());
                actualizarEmp.getApellido().setText(emp.getApellido());
                actualizarEmp.getDireccionPrin().setText(emp.getDireccion_p());
                actualizarEmp.getDireccionSecu().setText(emp.getDireccion_s());
                actualizarEmp.getTelefono().setText(emp.getTelefono());
                actualizarEmp.getCorreo().setText(emp.getCorreo());
                if (emp.getTipo().equals("C")) {
                    index = 1;
                } else if (emp.getTipo().equals("C")) {
                    index = 2;
                }
                actualizarEmp.getRolComboBox().setSelectedIndex(index);
                actualizarEmp.getPermisosComboBox().setSelectedIndex(per.getCodigo_permiso());

            }
            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(actualizarEmp, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

    }

    public int getCodigoCliente(String cliente) throws SQLException {
        int codigoCliente = -1; // Valor predeterminado en caso de que el cliente no se encuentre

        String cedula = actualizarEmp.getId().getText();
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

    private Permiso extraerPermiso(int codigoPermiso) {
        try {
            ps = con.prepareStatement("""
                                      SELECT * 
                                      FROM veterinaria.vt_permisos 
                                      WHERE prm_codigo = ?;
                                      """);
            ps.setInt(1, codigoPermiso);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                int perCodigo = res.getInt("per_codigo");
                String perNombre = res.getString("cli_estado");
                String perDescripcion = res.getString("per_nombre");

                per = new Permiso(perCodigo, perNombre, perDescripcion);
            }

            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(actualizarEmp, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return per;
    }
}
