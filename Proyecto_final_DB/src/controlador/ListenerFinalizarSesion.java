/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.*;

/**
 *
 * @author mateo
 */
public class ListenerFinalizarSesion implements ActionListener {

    VistaGeneralSistema vg;
    VistaLogin vl;
    ActualizarCliente ac;
    Citas c;
    Clientes cli;
    CrearClientes cCli;
    Empleados emp;
    Servicios serv;
    Vista_Crear_Usuario vcu;
    

    String[] botones = {"Aceptar", "Cancelar"};

    public ListenerFinalizarSesion(VistaGeneralSistema vg, VistaLogin vl, ActualizarCliente ac, Citas c, Clientes cli, CrearClientes cCli, Empleados emp, Servicios serv, Vista_Crear_Usuario vcu) {
        this.vg = vg;
        this.vl = vl;
        this.ac = ac;
        this.c = c;
        this.cli = cli;
        this.cCli = cCli;
        this.emp = emp;
        this.serv = serv;
        this.vcu = vcu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int eleccion = JOptionPane.showOptionDialog(vg, "¿Desea finalizar la sesión?",
                "", 0, 0, null,botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            
            this.ac.setVisible(false);
            this.c.setVisible(false);
            this.cli.setVisible(false);
            this.cCli.setVisible(false);
            this.emp.setVisible(false);
            this.serv.setVisible(false);
            this.vcu.setVisible(false);
            this.vg.setVisible(false);
            this.vl.setVisible(true);
        } 

    }

}
