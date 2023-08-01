/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CrearEmpleados;
import vista.Empleados;

/**
 *
 * @author Anthony Moya
 */
public class ListenerMostrarVentanaCreacionEmp implements ActionListener{

    Empleados e;
    CrearEmpleados ce;

    public ListenerMostrarVentanaCreacionEmp(Empleados e, CrearEmpleados ce) {
        this.e = e;
        this.ce = ce;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ce.setVisible(true);
    }
    
}
