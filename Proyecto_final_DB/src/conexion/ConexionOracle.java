/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionOracle {

    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
    private final String USER;
    private final String PASWORD;
    public Connection cadena;

    public ConexionOracle(String USER, String PASWORD) {
        this.cadena = null;
        this.USER = USER;
        this.PASWORD = PASWORD;
    }

    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL, USER, PASWORD);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;

    }

    public void desconectar() {
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
