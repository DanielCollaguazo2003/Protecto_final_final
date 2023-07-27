/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Servicio {
    
    private int codigo_s;
    private String nombre;
    private String descripcion;
    private float precio;
    private float iva;

    public Servicio(int codigo_s, String nombre, String descripcion, float precio, float iva) {
        this.codigo_s = codigo_s;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public int getCodigo_s() {
        return codigo_s;
    }

    public void setCodigo_s(int codigo_s) {
        this.codigo_s = codigo_s;
    }
    
    
}
