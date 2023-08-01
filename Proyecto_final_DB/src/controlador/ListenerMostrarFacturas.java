
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import modelo.*;

/**
 *
 * @author XaviO_o
 */
public class ListenerMostrarFacturas implements ActionListener{

    private VistaGeneralSistema v;
    private Cita c;
    private VistaMostarFacturas mostrarfacturas;

    public ListenerMostrarFacturas(VistaMostarFacturas mostrarfacturas) {
        this.mostrarfacturas = mostrarfacturas;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarfacturas.setVisible(true);
    }
    
}
