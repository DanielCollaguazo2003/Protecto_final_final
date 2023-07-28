/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Tipo_Mascota {

    private int codigo_tm;
    private String nombre;

    public Tipo_Mascota(int codigo_tm, String nombre) {
        this.codigo_tm = codigo_tm;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_tm() {
        return codigo_tm;
    }

    public void setCodigo_tm(int codigo_tm) {
        this.codigo_tm = codigo_tm;
    }

}
