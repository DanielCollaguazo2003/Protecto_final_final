/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CrearClientes;

/**
 *
 * @author XaviO_o
 */
public class listenerCrearClientes implements ActionListener{
    CrearClientes ccli;

    public listenerCrearClientes(CrearClientes ccli) {
        this.ccli = ccli;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ccli.setVisible(true);
    }
    
}
