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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import modelo.DefaultListaServicios;
import modelo.Servicio;
import vista.Clientes;
import vista.CrearClientes;
import vista.Servicios;
import vista.VistaCrearServicios;
import vista.VistaGeneralSistema;
import vista.Vista_Crear_Usuario;

/**
 *
 * @author XaviO_o
 */
public class ListenerCrearServicios implements ActionListener {

    Connection con;
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    VistaCrearServicios vCrearServicios;
    DefaultListaServicios listServicios;
    Servicios serVista;
    Servicio ser = null;
    ControladorBox conBox;
    VistaGeneralSistema vGeneral;

    public ListenerCrearServicios(Connection con, ConexionOracle conexion, VistaCrearServicios vCrearServicios, DefaultListaServicios listServicios, Servicios serVista, ControladorBox conBox, VistaGeneralSistema vGeneral) {
        this.con = con;
        this.conexion = conexion;
        this.vCrearServicios = vCrearServicios;
        this.listServicios = listServicios;
        this.serVista = serVista;
        this.conBox = conBox;
        this.vGeneral = vGeneral;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ingresoServicios();
        int codigoExtraido = extraercodigo();
        if (ser != null) {
            ser.setCodigo_s(codigoExtraido);
            listServicios.addElement(ser);
            vCrearServicios.setVisible(false);
            serVista.repaint();
            conBox.serviciosBoxList();
            vGeneral.getServicioBox().repaint();
            ser = null;
        }
    }

    public void ingresoServicios() {
        try {
            String nombre = vCrearServicios.getNombreServicio().getText();
            String descripcion = vCrearServicios.getDescripcionServicio().getText();
            float precio = Float.parseFloat(vCrearServicios.getPrecioServicio().getText());
            String iva = vCrearServicios.getIvaBoxServicio().getSelectedItem().toString();
            if (iva.equals("Seleccione")){
                throw new RuntimeException("Este es un error personalizado.");
            }
            

            ps = con.prepareStatement("INSERT INTO veterinaria.vt_servicios VALUES(veterinaria.proximo_valor_ser_seq, ?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setFloat(3, precio);
            ps.setString(4, String.valueOf(iva.charAt(0)));
            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(vCrearServicios, "Servicio Ingresado con Exito");
                vCrearServicios.getCodigoServicio().setText("");
                vCrearServicios.getNombreServicio().setText("");
                vCrearServicios.getDescripcionServicio().setText("");
                vCrearServicios.getPrecioServicio().setText("");
                vCrearServicios.getIvaBoxServicio().setSelectedIndex(0);
                ser = new Servicio(0, nombre, descripcion, precio, String.valueOf(iva.charAt(0)));
            } else {
                JOptionPane.showMessageDialog(vCrearServicios, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vCrearServicios, "Existen campos vacios o invalidos");
        }catch(RuntimeException ex){
            JOptionPane.showMessageDialog(vCrearServicios, "Seleccione si el producto tiene IVA");
        }
    }

    private int extraercodigo() {
        int codigo = 0;
        try {
            sSQL = "SELECT ser_codigo FROM veterinaria.vt_servicios ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("ser_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }
}
