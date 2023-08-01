
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import modelo.*;

/**
 *
 * @author XaviO_o
 */
public class ListenerMostrarCitas implements ActionListener{

    private VistaGeneralSistema v;
    private Cita c;
    private VistaMostrarCitas mostrarCitas;

    public ListenerMostrarCitas(VistaMostrarCitas mostrarCitas) {
        this.mostrarCitas = mostrarCitas;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarCitas.setVisible(true);
    }
    
}
