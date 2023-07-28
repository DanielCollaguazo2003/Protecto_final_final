
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
import modelo.*;

/**
 *
 * @author XaviO_o
 */
public class ListenerCitas implements ActionListener{

    private VistaGeneralSistema v;
    private Cita c;
    private Citas citas;

    public ListenerCitas(Citas citas) {
        this.citas = citas;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        citas.setVisible(true);
    }
    
}
