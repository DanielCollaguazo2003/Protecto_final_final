package controlador;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.xdevapi.PreparableStatement;
import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import javax.swing.JOptionPane;
import vista.VistaLogin;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import modelo.Empleado;
import modelo.Permiso;
import modelo.Usuario;
import vista.VistaGeneralSistema;

/**
 *
 * @author XaviO_o
 */
public class listener_login implements ActionListener, KeyListener {
    
    String sSQL = "";
    ConexionOracle conexion = new ConexionOracle("veterinaria", "12345");
    VistaLogin vl;
    PreparedStatement ps = null;
    PreparedStatement ps2 = null;
    Connection con = conexion.conectar();
    VistaGeneralSistema vGeneral;
    
    String user = "veterinaria";
    String password = "12345";
    Usuario usu = null;
    Empleado emp = null;
    boolean verfificar = false;
    
    public listener_login(VistaLogin vl, VistaGeneralSistema vGeneral) {
        this.vl = vl;
        this.vGeneral = vGeneral;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            
            user = vl.getUser().getText();
            password = vl.getPassword().getText();
            
            ps = con.prepareStatement("SELECT usu_codigo, usu_nombre_usuario, usu_contrasenia, per_nombre||' '||per_apellido nombre, prm_nombre "
                    + "FROM vt_usuarios_sistema u, vt_personas p, vt_empleados e, vt_permisos p "
                    + "WHERE (u.emp_codigo = e.emp_codigo) and (e.prm_codigo = p.prm_codigo) and (p.per_codigo = e.per_codigo) and (usu_nombre_usuario=?) AND (usu_contrasenia=?)");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet res = ps.executeQuery();
            
            while (res.next()) {
                //JOptionPane.showMessageDialog(vl, "Inicio de sesion exitosa!");
                vl.setVisible(false);
                // vGeneral.setVisible(true);
                vl.getUser().setText("");
                vl.getPassword().setText("");
                verfificar = true;
                vGeneral.getUsuarioLabel().setText(res.getString("nombre") + "(" + res.getString("prm_nombre") + ")");
                extraerEmpleado();
                if (res.getString("prm_nombre").equals("General")) {
                    vGeneral.getClientes().setEnabled(false);
                    vGeneral.getEmpleados().setEnabled(false);
                    vGeneral.getEstadisticas().setEnabled(false);
                    vGeneral.getCitas().setEnabled(false);
                    vGeneral.getServiciosBoton().setEnabled(false);
                }
                usu = new Usuario(res.getInt("usu_codigo"), res.getString("usu_nombre_usuario"), res.getString("usu_contrasenia"), emp);
                conexion.desconectar();
                
            }
            
            res = ps.executeQuery();
            
            if (res.next() == false) {
                JOptionPane.showMessageDialog(vl, "Inicio de sesion Fallida!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }
    
    private void extraerEmpleado(){
        try {

            String cedula = vGeneral.getCedulacam().getText();
            ps2 = con.prepareStatement("SELECT * FROM vt_empleados e, vt_personas p WHERE (e.per_codigo=p.per_codigo) and (e.per_cedula=?)");
            ps2.setString(1, cedula);
            ResultSet res = ps2.executeQuery();
            
            while (res.next()) {
                String tipo = res.getString("emp_tipo");
                String nombre = res.getString("per_nombre");
                String apellido = res.getString("per_apellido");
                String cedulaEmp = res.getString("per_cedula");
                String direccion_p = res.getString("per_direccion_principal");
                String direccion_s = res.getString("per_direccion_secundaria");
                String telefono = res.getString("per_telefono");
                String correo = res.getString("per_correo_electronico");
                emp = new Empleado(tipo, 0,new Permiso(0, "", ""), cedula, nombre, apellido, direccion_p, direccion_s, telefono, correo);
            }

            res = ps.executeQuery();

            if (res.next() == false) {
                JOptionPane.showMessageDialog(vGeneral, "Usuario no encontrado!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    
    }
    
    public String getUser() {
        return user;
    }
    
    public String getPassword() {
        return password;
    }

    public Usuario getUsu() {
        return usu;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
