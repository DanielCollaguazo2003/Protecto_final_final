/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Usuario {
    
    private int codigo_u;
    private String nombre_usuario;
    private String contrasena;
    private Empleado empleado;

    public Usuario(int codigo_u, String nombre_usuario, String contrasena, Empleado empleado) {
        this.codigo_u = codigo_u;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.empleado = empleado;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getCodigo_u() {
        return codigo_u;
    }

    public void setCodigo_u(int codigo_u) {
        this.codigo_u = codigo_u;
    }
    
}
