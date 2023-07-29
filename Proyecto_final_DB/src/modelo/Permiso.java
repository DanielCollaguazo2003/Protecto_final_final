/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Anthony Moya
 */
public class Permiso {
    
    private int codigo_permiso;
    private String nombre;
    private String descripcion;
    private Rol rol;

    public Permiso(int codigo_permiso, String nombre, String descripcion, Rol rol) {
        this.codigo_permiso = codigo_permiso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rol = rol;
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

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getCodigo_permiso() {
        return codigo_permiso;
    }

    public void setCodigo_permiso(int codigo_permiso) {
        this.codigo_permiso = codigo_permiso;
    }
    
    
}
