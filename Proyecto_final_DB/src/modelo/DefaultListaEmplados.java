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
public class DefaultListaEmplados extends AbstractListModel<Empleado> {

    private ArrayList<Empleado> listaEmpleados;

    public DefaultListaEmplados() {
        this.listaEmpleados = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaEmpleados.isEmpty();
    }

    public void fireIntervalRemoved(Empleado Empleado, int index) {
        listaEmpleados.remove(Empleado);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaEmpleados.size();
    }

    @Override
    public Empleado getElementAt(int index) {
        return listaEmpleados.get(index);
    }

    public void addElement(Empleado Empleado) {
        int index = listaEmpleados.size();
        listaEmpleados.add(Empleado);
        fireIntervalAdded(this, index, index);
    }

    public ArrayList<Empleado> getListaDetalles() {
        return listaEmpleados;
    }

}
