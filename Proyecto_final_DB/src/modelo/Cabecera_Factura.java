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
public class Cabecera_Factura {
    private LocalDateTime fecha_emision;
    private float subtotal;
    private float valor_iva;
    private float total;
    private Cliente cliente;
    private Usuario usuario;

    public Cabecera_Factura(LocalDateTime fecha_emision, float subtotal, float valor_iva, float total, Cliente cliente, Usuario usuario) {
        this.fecha_emision = fecha_emision;
        this.subtotal = subtotal;
        this.valor_iva = valor_iva;
        this.total = total;
        this.cliente = cliente;
        this.usuario = usuario;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
