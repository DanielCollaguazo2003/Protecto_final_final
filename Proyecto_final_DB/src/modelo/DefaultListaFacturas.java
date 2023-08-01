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
public class DefaultListaFacturas extends AbstractListModel<FacturasTablas> {

    private ArrayList<FacturasTablas> listaFacturas;

    public DefaultListaFacturas() {
        this.listaFacturas = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaFacturas.isEmpty();
    }

    public void fireIntervalRemoved(FacturasTablas facturasTablas, int index) {
        listaFacturas.remove(facturasTablas);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaFacturas.size();
    }

    @Override
    public FacturasTablas getElementAt(int index) {
        return listaFacturas.get(index);
    }

    public void addElement(FacturasTablas facturasTablas) {
        int index = listaFacturas.size();
        listaFacturas.add(facturasTablas);
        fireIntervalAdded(this, index, index);
    }

    public ArrayList<FacturasTablas> getListaServicios() {
        return listaFacturas;
    }
    
}
