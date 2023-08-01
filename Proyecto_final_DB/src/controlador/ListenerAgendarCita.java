/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cita;
import modelo.Cliente;
import modelo.DefaultListaCitas;
import modelo.Empleado;
import modelo.Tipo_Mascota;
import vista.Citas;
import vista.VistaGeneralSistema;
import vista.VistaMostrarCitas;

/**
 *
 * @author XaviO_o
 */
public class ListenerAgendarCita implements ActionListener {

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
    DefaultListaCitas listCitas;
    VistaMostrarCitas vmoMostrarCitas;

    public ListenerAgendarCita(ConexionOracle conexion, Connection con, Citas vCitas, VistaGeneralSistema vGeneral, ControladorBox contBox, ListenerBuscarClienteCitas lbCit, DefaultListaCitas listCitas, VistaMostrarCitas vmoMostrarCitas) {
        this.conexion = conexion;
        this.con = con;
        this.vCitas = vCitas;
        this.vGeneral = vGeneral;
        this.lbCit = lbCit;
        this.contBox = contBox;
        this.listCitas = listCitas;
        this.vmoMostrarCitas = vmoMostrarCitas;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            cli = lbCit.getCli();
            obtenerMascota();
            obtenerCitasValidacion(obtenerFecha(), codigoVeterinario);
            if (verificar == false) {
                agregarCitaBD();
                actualizardatostabla();
            } else {
                JOptionPane.showMessageDialog(vCitas, "No se puede por que existe una cita agendada a esa hora \n"
                        + "Seleccione otro veterinario u otra fecha");
                verificar = false;
            }
        } catch (IndexOutOfBoundsException | NumberFormatException | NullPointerException | DateTimeParseException ex) {
            JOptionPane.showMessageDialog(vCitas, "Existen campos vacios o invalidos");
        }

    }

    private void obtenerMascota() {
        nombreMascota = vCitas.getNombreMascCitas().getText();
        int indiceMascota = vCitas.getTipoMascota().getSelectedIndex();
        codigoTipoMascota = contBox.getListTipMascotas().get(indiceMascota - 1).getCodigo_tm();
        String veterinarioGeneral = vCitas.getVeterinarioCitas().getItemAt(vCitas.getVeterinarioCitas().getSelectedIndex());
        String[] codigoNombreVetUnido = veterinarioGeneral.split("\\s");
        codigoVeterinario = Integer.parseInt(codigoNombreVetUnido[0]);
        String fecha = obtenerFecha();
        //hora = String.valueOf(vCitas.getHoraCitas().getSelectedItem());

        System.out.println(nombreMascota + " " + codigoTipoMascota + " " + codigoVeterinario + " " + fecha);
    }

    public String obtenerFecha() {
        Date date = vCitas.getDateCitas().getDate();
        long d = date.getTime();
        java.sql.Date fecha = new java.sql.Date(d);
        String fechaTXT = String.valueOf(fecha);
        String fechaHoraTotal = fechaTXT + " " + String.valueOf(vCitas.getHoraCitas().getSelectedItem()) + ":00";
        fechaHora = fechaHoraTotal;
        return fechaHoraTotal;
    }

    private void obtenerCitasValidacion(String fechaHora, int codigoVeterinario) {
        try {
            ps = con.prepareStatement("""
                                      SELECT * FROM veterinaria.vt_citas c
                                      WHERE cit_estado = ? AND (c.emp_codigo = ?) AND
                                      (c.cit_fecha = TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS')) """);
            ps.setString(1, "A");
            ps.setInt(2, codigoVeterinario);
            ps.setString(3, fechaHora);

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

    private void agregarCitaBD() {
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

    private void actualizardatostabla() {
        int codigo = obtenerCodigoUltimacita();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fecha = LocalDateTime.parse(fechaHora, formatter);
        Empleado e = new Empleado("", 0, null, "", "", "", "", "", "", "");
        e.setCodigo_p(codigoVeterinario);
        Tipo_Mascota tipo_Mascota = new Tipo_Mascota(codigoTipoMascota, "");
        Cita c = new Cita(codigo, fecha, "A", cli, nombreMascota, e, tipo_Mascota);
        listCitas.addElement(c);
        listCitas.clearAllElements();
        conexionTablas cont = new conexionTablas(conexion, con);
        cont.obtenerCitas(listCitas);
        vmoMostrarCitas.repaint();
    }

    private int obtenerCodigoUltimacita() {
        int codigo = 0;
        try {
            sSQL = "SELECT cit_codigo FROM veterinaria.vt_citas ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("cit_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }

}
