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
public class DefaultListaClientes extends AbstractListModel<Cliente> {

    private ArrayList<Cliente> listaCliente;

    public DefaultListaClientes() {
        this.listaCliente = new ArrayList<>();
    }

    public boolean verificarLista() {
        return listaCliente.isEmpty();
    }

    public void fireIntervalRemoved(Cliente cliente, int index) {
        listaCliente.remove(cliente);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaCliente.size();
    }

    @Override
    public Cliente getElementAt(int index) {
        return listaCliente.get(index);
    }

    public void addElement(Cliente cliente) {
        int index = listaCliente.size();
        listaCliente.add(cliente);
        fireIntervalAdded(this, index, index);
    }
}
