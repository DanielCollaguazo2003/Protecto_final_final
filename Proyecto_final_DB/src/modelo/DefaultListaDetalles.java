/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author XaviO_o
 */
public class DefaultListaDetalles extends AbstractListModel<Detalle_Factura> {

    private ArrayList<Detalle_Factura> listaDetalles;

    public DefaultListaDetalles() {
        this.listaDetalles = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaDetalles.isEmpty();
    }

    public void fireIntervalRemoved(Detalle_Factura detalle, int index) {
        listaDetalles.remove(detalle);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaDetalles.size();
    }

    @Override
    public Detalle_Factura getElementAt(int index) {
        return listaDetalles.get(index);
    }

    public void addElement(Detalle_Factura detalle) {
        int index = listaDetalles.size();
        listaDetalles.add(detalle);
        fireIntervalAdded(this, index, index);
    }

    public ArrayList<Detalle_Factura> getListaDetalles() {
        return listaDetalles;
    }

    public void clearAllElements() {
        int size = listaDetalles.size();
        listaDetalles.clear();
        fireIntervalRemoved(this, 0, size - 1);
    }
}
