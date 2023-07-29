/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Empleado extends Persona {
    
    private String tipo;

    public Empleado(String tipo, int codigo_p, String cedula, String nombre, String apellido, String direccion_p, String direccion_s, String telefono, String correo) {
        super(codigo_p, cedula, nombre, apellido, direccion_p, direccion_s, telefono, correo);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
