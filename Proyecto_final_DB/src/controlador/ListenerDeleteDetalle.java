/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.DefaultListaDetalles;
import modelo.DefaultTablaDetalles;
import modelo.Detalle_Factura;
import modelo.Servicio;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class ListenerDeleteDetalle implements ActionListener {

    VistaGeneralSistema vGeneral;
    DefaultListaDetalles listaDetalles;
    DefaultTablaDetalles tableDetalles;

    public ListenerDeleteDetalle(VistaGeneralSistema vGeneral, DefaultListaDetalles listaDetalles, DefaultTablaDetalles tableDetalles) {
        this.vGeneral = vGeneral;
        this.listaDetalles = listaDetalles;
        this.tableDetalles = tableDetalles;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int fila = vGeneral.getTableServices().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vGeneral, "Seleccione que elemnto desea elimininar");
        } else {
            Detalle_Factura detalle = listaDetalles.getElementAt(fila);
            if (verificarDetalle(detalle) == false) {
                listaDetalles.fireIntervalRemoved(detalle, fila);
                vGeneral.tableModelDetalles(tableDetalles);
                calcularTotalFactura();
            }
            vGeneral.repaint();
        }

    }

    private boolean verificarDetalle(Detalle_Factura detalle) {

        if (detalle.getCantidad() != 1) {
            int nuevaCantidad = detalle.getCantidad() - 1;
            detalle.setCantidad(nuevaCantidad);
            
            float nuevoSubTotal = detalle.getPrecio_unitario() * nuevaCantidad;
            detalle.setSubtotal(nuevoSubTotal);
            
            float nuevoIva = (nuevoSubTotal * 12)/100;
            detalle.setValor_iva(nuevoIva);

            float nuevoTotal = detalle.getSubtotal() + detalle.getValor_iva();
            detalle.setTotal(nuevoTotal);
            return true;
        }
        return false;
    }

    private void calcularTotalFactura() {
        int cantidadFilas = vGeneral.getTableServices().getRowCount();
        float cantidadsubtotal = 0;
        float cantidadTotal = 0;
        float cantidadIVA = 0;
        for (int i = 0; i < cantidadFilas; i++) {
            Detalle_Factura detalle = listaDetalles.getElementAt(i);
            //subtotal
            cantidadsubtotal = cantidadsubtotal + detalle.getSubtotal();
            //total
            cantidadTotal = cantidadTotal + detalle.getTotal();
            //iva
            cantidadIVA = cantidadIVA + detalle.getValor_iva();
        }

        vGeneral.getSubtotalGen().setText("$ " + String.valueOf(cantidadsubtotal));
        vGeneral.getTotalIvaGen().setText("$ " + String.valueOf(cantidadIVA));
        vGeneral.getTotalGen().setText("$ " + String.valueOf(cantidadTotal));
    }

}
