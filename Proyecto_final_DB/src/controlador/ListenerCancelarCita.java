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
import modelo.DefaultListaCitas;
import modelo.Empleado;
import vista.ActualizarEmpleado;
import vista.VistaMostrarCitas;

/**
 *
 * @author XaviO_o
 */
public class ListenerCancelarCita implements ActionListener{
    PreparedStatement ps = null;
    ConexionOracle conexion;
    Connection con;
    ActualizarEmpleado actualizarEmp;
    ListenerBuscarActualizarEmpleado lbusEmpAct;
    Empleado emp= null;
    VistaMostrarCitas vMostrarCitas;
    DefaultListaCitas lisCitas;

    public ListenerCancelarCita(ConexionOracle conexion, Connection con, ActualizarEmpleado actualizarEmp, ListenerBuscarActualizarEmpleado lbusEmpAct, VistaMostrarCitas vMostrarCitas, DefaultListaCitas lisCitas) {
        this.conexion = conexion;
        this.con = con;
        this.actualizarEmp = actualizarEmp;
        this.lbusEmpAct = lbusEmpAct;
        this.vMostrarCitas = vMostrarCitas;
        this.lisCitas = lisCitas;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        actualizarPersona();
    }
    
     private void actualizarPersona(){
         try {
         int valorFila = vMostrarCitas.getCitasTable().getSelectedRow();
        int codigo = Integer.parseInt(String.valueOf(vMostrarCitas.getCitasTable().getValueAt(valorFila, 0)));
            String sentencia = """
                               UPDATE veterinaria.vt_citas 
                               SET cit_estado = 'I' 
                               WHERE cit_codigo = ?
                               """;

            ps = con.prepareStatement(sentencia);

            ps.setInt(1, codigo);

            int tuplaejecutada = ps.executeUpdate();
            con.setAutoCommit(false);
            ps.close();            
            if (tuplaejecutada == 1) {
                con.commit();
                conexionTablas conTablas =  new conexionTablas(conexion, con);
                lisCitas.clearAllElements();
                conTablas.obtenerCitas(lisCitas);
                vMostrarCitas.repaint();
                JOptionPane.showMessageDialog(actualizarEmp, "Actualizado Exitosamente!!");
                
            } else {
                JOptionPane.showMessageDialog(actualizarEmp, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(actualizarEmp, "Error al actualizar la Base de Datos");
            
        }catch(IndexOutOfBoundsException | NullPointerException e){
            JOptionPane.showMessageDialog(actualizarEmp, "Seleccione la cita a cancelar");
        }
    }
    
}
