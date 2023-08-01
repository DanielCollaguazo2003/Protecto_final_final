/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VistaCrearServicios;

/**
 *
 * @author XaviO_o
 */
public class ListenerLimpiarCamposServicio implements ActionListener{
    VistaCrearServicios vCrearServicios;

    public ListenerLimpiarCamposServicio(VistaCrearServicios vCrearServicios) {
        this.vCrearServicios = vCrearServicios;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        vCrearServicios.getCodigoServicio().setText("");
        vCrearServicios.getPrecioServicio().setText("");
        vCrearServicios.getDescripcionServicio().setText("");
        vCrearServicios.getNombreServicio().setText("");
        vCrearServicios.getIvaBoxServicio().setSelectedIndex(0);
        vCrearServicios.getActualizarServicio().setEnabled(false);
        vCrearServicios.getCrearServicio().setEnabled(true);
    }
    
}
