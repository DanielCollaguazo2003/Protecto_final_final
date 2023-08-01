/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CrearClientes;
import vista.CrearEmpleados;

/**
 *
 * @author Anthony Moya
 */
public class ListenerRegresarCreacionEmpleados implements ActionListener {
    
    CrearEmpleados ce;

    public ListenerRegresarCreacionEmpleados(CrearEmpleados ce) {
        this.ce = ce;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ce.setVisible(false);
    }
    
}
