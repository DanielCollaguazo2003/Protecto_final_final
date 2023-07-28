/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Empleados;

/**
 *
 * @author XaviO_o
 */
public class listenerEmpleados implements ActionListener{
    Empleados emp;

    public listenerEmpleados(Empleados emp) {
        this.emp = emp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        emp.setVisible(true);
    }
    
}
