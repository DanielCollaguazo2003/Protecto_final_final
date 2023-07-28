/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Servicios;

/**
 *
 * @author XaviO_o
 */
public class listenerServicios implements ActionListener{
    Servicios s;

    public listenerServicios(Servicios s) {
        this.s = s;
    }
    
     
    @Override
    public void actionPerformed(ActionEvent e) {
        s.setVisible(true);
    }
    
}
