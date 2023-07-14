/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Cliente extends Persona{
    
    private String estado;

    public Cliente(String estado, String cedula, String nombre, String apellido, String direccion_p, String direccion_s, String telefono, String correo) {
        super(cedula, nombre, apellido, direccion_p, direccion_s, telefono, correo);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
