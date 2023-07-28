/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.*;
import vista.ActualizarCliente;
import vista.Citas;
import vista.Clientes;
import vista.CrearClientes;
import vista.Empleados;
import vista.Servicios;
import vista.VistaGeneralSistema;
import vista.VistaLogin;
import vista.Vista_Crear_Usuario;

/**
 *
 * @author XaviO_o
 */
public class principal {

    public static void main(String[] args) {
        /*  public class Principal {
    public static void main(String[] args) {
        // Crear y comenzar el hilo
        MiHilo hilo = new MiHilo();
        hilo.start();

        try {
            // Agregar un tiempo de espera para interrumpir el hilo después de 5 segundos
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrumpir el hilo después de 5 segundos
        hilo.interrupt();
    }*/

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
        Controlador controlador = new Controlador(vl, vGeneral, ll.getUser(), ll.getPassword());
    }

}
