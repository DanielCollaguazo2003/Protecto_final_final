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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Empleado;
import vista.ActualizarCliente;
import vista.ActualizarEmpleado;

/**
 *
 * @author XaviO_o
 */
public class ListenerActualizarEmpleado implements ActionListener{
    
    PreparedStatement ps = null;
    ConexionOracle conexion;
    Connection con;
    ActualizarEmpleado actualizarEmp;
    ListenerBuscarActualizarEmpleado lbusEmpAct;
    Empleado emp= null;

    public ListenerActualizarEmpleado(ConexionOracle conexion, Connection con, ListenerBuscarActualizarEmpleado lbusEmpAct, ActualizarEmpleado actualizarEmp) {
        this.conexion = conexion;
        this.con = con;
        this.lbusEmpAct = lbusEmpAct;
        this.actualizarEmp = actualizarEmp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        emp = lbusEmpAct.getEmp();
        int cd =emp.getCodigo_p();
        actualizarPersona();

    }
    
    private void actualizarPersona(){
        
        try {
            String nombre = actualizarEmp.getNombre().getText();
            String apellido = actualizarEmp.getApellido().getText();
            String direcP = actualizarEmp.getDireccionPrin().getText();
            String direcS = actualizarEmp.getDireccionSecu().getText();
            String telef = actualizarEmp.getTelefono().getText();
            String correo = actualizarEmp.getCorreo().getText();
            int codigoCli = emp.getCodigo_p();

            String sentencia = """
                               UPDATE veterinaria.vt_personas p
                               SET (p.per_nombre, p.per_apellido, p.per_direccion_principal,
                                    p.per_direccion_secundaria, p.per_telefono, p.per_correo_electronico) =
                                    (SELECT ?, ?, ?, ?, ?, ?
                                     FROM veterinaria.vt_empleados e
                                     WHERE p.per_codigo = e.per_codigo AND e.emp_codigo = ?)
                               WHERE EXISTS (SELECT 1
                                             FROM veterinaria.vt_empleados e
                                             WHERE p.per_codigo = e.per_codigo AND e.emp_codigo = ?)
                               """;

            ps = con.prepareStatement(sentencia);

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, direcP);
            ps.setString(4, direcS);
            ps.setString(5, telef);
            ps.setString(6, correo);
            ps.setInt(7, codigoCli);
            ps.setInt(8, codigoCli);

            int tuplaejecutada = ps.executeUpdate();
            con.setAutoCommit(false);
            ps.close();            
            if (tuplaejecutada == 1) {
                con.commit();
                JOptionPane.showMessageDialog(actualizarEmp, "Actualizado Exitosamente!!");
                actualizarEmp.getApellido().setText("");
                actualizarEmp.getNombre().setText("");
                actualizarEmp.getId().setText("");
                actualizarEmp.getTelefono().setText("");
                actualizarEmp.getDireccionPrin().setText("");
                actualizarEmp.getDireccionSecu().setText("");
                actualizarEmp.getCorreo().setText("");
                actualizarEmp.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(actualizarEmp, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(actualizarEmp, "Error al actualizar la Base de Datos");
            
        }
    }
}
