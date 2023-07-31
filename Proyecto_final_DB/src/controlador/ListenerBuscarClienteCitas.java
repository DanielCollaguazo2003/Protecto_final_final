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
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cliente;
import vista.Citas;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class ListenerBuscarClienteCitas implements ActionListener {

    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    Citas vCitas;
    Cliente cli = null;
    VistaGeneralSistema vGeneral;  
    ListenerBucarClienteGeneral lbGen;
    ControladorBox contBox;
    boolean verificar = false;
    String nombreMascota = "";
    int codigoVeterinario = 0;
    int codigoTipoMascota = 0;
    String fechaHora;

    public ListenerBuscarClienteCitas(ConexionOracle conexion, Connection con, Citas vCitas, VistaGeneralSistema vGeneral, ControladorBox contBox) {
        this.conexion = conexion;
        this.con = con;
        this.vCitas = vCitas;
        this.vGeneral = vGeneral;
        this.lbGen = new ListenerBucarClienteGeneral(conexion, con, vGeneral);
        this.contBox = contBox;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        buscarCliente();
        vCitas.getNombreCitas().setText(cli.getNombre() + " "+ cli.getApellido());
        vCitas.getCorreoCitas().setText(cli.getCorreo());
    }

    private void buscarCliente(){
        String cedula = vCitas.getCedulaCitas().getText();
        lbGen.obtenerClienteBD(vCitas, cedula);
        cli = lbGen.getCliente();
        vCitas.getNombreCitas().setText(cli.getNombre() + " " + cli.getApellido());
        vCitas.getCorreoCitas().setText(cli.getCorreo());
    }

    public Cliente getCli() {
        return cli;
    }
    
}

