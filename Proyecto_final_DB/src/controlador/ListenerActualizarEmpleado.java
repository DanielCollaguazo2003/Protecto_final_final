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

    public ListenerActualizarEmpleado(ConexionOracle conexion, Connection con, ListenerBuscarActualizarEmpleado lbusEmpAct) {
        this.conexion = conexion;
        this.con = con;
        this.lbusEmpAct = lbusEmpAct;
        this.lbusEmpAct = new ListenerBuscarActualizarEmpleado(conexion, con, actualizarEmp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
    
    private void actualizarPersona(){
        
        try {
            String cedula = actualizarEmp.getId().getText();
            String nombre = actualizarEmp.getNombre().getText();
            String apellido = actualizarEmp.getApellido().getText();
            String direcP = actualizarEmp.getDireccionPrin().getText();
            String direcS = actualizarEmp.getDireccionSecu().getText();
            String telef = actualizarEmp.getTelefono().getText();
            String correo = actualizarEmp.getCorreo().getText();
            int codigoCli = lbusEmpAct.getCodigoCliente(cedula);

            String sentencia = "UPDATE veterinaria.vt_personas p SET p.per_cedula = ?, p.per_nombre = ?,"
                    + " p.per_apellido = ?, p.per_direccion_principal = ?,"
                    + " p.per_direccion_secundaria = ?, p.per_telefono = ?,"
                    + " p.per_correo_electronico = ? WHERE EXISTS (SELECT 1"
                    + " FROM veterinaria.vt_clientes c"
                    + " WHERE p.per_codigo = c.per_codigo"
                    + " AND c.cli_codigo = ? )";

            ps = con.prepareStatement(sentencia);

            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direcP);
            ps.setString(5, direcS);
            ps.setString(6, telef);
            ps.setString(7, correo);
            ps.setInt(8, codigoCli);

            System.out.println("El codigo es " + codigoCli);

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
