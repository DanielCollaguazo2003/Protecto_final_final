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
public class DefaultListaServicios extends AbstractListModel<Servicio> {

    private ArrayList<Servicio> listaServicios;

    public DefaultListaServicios() {
        this.listaServicios = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaServicios.isEmpty();
    }

    public void fireIntervalRemoved(Servicio servicio, int index) {
        listaServicios.remove(servicio);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaServicios.size();
    }

    @Override
    public Servicio getElementAt(int index) {
        return listaServicios.get(index);
    }

    public void addElement(Servicio servicio) {
        int index = listaServicios.size();
        listaServicios.add(servicio);
        fireIntervalAdded(this, index, index);
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }
    
}
