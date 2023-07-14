/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion_p;
    private String direccion_s;
    private String telefono;
    private String correo;

    public Persona( String cedula, String nombre, String apellido, String direccion_p, String direccion_s, String telefono, String correo) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion_p = direccion_p;
        this.direccion_s = direccion_s;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion_p() {
        return direccion_p;
    }

    public void setDireccion_p(String direccion_p) {
        this.direccion_p = direccion_p;
    }

    public String getDireccion_s() {
        return direccion_s;
    }

    public void setDireccion_s(String direccion_s) {
        this.direccion_s = direccion_s;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
