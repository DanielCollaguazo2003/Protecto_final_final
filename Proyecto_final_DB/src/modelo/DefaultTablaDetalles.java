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
public class DefaultTablaDetalles extends AbstractTableModel {

        String[] title = {"CODIGO", "CANTIDAD", "PRECIO UNITARIO", "SUBTOTAL", "TOTAL DEL IVA", "TOTAL"};
    DefaultListaDetalles listaDetalles;

    public DefaultTablaDetalles(DefaultListaDetalles listaDetalles) {
        this.listaDetalles = listaDetalles;
        ListenerListaDetalles listenerListaPersonas = new ListenerListaDetalles();
        listaDetalles.addListDataListener(listenerListaPersonas);
    }

    @Override
    public String getColumnName(int index) {
        return title[index];
    }

    private class ListenerListaDetalles implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            int index = listaDetalles.getListDataListeners().length;
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
        return listaDetalles.getSize();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaDetalles.getElementAt(row).getCodigo();
            case 1:
                return listaDetalles.getElementAt(row).getCantidad();
            case 2:
                return listaDetalles.getElementAt(row).getPrecio_unitario();
            case 3:
                return listaDetalles.getElementAt(row).getSubtotal();
            case 4:
                return listaDetalles.getElementAt(row).getValor_iva();
            case 5:
                return listaDetalles.getElementAt(row).getTotal();
            default:
                return "";
        }

    }
}
