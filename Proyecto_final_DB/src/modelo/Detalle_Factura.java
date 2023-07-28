/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Anthony Moya
 */
public class Detalle_Factura {

    private int codigo_dt;
    private int cantidad;
    private float precio_unitario;
    private float subtotal;
    private float valor_iva;
    private float total;
    private Cabecera_Factura cabecera_factura;
    private Servicio servicio;

    public Detalle_Factura(int codigo_dt, int cantidad, float precio_unitario, float subtotal, float valor_iva, float total, Cabecera_Factura cabecera_factura, Servicio servicio) {
        this.codigo_dt = codigo_dt;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
        this.valor_iva = valor_iva;
        this.total = total;
        this.cabecera_factura = cabecera_factura;
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getValor_iva() {
        return valor_iva;
    }

    public void setValor_iva(float valor_iva) {
        this.valor_iva = valor_iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cabecera_Factura getCabecera_factura() {
        return cabecera_factura;
    }

    public void setCabecera_factura(Cabecera_Factura cabecera_factura) {
        this.cabecera_factura = cabecera_factura;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getCodigo_dt() {
        return codigo_dt;
    }

    public void setCodigo_dt(int codigo_dt) {
        this.codigo_dt = codigo_dt;

    }
}
