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
public class ListenerAgendarCita implements ActionListener{

    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    Connection con;
    Citas vCitas;
    Cliente cli = null;
    VistaGeneralSistema vGeneral;  
    ListenerBuscarClienteCitas lbCit;
    ControladorBox contBox;
    boolean verificar = false;
    String nombreMascota = "";
    int codigoVeterinario = 0;
    int codigoTipoMascota = 0;
    String fechaHora;

    public ListenerAgendarCita(ConexionOracle conexion, Connection con, Citas vCitas, VistaGeneralSistema vGeneral, ControladorBox contBox, ListenerBuscarClienteCitas lbCit) {
        this.conexion = conexion;
        this.con = con;
        this.vCitas = vCitas;
        this.vGeneral = vGeneral;
        this.lbCit = lbCit;
        this.contBox = contBox;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        cli = lbCit.getCli();
        obtenerMascota();
        obtenerCitasValidacion(obtenerFecha(), codigoVeterinario);
        if (verificar==false) {
            agregarCitaBD();
        }else{
            JOptionPane.showMessageDialog(vCitas, "No se puede por que existe una cita agendada a esa hora \n"
                    + "Seleccione otro veterinario u otra fecha");
            verificar = false;
        }
  
    }

    private void obtenerMascota(){
        nombreMascota = vCitas.getNombreMascCitas().getText();
        int indiceMascota = vCitas.getTipoMascota().getSelectedIndex();
        codigoTipoMascota = contBox.getListTipMascotas().get(indiceMascota-1).getCodigo_tm();
        String veterinarioGeneral = vCitas.getVeterinarioCitas().getItemAt(vCitas.getVeterinarioCitas().getSelectedIndex());
        String[] codigoNombreVetUnido = veterinarioGeneral.split("\\s");
        codigoVeterinario = Integer.parseInt(codigoNombreVetUnido[0]);
        String fecha = obtenerFecha();
        //hora = String.valueOf(vCitas.getHoraCitas().getSelectedItem());
        
        System.out.println(nombreMascota +" " + codigoTipoMascota + " "+ codigoVeterinario + " " + fecha );
    }
    
    public String obtenerFecha(){
        Date date = vCitas.getDateCitas().getDate();
        long d = date.getTime();
        java.sql.Date fecha =  new java.sql.Date(d);
        String fechaTXT = String.valueOf(fecha);
        String fechaHoraTotal = fechaTXT+ " "+ String.valueOf(vCitas.getHoraCitas().getSelectedItem())+":00";
        fechaHora = fechaHoraTotal;
        return fechaHoraTotal;
    }
    
    private void obtenerCitasValidacion(String fechaHora, int codigoVeterinario){
        try {
            ps = con.prepareStatement("""
                                      SELECT * FROM veterinaria.vt_citas c
                                      WHERE  (c.emp_codigo = ?) AND
                                      (c.cit_fecha = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))""");
            ps.setInt(1, codigoVeterinario);
            ps.setString(2, fechaHora);
            ResultSet res = ps.executeQuery();
            System.out.println(fechaHora);
            while (res.next()) {
                verificar = true;
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }
    
    private void agregarCitaBD(){
        try {
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_citas VALUES(veterinaria.proximo_valor_cit_seq, TO_TIMESTAMP(?, 'YYYY-MM-DD HH24:MI:SS.FF'), 'A', ?, ?, ?, ?)");
            ps.setString(1, fechaHora);
            ps.setString(2, nombreMascota);
            ps.setInt(3, codigoVeterinario);
            ps.setInt(4, cli.getCodigo_p());
            ps.setInt(5, codigoTipoMascota);
            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(vCitas, "Cita agendadacon exito");

            } else {
                JOptionPane.showMessageDialog(vCitas, "Algo fallo durante el proceso");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        
    }
    
    
}
