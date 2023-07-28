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

    String[] botones = {"Aceptar", "Cancelar"};

    public ListenerFinalizarSesion(VistaGeneralSistema vg, VistaLogin vl) {
        this.vg = vg;
        this.vl = vl;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int eleccion = JOptionPane.showOptionDialog(vg, "¿Desea finalizar la sesión?",
                "", 0, 0, null,botones, this);
        if (eleccion == JOptionPane.YES_OPTION) {
            this.vg.setVisible(false);
            this.vl.setVisible(true);
        } 

    }

}
