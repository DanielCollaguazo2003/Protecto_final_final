/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class principal {
    public static void main(String[] args) {
        VistaLogin vl = new VistaLogin();
        ConexionOracle conexion =  new ConexionOracle();
        Connection con = conexion.conectar();
        listener_login ll = new listener_login(conexion, vl, con);
        vl.listener_login(ll);
        
        vl.setVisible(true);
    }
}
