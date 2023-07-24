
package controlador;


import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class listener_login implements ActionListener {

    String sSQL = "";
    ConexionOracle conexion;
    VistaLogin vl;
    PreparedStatement ps=null;
    Connection con;
    
    public listener_login(ConexionOracle conexion, VistaLogin vl, Connection con) {
        this.conexion = conexion;
        this.vl = vl;
        this.con=con;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String user = vl.getUser().getText();
            String password = vl.getPassword().getText();

            
            ps = con.prepareStatement("SELECT usu_nombre_usuario, usu_contrasenia FROM vt_usuarios_sistema WHERE (usu_nombre_usuario=?) AND (usu_contrasenia=?)");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                JOptionPane.showMessageDialog(vl,"Inicio de sesion exitosa!");
            }
            
            res = ps.executeQuery();
            
            if (res.next() == false){
                JOptionPane.showMessageDialog(vl,"Inicio de sesion Fallida!");
            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
    }

}
