/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Jeiso
 */
public class DefaultListaEmpleados extends AbstractListModel<Empleado>{
    private ArrayList<Empleado> listaEmpleado;

    public DefaultListaEmpleados() {
        this.listaEmpleado = new ArrayList<>();
    }
    public boolean verificarLista(){
        return listaEmpleado.isEmpty();
    }
    
        public void fireIntervalRemoved(Empleado empleado, int index) {
        listaEmpleado.remove(empleado);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaEmpleado.size();
    }

    @Override
    public Empleado getElementAt(int index) {
        return listaEmpleado.get(index);
    }

    public void addElement(Empleado empleado) {
        int index = listaEmpleado.size();
        listaEmpleado.add(empleado);
        fireIntervalAdded(this, index, index);
    }
}
