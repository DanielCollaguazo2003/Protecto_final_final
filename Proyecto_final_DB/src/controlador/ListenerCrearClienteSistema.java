/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import vista.Clientes;
import vista.CrearClientes;

/**
 *
 * @author Anthony Moya
 */
public class ListenerCrearClienteSistema implements ActionListener {

    Connection con;
    CrearClientes cr;
    String sSQL = "";
    ConexionOracle conexion;
    PreparedStatement ps = null;
    DefaultListaClientes defaultListaClientes;
    Cliente c = null;
    Clientes cliVista;

    public ListenerCrearClienteSistema(Connection con, CrearClientes cr, ConexionOracle conexion, DefaultListaClientes defaultListaClientes, Clientes cliVista) {
        this.con = con;
        this.cr = cr;
        this.conexion = conexion;
        this.defaultListaClientes = defaultListaClientes;
        this.cliVista = cliVista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean validacion_doc = idValidator(cr.getjTextFieldNDoc().getText());
        boolean validacion_mail = correoValidator(cr.getjTextFieldCorreo().getText());
        if (validacion_doc == true && validacion_mail == true && !"".equals(cr.getjTextFieldNDoc().getText())
                && !"".equals(cr.getjTextFieldNombres().getText()) && !"".equals(cr.getjTextFieldApellidos().getText())
                && !"".equals(cr.getjTextFieldCorreo().getText()) && !"".equals(cr.getjTextFieldDirPrincipal().getText())
                && !"".equals(cr.getjTextFieldDirSec().getText()) && !"".equals(cr.getjTextFieldNumCell().getText())) {
            ingresoPersonas(0);
            ingresoClientes(extraercodigo());
            int codigo = extraercodigoCliente();
            c.setCodigo_p(codigo);
            defaultListaClientes.addElement(c);
            cliVista.repaint();
            resetCampos();
            
        } else {
            JOptionPane.showMessageDialog(cr, "Datos Invalidos");
        }
    }

    public boolean idValidator(String id) {
//banderas de identificación
        boolean validId;

        if (id.length() == 10) { //Longitud de la cédula      
            int thirdDigit = Integer.parseInt(id.substring(2, 3));
            if (thirdDigit < 6) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[] idValCoef = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                int checker = Integer.parseInt(id.substring(9, 10));
                int addition = 0;
                int digit = 0;
                for (int i = 0; i < (id.length() - 1); i++) {
                    digit = Integer.parseInt(id.substring(i, i + 1)) * idValCoef[i];
                    addition += ((digit % 10) + (digit / 10));
                }

                if ((addition % 10 == 0) && (addition % 10 == checker)) {
                    validId = true;
                } else if ((10 - (addition % 10)) == checker) {
                    validId = true;
                } else {
                    validId = false;
                }
            } else {
                validId = false;
            }
        } else {
            validId = false;
        }

        return validId;
    }

    public boolean correoValidator(String correo) {
        boolean matches = correo.matches("^[a-z0-9]+@(gmail|outlook|yahoo|hotmail)\\.(com|es|net|org)$");
        return matches;
    }

    public void ingresoPersonas(int codigo) {
        String cedula = cr.getjTextFieldNDoc().getText();
        String nombre = cr.getjTextFieldNombres().getText();
        String apellido = cr.getjTextFieldApellidos().getText();
        String correo = cr.getjTextFieldCorreo().getText();
        String direccion_p = cr.getjTextFieldDirPrincipal().getText();
        String direccion_s = cr.getjTextFieldDirSec().getText();
        String telefono = cr.getjTextFieldNumCell().getText();
        try {
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_personas VALUES(veterinaria.proximo_valor_per_seq, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, direccion_p);
            ps.setString(5, direccion_s);
            ps.setString(6, telefono);
            ps.setString(7, correo);
            
            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(cr, "Usuario Ingresado con Exito");

            } else {
                JOptionPane.showMessageDialog(cr, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        c= new Cliente("A", codigo, cedula, nombre, apellido, direccion_p, direccion_s, telefono, correo);
    }
    
    private int extraercodigo() {
        int codigo = 0;
        try {
            sSQL = "SELECT per_codigo FROM veterinaria.vt_personas ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("per_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }
    
    private int extraercodigoCliente() {
        int codigo = 0;
        try {
            sSQL = "SELECT cli_codigo FROM veterinaria.vt_clientes ORDER BY 1 DESC FETCH FIRST ROW ONLY";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                codigo = res.getInt("cli_codigo");
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return codigo;
    }
    
    
        public void ingresoClientes(int extraerCodigo) {
        String estado = "A";

        try {
            ps = con.prepareStatement("INSERT INTO veterinaria.vt_clientes VALUES(veterinaria.proximo_valor_cli_seq, ?, ?)");
            ps.setString(1, estado);
            ps.setInt(2, extraerCodigo);

            
            int filas = ps.executeUpdate();
            con.setAutoCommit(false);

            if (filas == 1) {
                con.commit();
                JOptionPane.showMessageDialog(cr, "Cliente Ingresado con Exito");

            } else {
                JOptionPane.showMessageDialog(cr, "Algo fallo durante el proceso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListenerCrearClienteSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resetCampos(){
        cr.getjTextFieldNDoc().setText("");
        cr.getjTextFieldNombres().setText("");
        cr.getjTextFieldApellidos().setText("");
        cr.getjTextFieldCorreo().setText("");
        cr.getjTextFieldDirPrincipal().setText("");
        cr.getjTextFieldDirSec().setText("");
        cr.getjTextFieldNumCell().setText("");
    } 
    
    
}
