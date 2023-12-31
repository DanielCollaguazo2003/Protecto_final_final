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
public class DefaultTablaClientes extends AbstractTableModel {

    String[] title = {"CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION PRINCIPAL", "DIRECCION SECUNDARIA", "TELEFONO", "CORREO ELECTRONICO", "Estado"};
    DefaultListaClientes listaClientes;

    public DefaultTablaClientes(DefaultListaClientes listaClientes) {
        this.listaClientes = listaClientes;
        ListenerListaPersonas listenerListaPersonas = new ListenerListaPersonas();
        listaClientes.addListDataListener(listenerListaPersonas);
    }

    @Override
    public String getColumnName(int index) {
        return title[index];
    }

    private class ListenerListaPersonas implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            int index = listaClientes.getListDataListeners().length;
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
        return listaClientes.getSize();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaClientes.getElementAt(row).getCedula();
            case 1:
                return listaClientes.getElementAt(row).getNombre();
            case 2:
                return listaClientes.getElementAt(row).getApellido();
            case 3:
                return listaClientes.getElementAt(row).getDireccion_p();
            case 4:
                return listaClientes.getElementAt(row).getDireccion_s();
            case 5:
                return listaClientes.getElementAt(row).getTelefono();
            case 6:
                return listaClientes.getElementAt(row).getCorreo();
            case 7:
                return listaClientes.getElementAt(row).getEstado();
            default:
                return "";
        }

    }
}
