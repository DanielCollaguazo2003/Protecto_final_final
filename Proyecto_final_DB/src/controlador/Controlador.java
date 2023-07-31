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
import modelo.DefaultListaServicios;
import modelo.DefaultTablaClientes;
import modelo.DefaultTablaDetalles;
import modelo.DefaultTablaServicios;
import modelo.Usuario;
import vista.ActualizarCliente;
import vista.ActualizarEmpleado;
import vista.Citas;
import vista.Clientes;
import vista.CrearClientes;
import vista.Empleados;
import vista.Servicios;
import vista.VistaCrearServicios;
import vista.VistaGeneralSistema;
import vista.VistaLogin;
import vista.Vista_Crear_Usuario;

/**
 *
 * @author XaviO_o
 */
public class Controlador {

    public Controlador(VistaLogin vl, VistaGeneralSistema vGeneral, String user, String password, Usuario usu) {

        ConexionOracle conexion = new ConexionOracle(user, password);

        Connection con = conexion.conectar();

        DefaultListaClientes lisCli = new DefaultListaClientes();
        DefaultListaDetalles listaDetalles = new DefaultListaDetalles();
        DefaultTablaDetalles tablaDetalles = new DefaultTablaDetalles(listaDetalles);
        DefaultListaServicios lisServ = new DefaultListaServicios();
        DefaultTablaServicios tablaServicios = new DefaultTablaServicios(lisServ);

        ActualizarCliente actCli = new ActualizarCliente();
        Clientes c = new Clientes();
        CrearClientes ccli = new CrearClientes();
        Empleados emp = new Empleados();
        Servicios ser = new Servicios();
        Citas citas = new Citas();
        ActualizarEmpleado actEmpleado = new ActualizarEmpleado();
        VistaCrearServicios vCrearServicios = new VistaCrearServicios();

        Vista_Crear_Usuario createUser = new Vista_Crear_Usuario();

        ControladorBox controladorServicios = new ControladorBox(vGeneral, citas, conexion, con);

        controladorServicios.serviciosBoxList();
        controladorServicios.veterinariosBox();
        controladorServicios.tipoMascotaBox();

        listenerActualizarClientes lactcli = new listenerActualizarClientes(actCli);
        listenerClientes lcli = new listenerClientes(c);
        listenerCrearClientes laddcli = new listenerCrearClientes(ccli);
        listenerEmpleados lemp = new listenerEmpleados(emp);
        listenerServicios lser = new listenerServicios(ser);
        ListenerCreateUser lCreateUs = new ListenerCreateUser(createUser);
        ListenerCitas cit = new ListenerCitas(citas);
        //ListenerRegresarCreacionClientes lrc = new ListenerRegresarCreacionClientes(ccli);
        ListenerBucarClienteGeneral lBusGen = new ListenerBucarClienteGeneral(conexion, con, vGeneral);
        Cliente cli = lBusGen.getCliente();
        ListenerAddServicio lAddService = new ListenerAddServicio(controladorServicios.getListServicios(), usu, vGeneral, listaDetalles, tablaDetalles, lBusGen);
        ListenerDeleteDetalle lDeleteDetalle = new ListenerDeleteDetalle(vGeneral, listaDetalles, tablaDetalles);
        ListenerRegresarCreacionClientes lrc = new ListenerRegresarCreacionClientes(ccli);
        ListenerFinalizarSesion lfs = new ListenerFinalizarSesion(vGeneral, vl);
        ListenerFacturar lFacturar = new ListenerFacturar(conexion, vl, vGeneral, con, lAddService);
        ListenerCrearClienteSistema lccs = new ListenerCrearClienteSistema(con, ccli, conexion, lisCli, c);
        ListenerCrearClienteControl lccc = new ListenerCrearClienteControl(c, ccli);
        ListenerBorrarClienteControl lbcc = new ListenerBorrarClienteControl(c, con, ccli, conexion, lisCli);
        ListenerBucarActualizar lbact = new ListenerBucarActualizar(conexion, con, actCli);
        ListenerActualizarActualizar lactact = new ListenerActualizarActualizar(conexion, con, actCli);
        ListenerBuscarClienteCitas lbcCitas = new ListenerBuscarClienteCitas(conexion, con, citas, vGeneral, controladorServicios);
        ListenerAgendarCita lAgendarCita = new ListenerAgendarCita(conexion, con, citas, vGeneral, controladorServicios, lbcCitas);
        ListenerCrearActualizarServicioVista lCrearServicioVista = new ListenerCrearActualizarServicioVista(vCrearServicios);
        ListenerBuscarServicio lBuscarServicio = new ListenerBuscarServicio(conexion, con, vCrearServicios);
        ListenerActualizarServicio lActualzarServicio = new ListenerActualizarServicio(conexion, con, vCrearServicios, lisServ, ser);
        ListenerCrearServicios listenerCrearServicios = new ListenerCrearServicios(con, conexion, vCrearServicios, lisServ, ser, controladorServicios, vGeneral);
        ListenerBuscarActualizarEmpleado lbusActEmp = new ListenerBuscarActualizarEmpleado(conexion, con, actEmpleado);
        //ListenerActualizarEmpleado lActEmpleado = new ListenerActualizarEmpleado(conexion, con, actCli);
        ListenerMostrarVentaaActualizarEmp lmActEmp = new ListenerMostrarVentaaActualizarEmp(actEmpleado);
        
        
        
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
        vGeneral.listenerFacturar(lFacturar);
        
        emp.listenerActEmpleado(lmActEmp);

        ser.listenerCrearActualizarServicio(lCrearServicioVista);

        vCrearServicios.listenerBuscarServicio(lBuscarServicio);
        vCrearServicios.listenerActualizarServicio(lActualzarServicio);
        vCrearServicios.listenerCrearServicio(listenerCrearServicios);

        ccli.addActionListenerCrear(lrc);
        ccli.addActionListenerCrearUsuario(lccs);

        actCli.listenerBuscarCliente(lbact);
        actCli.listenerActualizarCliente(lactact);

        citas.listenerBuscarClienteCita(lbcCitas);
        citas.listenerAgendarCita(lAgendarCita);

        c.addActionListenerBotonCrear(lccc);
        c.addActionListenerBotonEliminar(lbcc);
        
        actEmpleado.listenerBuscarEmpleado(lbusActEmp);
        
        conexionTablas conCli = new conexionTablas(conexion, con);

        conCli.obtenerClientes(lisCli);
        conCli.obtenerServicios(lisServ);

        ser.setModelTableServicios(tablaServicios);

        DefaultTablaClientes tableCli = new DefaultTablaClientes(lisCli);

        c.setModeloTabla(tableCli);

        vGeneral.repaint();

        vGeneral.setVisible(true);
    }

}
