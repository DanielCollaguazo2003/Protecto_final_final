/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jeiso
 */
public class DefaultTablaEmpleados extends AbstractTableModel {

    String[] title = {"CEDULA", "NOMBRES", "APELLIDOS", "DIRECCION PRINCIPAL", "DIRECCION SECUNDARIA", "TELEFONO", "CORREO ELECTRONICO", "TIPO", "ROL"};
    DefaultListaEmpleados listaEmpleados;

    public DefaultTablaEmpleados(DefaultListaEmpleados listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
        ListenerListaPersonas listenerListaPersonas = new ListenerListaPersonas();
        listaEmpleados.addListDataListener(listenerListaPersonas);
    }

    @Override
    public String getColumnName(int index) {
        return title[index];
    }

    private class ListenerListaPersonas implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            int index = listaEmpleados.getListDataListeners().length;
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
        return listaEmpleados.getSize();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaEmpleados.getElementAt(row).getCedula();
            case 1:
                return listaEmpleados.getElementAt(row).getNombre();
            case 2:
                return listaEmpleados.getElementAt(row).getApellido();
            case 3:
                return listaEmpleados.getElementAt(row).getDireccion_p();
            case 4:
                return listaEmpleados.getElementAt(row).getDireccion_s();
            case 5:
                return listaEmpleados.getElementAt(row).getTelefono();
            case 6:
                return listaEmpleados.getElementAt(row).getCorreo();
            case 7:
                return listaEmpleados.getElementAt(row).getTipo();
            default:
                return "";
        }

    }
}

