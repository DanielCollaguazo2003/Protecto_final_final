/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cabecera_Factura;
import modelo.Cliente;
import modelo.DefaultListaDetalles;
import modelo.DefaultTablaDetalles;
import modelo.Detalle_Factura;
import modelo.Empleado;
import modelo.Servicio;
import modelo.Usuario;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class ListenerAddServicio implements ActionListener {

    ArrayList<Servicio> listServicios;
    Cliente cli;
    VistaGeneralSistema vGeneral;
    DefaultListaDetalles listaDetalles;
    DefaultTablaDetalles tableDetalles;
    LocalDateTime fechaHoraActual = LocalDateTime.now();
    Cabecera_Factura factura;

    float cantidadsubtotal = 0;
    float cantidadTotal = 0;
    float cantidadIVA = 0;

    public ListenerAddServicio(ArrayList<Servicio> listServicios, Cliente cli, VistaGeneralSistema vGeneral, DefaultListaDetalles listaDetalles, DefaultTablaDetalles tableDetalles, Cabecera_Factura factura) {
        this.listServicios = listServicios;
        this.cli = cli;
        this.vGeneral = vGeneral;
        this.listaDetalles = listaDetalles;
        this.tableDetalles = tableDetalles;
        this.factura = factura;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Obtener el codigo del servicio
        String servicio = vGeneral.getServicioBox().getSelectedItem().toString();
        String[] partes = servicio.split("\\s+");
        Servicio ServicioCompleto = null;
        //comparamos el codigo obtenido para obtener el servicio de nuestra tabla de servicios
        for (Servicio ser : listServicios) {
            if (ser.getCodigo_s()== Integer.parseInt(partes[0])) {
                ServicioCompleto = ser;
            }
        }
        int cantidad = 1;

        //Obtener cantidad del iva en caso de tener iva
        float totalIva = 0;
        float subtotal = 0;
        float total = 0;
        //Obtener valor subtotal
        if (ServicioCompleto.getIva().equals("S")) {
            totalIva = ((ServicioCompleto.getPrecio() * 12) / 100) * cantidad;
        }
        subtotal = cantidad * ServicioCompleto.getPrecio();
        total = subtotal + totalIva;
        //////
        Usuario usu = null;
        if (buscarDetalle(ServicioCompleto) == false) {
            factura = new Cabecera_Factura(0, fechaHoraActual, 0, 0, 0, cli, usu);
            Detalle_Factura detalle = new Detalle_Factura(ServicioCompleto.getCodigo_s(), cantidad, ServicioCompleto.getPrecio(), subtotal, totalIva, total, factura, ServicioCompleto);
/*
            Cabecera_Factura cabecera = new Cabecera_Factura(0,new Date(2023, 02, 12), 0, 0, 0, cli, usu);
            Detalle_Factura detalle = new Detalle_Factura(ServicioCompleto.getCodigo_s(), cantidad, ServicioCompleto.getPrecio(), subtotal, totalIva, total, cabecera, ServicioCompleto);
*/
            listaDetalles.addElement(detalle);
            vGeneral.tableModelDetalles(tableDetalles);

        } else {
            vGeneral.tableModelDetalles(tableDetalles);
            vGeneral.repaint();
        }
        calcularTotalFactura();
        factura.setSubtotal(cantidadsubtotal);
        factura.setValor_iva(cantidadIVA);
        factura.setTotal(cantidadTotal);
    }

    private boolean buscarDetalle(Servicio nuevoServicio) {
        float ivaTotal = 0;
        float subtotal = 0;
        float total = 0;
        for (Detalle_Factura detalles : listaDetalles.getListaDetalles()) {
            if (nuevoServicio.getCodigo_s()== detalles.getCodigo_dt()) {
                int cantidadNueva = detalles.getCantidad();
                detalles.setCantidad(cantidadNueva + 1);

                if (nuevoServicio.getIva().equals("S")) {
                    ivaTotal = ((nuevoServicio.getPrecio() * 12) / 100) * (cantidadNueva + 1);
                }
                subtotal = (cantidadNueva + 1) * nuevoServicio.getPrecio();
                total = subtotal + ivaTotal;

                detalles.setSubtotal(subtotal);
                detalles.setValor_iva(ivaTotal);
                detalles.setTotal(total);
                return true;
            }
        }
        return false;
    }

    private void calcularTotalFactura() {
        int cantidadFilas = vGeneral.getTableServices().getRowCount();
        if (cantidadFilas != 1) {
            cantidadsubtotal = 0;
            cantidadTotal = 0;
            cantidadIVA = 0;
            for (int i = 0; i < cantidadFilas; i++) {
                Detalle_Factura detalle = listaDetalles.getElementAt(i);
                //subtotal
                cantidadsubtotal = cantidadsubtotal + detalle.getSubtotal();
                //total
                cantidadTotal = cantidadTotal + detalle.getTotal();
                //iva
                cantidadIVA = cantidadIVA + detalle.getValor_iva();
            }
        } else {
            Detalle_Factura detalle = listaDetalles.getElementAt(cantidadFilas - 1);
            cantidadsubtotal = detalle.getSubtotal();
            cantidadIVA = detalle.getValor_iva();
            cantidadTotal = detalle.getTotal();
        }
        vGeneral.getSubtotalGen().setText("$ " + String.valueOf(cantidadsubtotal));
        vGeneral.getTotalIvaGen().setText("$ " + String.valueOf(cantidadIVA));
        vGeneral.getTotalGen().setText("$ " + String.valueOf(cantidadTotal));
    }

    /*
    public void agregarDetalleBD(){
        try {

            String cedula = vGeneral.getCedulacam().getText();
            ps = con.prepareStatement("SELECT * FROM vt_clientes c, vt_personas p WHERE (c.per_codigo=p.per_codigo) and (p.per_cedula=? and c.cli_estado='A')");
            ps.setString(1, cedula);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                String estado = res.getString("cli_estado");
                String nombre = res.getString("per_nombre");
                String apellido = res.getString("per_apellido");
                String cedulaCli = res.getString("per_cedula");
                String direccion_p = res.getString("per_direccion_principal");
                String direccion_s = res.getString("per_direccion_secundaria");
                String telefono = res.getString("per_telefono");
                String correo = res.getString("per_correo_electronico");
                cli = new Cliente(estado, cedulaCli, nombre, apellido, direccion_p, direccion_s, telefono, correo);
                
                vGeneral.getNombreGen().setText(cli.getNombre()+" "+cli.getApellido());
                vGeneral.getCedulaGen().setText(cli.getCedula());
                vGeneral.getDireccionGen().setText(cli.getDireccion_p()+" "+cli.getDireccion_s());
                vGeneral.getTelefonoGen().setText(cli.getTelefono());
                vGeneral.getCorreoGen().setText(cli.getCorreo());

            }

            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(vGeneral, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }*/
}
