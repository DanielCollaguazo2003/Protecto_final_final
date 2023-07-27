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
 * @author Anthony Moya
 */
public class ListenerRegresarCreacionClientes implements ActionListener {
    
   CrearClientes c;

    public ListenerRegresarCreacionClientes(CrearClientes c) {
        this.c = c;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        c.setVisible(false);
    }
    
}
