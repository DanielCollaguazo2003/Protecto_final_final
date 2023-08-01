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
public class DefaultListaCitas extends AbstractListModel<Cita> {

    private ArrayList<Cita> listaCita;

    public DefaultListaCitas() {
        this.listaCita = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaCita.isEmpty();
    }

    public void fireIntervalRemoved(Cita cita, int index) {
        listaCita.remove(cita);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaCita.size();
    }

    @Override
    public Cita getElementAt(int index) {
        return listaCita.get(index);
    }

    public void addElement(Cita cita) {
        int index = listaCita.size();
        listaCita.add(cita);
        fireIntervalAdded(this, index, index);
    }

    public ArrayList<Cita> getListaServicios() {
        return listaCita;
    }
    
    public void clearAllElements() {
        int size = listaCita.size();
        listaCita.clear();
        fireIntervalRemoved(this, 0, size - 1);
    }

}
