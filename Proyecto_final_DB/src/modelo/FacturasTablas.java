/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author XaviO_o
 */
public class FacturasTablas {
    private int codigo_cb;
    private String cliente;
    private String empleado;
    private String fecha_emision;
    private int cantidad;
    private float subtotal;
    private float total;
    private float valor_iva;

    public FacturasTablas(int codigo_cb, String cliente, String empleado, String fecha_emision, int cantidad, float subtotal, float total, float valor_iva) {
        this.codigo_cb = codigo_cb;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha_emision = fecha_emision;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.total = total;
        this.valor_iva = valor_iva;
    }

    public int getCodigo_cb() {
        return codigo_cb;
    }

    public void setCodigo_cb(int codigo_cb) {
        this.codigo_cb = codigo_cb;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getValor_iva() {
        return valor_iva;
    }

    public void setValor_iva(float valor_iva) {
        this.valor_iva = valor_iva;
    }

}
