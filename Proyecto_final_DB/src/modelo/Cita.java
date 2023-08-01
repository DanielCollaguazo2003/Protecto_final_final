/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Anthony Moya
 */
public class Cita {
    
    private int codigo_cita;
    private LocalDateTime fecha;
    private String estado;
    private Cliente cliente;
    private String nombre_mascota;
    private Empleado empleado;
    private Tipo_Mascota tipo_Mascota;

    public Cita(int codigo_cita, LocalDateTime fecha, String estado, Cliente cliente, String nombre_mascota, Empleado empleado, Tipo_Mascota tipo_Mascota) {
        this.codigo_cita = codigo_cita;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.nombre_mascota = nombre_mascota;
        this.empleado = empleado;
        this.tipo_Mascota = tipo_Mascota;
    }

    public Tipo_Mascota getTipo_Mascota() {
        return tipo_Mascota;
    }

    public void setTipo_Mascota(Tipo_Mascota tipo_Mascota) {
        this.tipo_Mascota = tipo_Mascota;
    }

        
    
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre_mascota() {
        return nombre_mascota;
    }

    public void setNombre_mascota(String nombre_mascota) {
        this.nombre_mascota = nombre_mascota;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public int getCodigo_cita() {
        return codigo_cita;
    }

    public void setCodigo_cita(int codigo_cita) {
        this.codigo_cita = codigo_cita;
    }
}
