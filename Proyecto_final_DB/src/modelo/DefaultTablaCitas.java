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
public class DefaultTablaCitas extends AbstractTableModel {

    String[] title = {"CODIGO", "CLIENTE", "NOMBRE MASCOTA", "TIPO MASCOTA", "VETERINARIO", "FECHA", "ESTADO"};
    DefaultListaCitas listaCitas;

    public DefaultTablaCitas(DefaultListaCitas listaCitas) {
        this.listaCitas = listaCitas;
        ListenerListaDetalles listenerListaPersonas = new ListenerListaDetalles();
        listaCitas.addListDataListener(listenerListaPersonas);
    }

    @Override
    public String getColumnName(int index) {
        return title[index];
    }

    private class ListenerListaDetalles implements ListDataListener {

        @Override
        public void intervalAdded(ListDataEvent e) {
            int index = listaCitas.getListDataListeners().length;
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
        return listaCitas.getSize();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    
    @Override
    public Object getValueAt(int row, int col) {
        switch (col) {
            case 0:
                return listaCitas.getElementAt(row).getCodigo_cita();
            case 1:
                return listaCitas.getElementAt(row).getCliente().getNombre() + " " + listaCitas.getElementAt(row).getCliente().getApellido();
            case 2:
                return listaCitas.getElementAt(row).getNombre_mascota();
            case 3:
                return listaCitas.getElementAt(row).getTipo_Mascota().getNombre();
            case 4:
                return listaCitas.getElementAt(row).getEmpleado().getNombre() + " " + listaCitas.getElementAt(row).getEmpleado().getApellido();
            case 5:
                return listaCitas.getElementAt(row).getFecha();
            case 6:
                return listaCitas.getElementAt(row).getEstado();
            default:
                return "";
        }

    }
}
