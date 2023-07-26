/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ActualizarCliente;

/**
 *
 * @author XaviO_o
 */
public class listenerActualizarClientes implements ActionListener{
    ActualizarCliente actCli;

    public listenerActualizarClientes(ActualizarCliente actCli) {
        this.actCli = actCli;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        actCli.setVisible(true);
    }
    
}
