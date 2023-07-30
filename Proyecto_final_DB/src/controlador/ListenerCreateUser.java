/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Vista_Crear_Usuario;

/**
 *
 * @author XaviO_o
 */
public class ListenerCreateUser implements ActionListener{
    Vista_Crear_Usuario createUser;

    public ListenerCreateUser(Vista_Crear_Usuario createUser) {
        this.createUser = createUser;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        createUser.setVisible(true);
    }
    
}
