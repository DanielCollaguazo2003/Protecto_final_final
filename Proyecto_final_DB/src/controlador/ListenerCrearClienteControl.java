/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Clientes;
import vista.CrearClientes;

/**
 *
 * @author Anthony Moya
 */
public class ListenerCrearClienteControl implements ActionListener{
    
    Clientes c;
    CrearClientes cc;

    public ListenerCrearClienteControl(Clientes c, CrearClientes cc) {
        this.c = c;
        this.cc = cc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cc.setVisible(true);
    }
}
