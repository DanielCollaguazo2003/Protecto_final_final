/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.sql.Connection;
import java.time.LocalDateTime;
import modelo.Cabecera_Factura;
import modelo.Cliente;
import modelo.DefaultListaClientes;
import modelo.DefaultListaDetalles;
import modelo.DefaultTablaClientes;
import modelo.DefaultTablaDetalles;
import modelo.Usuario;
import vista.ActualizarCliente;
import vista.Citas;
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
public class Controlador {

    VistaLogin vl;
    VistaGeneralSistema vGeneral;
    String user;
    String password;

    public Controlador(VistaLogin vl, VistaGeneralSistema vGeneral, String user, String password) {
        this.vl = vl;
        this.vGeneral = vGeneral;
        this.user = user;
        this.password = password;

        ConexionOracle conexion = new ConexionOracle(user, password);

        Connection con = conexion.conectar();

        DefaultListaDetalles listaDetalles = new DefaultListaDetalles();
        DefaultTablaDetalles tablaDetalles = new DefaultTablaDetalles(listaDetalles);

        ActualizarCliente actCli = new ActualizarCliente();
        Clientes c = new Clientes();
        CrearClientes ccli = new CrearClientes();
        Empleados emp = new Empleados();
        Servicios ser = new Servicios();
        Citas citas = new Citas();

        Vista_Crear_Usuario createUser = new Vista_Crear_Usuario();

        ControladorServicios controladorServicios = new ControladorServicios(vGeneral, conexion, con);

        controladorServicios.serviciosBoxList();

        listenerActualizarClientes lactcli = new listenerActualizarClientes(actCli);
        listenerClientes lcli = new listenerClientes(c);
        listenerCrearClientes laddcli = new listenerCrearClientes(ccli);
        listenerEmpleados lemp = new listenerEmpleados(emp);
        listenerServicios lser = new listenerServicios(ser);
        ListenerCreateUser lCreateUs = new ListenerCreateUser(createUser);
        ListenerCitas cit = new ListenerCitas(citas);
        //ListenerRegresarCreacionClientes lrc = new ListenerRegresarCreacionClientes(ccli);
        ListenerBucarClienteGeneral lBusGen = new ListenerBucarClienteGeneral(conexion, con, vGeneral);
        Cliente cli = null;
        Usuario usu = null;
        Cabecera_Factura factura = new Cabecera_Factura(0,LocalDateTime.MIN, 0, 0, 0, cli, usu);
        ListenerAddServicio lAddService = new ListenerAddServicio(controladorServicios.getListServicios(), lBusGen.getCliente(), vGeneral, listaDetalles, tablaDetalles, factura);
        ListenerDeleteDetalle lDeleteDetalle = new ListenerDeleteDetalle(vGeneral, listaDetalles, tablaDetalles);
        ListenerRegresarCreacionClientes lrc = new ListenerRegresarCreacionClientes(ccli);
        ListenerFinalizarSesion lfs = new ListenerFinalizarSesion(vGeneral, vl);

        vGeneral.listenerDeleteDetalle(lDeleteDetalle);

        vGeneral.listenerAnadirServicios(lAddService);

        vGeneral.listenerActualizar(lactcli);

        vGeneral.listenerClientes(lcli);

        vGeneral.listenerCrearCli(laddcli);

        vGeneral.listenerEmpleados(lemp);

        vGeneral.listenerServicios(lser);

        vGeneral.listenerCitas(cit);

        vGeneral.listenerBuscar(lBusGen);

        vGeneral.listenerFinSesion(lfs);

        vl.listenerCrearUser(lCreateUs);

        ccli.addActionListenerCrear(lrc);

        DefaultListaClientes lisCli = new DefaultListaClientes();
        conexionClientes conCli = new conexionClientes(conexion, con);

        conCli.obtenerClientes(lisCli);
        DefaultTablaClientes tableCli = new DefaultTablaClientes(lisCli);

        c.setModeloTabla(tableCli);
        
        vGeneral.repaint();
        
        vGeneral.setVisible(true);
    }
    
    
}
