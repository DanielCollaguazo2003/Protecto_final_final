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
public class DefaultListaServicios extends AbstractListModel<Servicio>{
    private ArrayList <Servicio> listaServicio;

    public DefaultListaServicios() {
        this.listaServicio = new ArrayList<>();
    }
    
    public boolean verificarlista(){
        return listaServicio.isEmpty();
    }
    
    public void Removed(Servicio servicio, int index) {
        listaServicio.remove(servicio);
        super.fireIntervalRemoved(this, index, index);
    }

    @Override
    public int getSize() {
        return listaServicio.size();
    }

    @Override
    public Servicio getElementAt(int index) {
        return listaServicio.get(index);
    }
    
    public void  addServicio(Servicio servicio){
        int index=listaServicio.size();
        listaServicio.add(servicio);
        fireIntervalAdded(this,index, index);
    }
}
