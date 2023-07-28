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
    Connection con = conexion.conectar();
    VistaGeneralSistema vGeneral;
    
    String user = "veterinaria";
    String password = "12345";
    
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
            
            ps = con.prepareStatement("SELECT usu_nombre_usuario, usu_contrasenia, per_nombre||' '||per_apellido nombre, prm_nombre "
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
    
    private String generarCifrado() throws NoSuchAlgorithmException {
        String password = "Sigua123";
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
        String md5 = DatatypeConverter.printHexBinary(digest);
        return md5;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                
                String user = vl.getUser().getText();
                String password = vl.getPassword().getText();
                
                ps = con.prepareStatement("SELECT usu_nombre_usuario, usu_contrasenia FROM vt_usuarios_sistema WHERE (usu_nombre_usuario=?) AND (usu_contrasenia=?)");
                ps.setString(1, user);
                ps.setString(2, password);
                ResultSet res = ps.executeQuery();
                
                while (res.next()) {
                    //JOptionPane.showMessageDialog(vl, "Inicio de sesion exitosa!");
                    vl.setVisible(false);
                    //vGeneral.setVisible(true);
                    vl.getUser().setText("");
                    vl.getPassword().setText("");
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
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public String getUser() {
        return user;
    }
    
    public String getPassword() {
        return password;
    }
    
}
