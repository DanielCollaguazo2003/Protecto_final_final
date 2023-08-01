/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author XaviO_o
 */
public class DefaultTablaFacturas extends AbstractTableModel {

    String[] title = {"CODIGO", "CLIENTE", "EMPLEADO", "FECHA Y HORA", "CANTIDAD de SERVICIOS","SUBTOTAL", "IVA", "TOTAL"};
    DefaultListaFacturas listaFacturas;

    public DefaultTablaFacturas(DefaultListaFacturas listaFacturas) {
        this.listaFacturas = listaFacturas;
        ListenerListaFacturaClientes listenerlfc = new ListenerListaFacturaClientes();
        listaFacturas.addListDataListener(listenerlfc);
    }

    @Override
    public String getColumnName(int index) {
        return title[index];
    }

    private class ListenerListaFacturaClientes implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            int index = listaFacturas.getListDataListeners().length;
            fireTableDataChanged();
            fireTableRowsInserted(index, index);
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            fireTableDataChanged();
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            fireTableDataChanged();
        }

    }

    @Override
    public int getRowCount() {
        return listaFacturas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaFacturas.getElementAt(row).getCodigo_cb();
            case 1:
                return listaFacturas.getElementAt(row).getCliente();
            case 2:
                return listaFacturas.getElementAt(row).getEmpleado();
            case 3:
                return listaFacturas.getElementAt(row).getFecha_emision();
            case 4:
                return listaFacturas.getElementAt(row).getCantidad();
            case 5:
                return listaFacturas.getElementAt(row).getSubtotal();
            case 6:
                return listaFacturas.getElementAt(row).getValor_iva();
            case 7:
                return listaFacturas.getElementAt(row).getTotal();
            default:
                return "";
        }
    }
}
