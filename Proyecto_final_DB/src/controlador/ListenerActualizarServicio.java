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
import modelo.DefaultListaServicios;
import modelo.Servicio;
import vista.Servicios;
import vista.VistaCrearServicios;

/**
 *
 * @author XaviO_o
 */
public class ListenerActualizarServicio implements ActionListener {

    PreparedStatement ps = null;
    ConexionOracle conexion;
    Connection con;
    VistaCrearServicios vCrearServicios;
    DefaultListaServicios listServicios;
    Servicios ser;

    public ListenerActualizarServicio(ConexionOracle conexion, Connection con, VistaCrearServicios vCrearServicios, DefaultListaServicios listServicios, Servicios ser) {
        this.conexion = conexion;
        this.con = con;
        this.vCrearServicios = vCrearServicios;
        this.listServicios = listServicios;
        this.ser = ser;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actualizarServicio();
    }

    public void actualizarServicio() {
        try {
            int codigo = Integer.parseInt(vCrearServicios.getCodigoServicio().getText());
            String nombre = vCrearServicios.getNombreServicio().getText();
            String descripcion = vCrearServicios.getDescripcionServicio().getText();
            float precio = Float.parseFloat(vCrearServicios.getPrecioServicio().getText());
            String iva = vCrearServicios.getIvaBoxServicio().getSelectedItem().toString();
            System.out.println(iva);
            String sentencia = """
                               UPDATE veterinaria.vt_servicios SET ser_nombre = ?, ser_descripcion = ?, 
                                                                   ser_precio = ?, ser_iva = ?
                                                                   WHERE ser_codigo = ?
                               """;

            ps = con.prepareStatement(sentencia);

            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setString(4, String.valueOf(iva.charAt(0)));
            ps.setInt(5, codigo);

            int tuplaejecutada = ps.executeUpdate();
            con.setAutoCommit(false);
            ps.close();

            if (tuplaejecutada == 1) {
                con.commit();
                JOptionPane.showMessageDialog(vCrearServicios, "Actualizado Exitosamente!!");
                vCrearServicios.getCodigoServicio().setText("");
                vCrearServicios.getNombreServicio().setText("");
                vCrearServicios.getDescripcionServicio().setText("");
                vCrearServicios.getPrecioServicio().setText("");
                vCrearServicios.getIvaBoxServicio().setSelectedIndex(0);
                int codigoIndex = obtenerIndexActualizar(codigo);
                listServicios.getElementAt(codigoIndex).setDescripcion(descripcion);
                listServicios.getElementAt(codigoIndex).setNombre(nombre);
                listServicios.getElementAt(codigoIndex).setIva(String.valueOf(iva.charAt(0)));
                listServicios.getElementAt(codigoIndex).setPrecio(precio);
                vCrearServicios.setVisible(false);
                ser.repaint();
                

            } else {
                JOptionPane.showMessageDialog(vCrearServicios, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(vCrearServicios, "Error al actualizar la Base de Datos");

        }
    }
    
    private int obtenerIndexActualizar(int codigo){
        int iterador = 0;
        for (Servicio servicio : listServicios.getListaServicios()) {  
            if (servicio.getCodigo_s() == codigo) {
                    codigo = iterador;
                }
            iterador++;
        }
        return codigo;
    }
}
