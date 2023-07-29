/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author XaviO_o
 */
public class VerificacionHilo extends Thread {

    listener_login ll;
    boolean verificar = false;

    public VerificacionHilo(listener_login ll) {
        this.ll = ll;
    }

    @Override
    public void run() {
        try {
            // Simulamos una tarea que se ejecuta en el hilo
            while (!isInterrupted()) {
                verificar = ll.verfificar;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // Manejo de la excepción si el hilo es interrumpido mientras está dormido
            System.out.println("El hilo fue interrumpido mientras dormía.");
        }
        System.out.println("El hilo ha finalizado su ejecución.");

    }

    public boolean isVerificar() {
        return verificar;
    }
}
