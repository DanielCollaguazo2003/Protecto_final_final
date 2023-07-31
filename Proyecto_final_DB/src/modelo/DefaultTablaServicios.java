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
public class DefaultTablaServicios extends AbstractTableModel {

        String[] title = {"CODIGO", "NOMBRE", "DESCRIPCION", "PRECIO", "IVA"};
    DefaultListaServicios listaServicios;

    public DefaultTablaServicios(DefaultListaServicios listaServicios) {
        this.listaServicios = listaServicios;
        ListenerListaServicios listenerListaPersonas = new ListenerListaServicios();
        listaServicios.addListDataListener(listenerListaPersonas);
    }

    @Override
    public String getColumnName(int index) {
        return title[index];
    }

    private class ListenerListaServicios implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            int index = listaServicios.getListDataListeners().length;
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
        return listaServicios.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaServicios.getElementAt(row).getCodigo_s();
            case 1:
                return listaServicios.getElementAt(row).getNombre();
            case 2:
                return listaServicios.getElementAt(row).getDescripcion();
            case 3:
                return listaServicios.getElementAt(row).getPrecio();
            case 4:
                return listaServicios.getElementAt(row).getIva();
            default:
                return "";
        }

    }
}
