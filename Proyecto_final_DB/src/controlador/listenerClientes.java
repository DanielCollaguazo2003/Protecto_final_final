/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Clientes;

/**
 *
 * @author XaviO_o
 */
public class listenerClientes implements ActionListener {

    Clientes c;

    public listenerClientes(Clientes c) {
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.setVisible(true);
    }

}
