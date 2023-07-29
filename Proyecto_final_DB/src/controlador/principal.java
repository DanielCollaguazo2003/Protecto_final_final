
package controlador;


import modelo.*;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class principal {

    public static void main(String[] args) {
        //MODELOS
        VistaLogin vl = new VistaLogin();
        VistaGeneralSistema vGeneral = new VistaGeneralSistema();
        //Controlador controlador = new Controlador(vl, vGeneral, "veterinaria", "12345");
        listener_login ll = new listener_login(vl, vGeneral);

        vl.listener_login(ll);
        vl.listenerIniSesion(ll);

        vl.setVisible(true);

        VerificacionHilo hiloVerfificacion = new VerificacionHilo(ll);
        hiloVerfificacion.start();
        while (hiloVerfificacion.isVerificar() == false) {
            System.out.println("esperando");
        }
        hiloVerfificacion.interrupt();
        Usuario usu = ll.getUsu();
        Controlador controlador = new Controlador(vl, vGeneral, ll.getUser(), ll.getPassword(), usu);
    }

}
