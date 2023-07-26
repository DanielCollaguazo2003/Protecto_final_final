/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import modelo.Empleado;
import vista.ActualizarCliente;
import vista.Clientes;
import vista.CrearClientes;
import vista.Empleados;
import vista.Servicios;
import vista.VistaGeneralSistema;
import vista.VistaLogin;
import vista.Vista_Crear_Usuario;

/**
 *
 * @author XaviO_o
 */
public class principal {
    public static void main(String[] args) {
        VistaLogin vl = new VistaLogin();
        ConexionOracle conexion =  new ConexionOracle();
        
        ActualizarCliente actCli = new ActualizarCliente();
        Clientes c = new Clientes();
        CrearClientes ccli = new CrearClientes();
        Empleados emp = new Empleados();
        Servicios ser = new Servicios();
        
        VistaGeneralSistema vGeneral = new VistaGeneralSistema();
        Vista_Crear_Usuario createUser = new Vista_Crear_Usuario();
        
        Connection con = conexion.conectar();
        listener_login ll = new listener_login(conexion, vl, con, vGeneral);
        
        listenerActualizarClientes lactcli = new listenerActualizarClientes(actCli);
        listenerClientes lcli = new listenerClientes(c);
        listenerCrearClientes laddcli = new listenerCrearClientes(ccli);
        listenerEmpleados lemp = new listenerEmpleados(emp);
        listenerServicios lser = new listenerServicios(ser);
        ListenerCreateUser lCreateUs = new ListenerCreateUser(createUser);
        
        vGeneral.listenerActualizar(lactcli);
        vGeneral.listenerClientes(lcli);
        vGeneral.listenerCrearCli(laddcli);
        vGeneral.listenerEmpleados(lemp);
        vGeneral.listenerServicios(lser);
        vl.listenerCrearUser(lCreateUs);
        
        vl.listener_login(ll);
        
        vl.setVisible(true);
    }
}
