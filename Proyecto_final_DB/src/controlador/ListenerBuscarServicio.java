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
import modelo.*;
import vista.*;

/**
 *
 * @author XaviO_o
 */
public class ListenerBuscarServicio implements ActionListener {

    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    VistaCrearServicios vCrearServicios;
    Servicio ser = null;

    public ListenerBuscarServicio(ConexionOracle conexion, Connection con, VistaCrearServicios vCrearServicios) {
        this.conexion = conexion;
        this.con = con;
        this.vCrearServicios = vCrearServicios;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obtenerServicio();
    }

    public void obtenerServicio() {
        try {
            try {
                int codigoServicio = Integer.parseInt(vCrearServicios.getCodigoServicio().getText());
                ps = con.prepareStatement("SELECT * FROM veterinaria.vt_servicios WHERE ser_codigo = ?");
                ps.setInt(1, codigoServicio);
                ResultSet res = ps.executeQuery();

                while (res.next()) {
                    int codigo = codigoServicio;
                    String nombre = res.getString("ser_nombre");
                    String descripcion = res.getString("ser_descripcion");
                    float precio = res.getFloat("ser_precio");
                    String iva = res.getString("ser_iva");
                    int index = 0;
                    
                    ser = new Servicio(codigo, nombre, descripcion, precio, iva);

                    vCrearServicios.getNombreServicio().setText(nombre);
                    vCrearServicios.getDescripcionServicio().setText(descripcion);
                    vCrearServicios.getPrecioServicio().setText(String.valueOf(precio));
                    if (iva.equals("S")){
                        index = 1;
                    }else if (iva.equals("N")){
                        index= 2;
                    }
                    vCrearServicios.getIvaBoxServicio().setSelectedIndex(index);
                    
                    vCrearServicios.getCrearServicio().setEnabled(false);
                    vCrearServicios.getActualizarServicio().setEnabled(true);
                }
                res = ps.executeQuery();

                if (res.next() == false) {
                    JOptionPane.showMessageDialog(vCrearServicios, "Servicio no encontrado!");
                }
            } catch (SQLException x) {
                System.out.println(x);
                System.out.println("no");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vCrearServicios, "Ingrese un el codigo que desee buscar");
        }

    }

}
