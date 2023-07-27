/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Anthony Moya
 */
public class Cita {
    
    private int codigo_cita;
    private Date fecha;
    private String estado;
    private Cliente cliente;
    private String nombre_mascota;
    private Empleado empleado;

    public Cita(int codigo_cita, Date fecha, String estado, Cliente cliente, String nombre_mascota, Empleado empleado) {
        this.codigo_cita = codigo_cita;
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.nombre_mascota = nombre_mascota;
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
