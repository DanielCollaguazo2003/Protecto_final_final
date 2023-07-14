/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Mascota {
    private String nombre_mascota;
    private Tipo_Mascota tipo_mascota;

    public Mascota(String nombre_mascota, Tipo_Mascota tipo_mascota) {
        this.nombre_mascota = nombre_mascota;
        this.tipo_mascota = tipo_mascota;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public Tipo_Mascota getTipo_mascota() {
        return tipo_mascota;
    }

    public void setTipo_mascota(Tipo_Mascota tipo_mascota) {
        this.tipo_mascota = tipo_mascota;
    }
    
    
}
