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
import modelo.DefaultListaCitas;
import modelo.DefaultListaClientes;
import modelo.DefaultListaDetalles;
import modelo.DefaultListaEmplados;
import modelo.DefaultListaFacturas;
import modelo.DefaultListaServicios;
import modelo.DefaultTablaCitas;
import modelo.DefaultTablaClientes;
import modelo.DefaultTablaDetalles;
import modelo.DefaultTablaEmpleados;
import modelo.DefaultTablaFacturas;
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
import vista.VistaMostarFacturas;
import vista.VistaMostrarCitas;

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
        DefaultListaEmplados listEmpleados = new DefaultListaEmplados();
        DefaultTablaEmpleados tablaEmpleados = new DefaultTablaEmpleados(listEmpleados);
        DefaultListaCitas listCitas = new DefaultListaCitas();
        DefaultTablaCitas tablaCitas = new DefaultTablaCitas(listCitas);
        DefaultListaFacturas listFacturas = new DefaultListaFacturas();
        DefaultTablaFacturas tablaFacturas = new DefaultTablaFacturas(listFacturas);

        ActualizarCliente actCli = new ActualizarCliente();
        Clientes c = new Clientes();
        CrearClientes ccli = new CrearClientes();
        Empleados emp = new Empleados();
        Servicios ser = new Servicios();
        Citas citas = new Citas();
        ActualizarEmpleado actEmpleado = new ActualizarEmpleado();
        VistaCrearServicios vCrearServicios = new VistaCrearServicios();
        VistaMostrarCitas vmoCitas = new VistaMostrarCitas();
        VistaMostarFacturas vmostrFacturas = new VistaMostarFacturas();

        ControladorBox controladorServicios = new ControladorBox(vGeneral, citas, conexion, con);

        controladorServicios.serviciosBoxList();
        controladorServicios.veterinariosBox();
        controladorServicios.tipoMascotaBox();

        listenerActualizarClientes lactcli = new listenerActualizarClientes(actCli);
        listenerClientes lcli = new listenerClientes(c);
        listenerCrearClientes laddcli = new listenerCrearClientes(ccli);
        listenerEmpleados lemp = new listenerEmpleados(emp);
        listenerServicios lser = new listenerServicios(ser);
        ListenerCitas cit = new ListenerCitas(citas);
        //ListenerRegresarCreacionClientes lrc = new ListenerRegresarCreacionClientes(ccli);
        ListenerBucarClienteGeneral lBusGen = new ListenerBucarClienteGeneral(conexion, con, vGeneral);
        Cliente cli = lBusGen.getCliente();
        ListenerAddServicio lAddService = new ListenerAddServicio(controladorServicios.getListServicios(), usu, vGeneral, listaDetalles, tablaDetalles, lBusGen);
        ListenerDeleteDetalle lDeleteDetalle = new ListenerDeleteDetalle(vGeneral, listaDetalles, tablaDetalles);
        ListenerRegresarCreacionClientes lrc = new ListenerRegresarCreacionClientes(ccli);
        ListenerFinalizarSesion lfs = new ListenerFinalizarSesion(vGeneral, vl);
        ListenerFacturar lFacturar = new ListenerFacturar(conexion, vl, vGeneral, con, lAddService, listaDetalles, tablaDetalles);
        ListenerCrearClienteSistema lccs = new ListenerCrearClienteSistema(con, ccli, conexion, lisCli, c);
        ListenerCrearClienteControl lccc = new ListenerCrearClienteControl(c, ccli);
        ListenerBorrarClienteControl lbcc = new ListenerBorrarClienteControl(c, con, ccli, conexion, lisCli);
        ListenerBucarActualizar lbact = new ListenerBucarActualizar(conexion, con, actCli);
        ListenerActualizarActualizar lactact = new ListenerActualizarActualizar(conexion, con, actCli);
        ListenerBuscarClienteCitas lbcCitas = new ListenerBuscarClienteCitas(conexion, con, citas, vGeneral, controladorServicios);
        ListenerAgendarCita lAgendarCita = new ListenerAgendarCita(conexion, con, citas, vGeneral, controladorServicios, lbcCitas, listCitas, vmoCitas);
        ListenerCrearActualizarServicioVista lCrearServicioVista = new ListenerCrearActualizarServicioVista(vCrearServicios);
        ListenerBuscarServicio lBuscarServicio = new ListenerBuscarServicio(conexion, con, vCrearServicios);
        ListenerActualizarServicio lActualzarServicio = new ListenerActualizarServicio(conexion, con, vCrearServicios, lisServ, ser);
        ListenerCrearServicios listenerCrearServicios = new ListenerCrearServicios(con, conexion, vCrearServicios, lisServ, ser, controladorServicios, vGeneral);
        ListenerBuscarActualizarEmpleado lbusActEmp = new ListenerBuscarActualizarEmpleado(conexion, con, actEmpleado);
        ListenerActualizarEmpleado lActEmpleado = new ListenerActualizarEmpleado(conexion, con, lbusActEmp, actEmpleado);
        ListenerMostrarVentaaActualizarEmp lmActEmp = new ListenerMostrarVentaaActualizarEmp(actEmpleado);
        ListenerMostrarCitas lmoMostrarCitas = new ListenerMostrarCitas(vmoCitas);
        ListenerCancelarCita lcaCancelarCita = new ListenerCancelarCita(conexion, con, actEmpleado, lbusActEmp, vmoCitas, listCitas);
        ListenerMostrarFacturas lmoFacturas =  new ListenerMostrarFacturas(vmostrFacturas);
        ListenerActualizarVentanaClientes lactCliven = new ListenerActualizarVentanaClientes(actCli);
        ListenerLimpiarCamposServicio lLimpiar = new ListenerLimpiarCamposServicio(vCrearServicios);
        
        vGeneral.listenerDeleteDetalle(lDeleteDetalle);
        vGeneral.listenerAnadirServicios(lAddService);
        vGeneral.listenerActualizar(lactcli);
        vGeneral.listenerClientes(lcli);
        vGeneral.listenerCrearCli(laddcli);
        vGeneral.listenerEmpleados(lemp);
        vGeneral.listenerServicios(lser);
        vGeneral.listenerAgendar(cit);
        vGeneral.listenerBuscar(lBusGen);
        vGeneral.listenerFinSesion(lfs);
        vGeneral.listenerFacturar(lFacturar);
        vGeneral.listenerCitas(lmoMostrarCitas);
        vGeneral.listenerEstadisticas(lmoFacturas);
        
        emp.listenerActEmpleado(lmActEmp);

        ser.listenerCrearActualizarServicio(lCrearServicioVista);

        vCrearServicios.listenerBuscarServicio(lBuscarServicio);
        vCrearServicios.listenerActualizarServicio(lActualzarServicio);
        vCrearServicios.listenerCrearServicio(listenerCrearServicios);
        vCrearServicios.listenerlimpiarServicio(lLimpiar);

        ccli.addActionListenerCrear(lrc);
        ccli.addActionListenerCrearUsuario(lccs);

        actCli.listenerBuscarCliente(lbact);
        actCli.listenerActualizarCliente(lactact);

        citas.listenerBuscarClienteCita(lbcCitas);
        citas.listenerAgendarCita(lAgendarCita);
        citas.listeneraddClienteCita(lccc);

        c.addActionListenerBotonCrear(lccc);
        c.addActionListenerBotonEliminar(lbcc);
        c.addActionListeneractuaizarCrear(lactCliven);
        
        actEmpleado.listenerBuscarEmpleado(lbusActEmp);
        actEmpleado.listenerActualizarEmpleado(lActEmpleado);
        
        conexionTablas conCli = new conexionTablas(conexion, con);
        
        conCli.obtenerClientes(lisCli);
        conCli.obtenerServicios(lisServ);
        conCli.obtenerEmpleados(listEmpleados);
        conCli.obtenerCitas(listCitas);
        conCli.obtenerFacturas(listFacturas);

        ser.setModelTableServicios(tablaServicios);
        emp.setModelTablaEmpleados(tablaEmpleados);
        vmoCitas.setModelTableServicios(tablaCitas);
        vmoCitas.listenerCancelarCita(lcaCancelarCita);
        vmoCitas.listenerCrearCita(cit);
        
        vmostrFacturas.setModelTableServicios(tablaFacturas);
        
        DefaultTablaClientes tableCli = new DefaultTablaClientes(lisCli);

        c.setModeloTabla(tableCli);
        vGeneral.getFacturar().setEnabled(false);
        vGeneral.repaint();

        vGeneral.setVisible(true);
    }

}
