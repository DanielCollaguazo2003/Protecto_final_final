/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.ActualizarCliente;
import vista.ActualizarEmpleado;

/**
 *
 * @author XaviO_o
 */
public class ListenerMostrarVentaaActualizarEmp implements ActionListener{
    ActualizarEmpleado actEmpleado;

    public ListenerMostrarVentaaActualizarEmp(ActualizarEmpleado actEmpleado) {
        this.actEmpleado = actEmpleado;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        actEmpleado.setVisible(true);
    }
    
}
