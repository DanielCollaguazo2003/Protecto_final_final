/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Rol {
    
    private int codigo_rol;
    private String nombre;
    private String descripcion;

    public Rol(int codigo_rol, String nombre, String descripcion) {
        this.codigo_rol = codigo_rol;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo_rol() {
        return codigo_rol;
    }

    public void setCodigo_rol(int codigo_rol) {
        this.codigo_rol = codigo_rol;
    }
    
    
}
