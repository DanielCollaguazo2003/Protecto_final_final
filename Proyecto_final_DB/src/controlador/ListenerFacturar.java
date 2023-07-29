/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Statement;
import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cabecera_Factura;
import modelo.Detalle_Factura;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class ListenerFacturar implements ActionListener {

    String sSQL = "";
    ConexionOracle conexion;
    VistaLogin vl;
    PreparedStatement ps = null;
    Connection con;
    VistaGeneralSistema vGeneral;
    ListenerAddServicio lladdService;
    Cabecera_Factura factura = null;
    ArrayList<Detalle_Factura> detallesList = new ArrayList<>();

    public ListenerFacturar(ConexionOracle conexion, VistaLogin vl, VistaGeneralSistema vGeneral, Connection con, ListenerAddServicio lladdService) {
        this.conexion = conexion;
        this.vl = vl;
        this.vGeneral = vGeneral;
        this.con = con;
        this.lladdService = lladdService;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        detallesList = lladdService.getListDetalles();
        factura = lladdService.getFactura();
        agregarFacturaBD();
        factura.setCodigo_cb(extraercodigo());
        agregarDetallesFacturaBD(factura.getCodigo_cb());

    }

    private void agregarFacturaBD() {
        try {
            String fechaHoraDate = String.valueOf(factura.getFecha_emision());
            String[] fechaVector = fechaHoraDate.split("T");
            String fecha = fechaVector[0];
            String hora = fechaVector[1];
            float subTotal = factura.getSubtotal();
            float valorIva = factura.getValor_iva();
            float total = factura.getTotal();
            int asuCodigo = factura.getUsuario().getCodigo_u();
            int cliCodigo = factura.getCliente().getCodigo_p();
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_cabeceras_facturas VALUES(veterinaria.proximo_valor_fac_seq, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF'), ?, ?, ?, ?, ?)");
            ps.setString(1, fecha + " " + hora);
            ps.setFloat(2, subTotal);
            ps.setFloat(3, valorIva);
            ps.setFloat(4, total);
            ps.setInt(5, asuCodigo);
            ps.setInt(6, cliCodigo);
            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(vGeneral, "Factura generada con exito");

            } else {
                JOptionPane.showMessageDialog(vl, "Algo fallo durante el proceso");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }

    private int extraercodigo() {
        int codigo = 0;
        try {
            sSQL = "SELECT fac_codigo FROM veterinaria.vt_cabeceras_facturas ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("fac_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }

    private void agregarDetallesFacturaBD(int facCodigo) {
        for (int i = 0; i < detallesList.size(); i++) {
            Detalle_Factura detalle = detallesList.get(i);
            try {
                int cantidad = detalle.getCantidad();
                float precioUnitario = detalle.getPrecio_unitario();
                float subTotal = detalle.getSubtotal();
                float valorIva = detalle.getValor_iva();
                float total = detalle.getTotal();
                int serCodigo = detalle.getServicio().getCodigo_s();

                ps = con.prepareStatement("INSERT INTO veterinaria.vt_detalles_facturas VALUES(veterinaria.proximo_valor_det_seq, ?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, cantidad);           // Proporciona el valor para det_cantidad
                ps.setFloat(2, precioUnitario);   // Proporciona el valor para det_precio_unitario
                ps.setFloat(3, subTotal);         // Proporciona el valor para det_subtotal
                ps.setFloat(4, valorIva);         // Proporciona el valor para det_valor_iva
                ps.setFloat(5, total);            // Proporciona el valor para det_total
                ps.setInt(6, facCodigo);          // Proporciona el valor para fac_codigo
                ps.setInt(7, serCodigo);          // Proporciona el valor para ser_codigo
                int filas = ps.executeUpdate();
                con.setAutoCommit(false);
                
                if (filas == 1) {
                    con.commit();
                    JOptionPane.showMessageDialog(vGeneral, "Detalle generado con exito");

                } else {
                    JOptionPane.showMessageDialog(vGeneral, "Algo fallo durante el proceso");
                }
            } catch (SQLException x) {
                System.out.println(x);
                System.out.println("no");
            }
        }
    }
}
