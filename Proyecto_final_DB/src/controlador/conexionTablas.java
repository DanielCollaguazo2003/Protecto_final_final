/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.ConexionOracle;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cita;
import modelo.Cliente;
import modelo.DefaultListaCitas;
import modelo.DefaultListaClientes;
import modelo.DefaultListaEmplados;
import modelo.DefaultListaFacturas;
import modelo.DefaultListaServicios;
import modelo.DefaultTablaClientes;
import modelo.Empleado;
import modelo.FacturasTablas;
import modelo.Permiso;
import modelo.Servicio;
import modelo.Tipo_Mascota;
import vista.VistaGeneralSistema;
import vista.VistaLogin;

/**
 *
 * @author XaviO_o
 */
public class conexionTablas {

    String sSQL = "";
    ConexionOracle conexion;
    Connection con;
    PreparedStatement ps = null;

    public conexionTablas(ConexionOracle conexion, Connection con) {
        this.conexion = conexion;
        this.con = con;
    }

    public DefaultListaClientes obtenerClientes(DefaultListaClientes lisCli) {
        try {

            sSQL = "SELECT * FROM veterinaria.vt_clientes c, veterinaria.vt_personas p WHERE (c.per_codigo=p.per_codigo) AND (c.cli_estado='A')";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Cliente c = new Cliente(res.getString("cli_estado"),
                        res.getInt("cli_codigo"),
                        res.getString("per_cedula"),
                        res.getString("per_nombre"),
                        res.getString("per_apellido"),
                        res.getString("per_direccion_principal"),
                        res.getString("per_direccion_secundaria"),
                        res.getString("per_telefono"),
                        res.getString("per_correo_electronico"));
                lisCli.addElement(c);
                System.out.println(c.toString());
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

        return lisCli;
    }

    public DefaultListaServicios obtenerServicios(DefaultListaServicios listSer) {
        try {

            sSQL = "SELECT * FROM veterinaria.vt_servicios";
            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Servicio s = new Servicio(res.getInt("ser_codigo"),
                        res.getString("ser_nombre"),
                        res.getString("ser_descripcion"),
                        res.getFloat("ser_precio"),
                        res.getString("ser_iva"));

                listSer.addElement(s);
                System.out.println(s);
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

        return listSer;
    }

    public DefaultListaEmplados obtenerEmpleados(DefaultListaEmplados empl) {
        try {

            sSQL = """
                   SELECT * 
                   FROM veterinaria.vt_empleados e, veterinaria.vt_personas p, veterinaria.vt_permisos pr  
                   WHERE (e.per_codigo=p.per_codigo) and (pr.prm_codigo=e.prm_codigo)
                   """;

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Permiso p = new Permiso(res.getInt("prm_codigo"),
                        res.getString("prm_nombre"),
                        res.getString("prm_descripcion"));
                Empleado e = new Empleado(res.getString("emp_tipo"),
                        res.getInt("emp_codigo"), p,
                        res.getString("per_cedula"),
                        res.getString("per_nombre"),
                        res.getString("per_apellido"),
                        res.getString("per_direccion_principal"),
                        res.getString("per_direccion_secundaria"),
                        res.getString("per_telefono"),
                        res.getString("per_correo_electronico"));
                empl.addElement(e);
                System.out.println(e.toString());
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

        return empl;
    }

    public DefaultListaCitas obtenerCitas(DefaultListaCitas citl) {
        try {

            sSQL = """
                   SELECT c.cit_codigo, c.cit_fecha, c.cit_estado, c.cit_nombre_mascota,
                          emp.per_nombre AS nombre_empleado, cli.per_nombre AS nombre_cliente,
                          emp.per_apellido AS apellido_empleado, cli.per_apellido AS apellido_cliente,
                          t.tip_nombre
                   FROM veterinaria.vt_citas c, veterinaria.vt_empleados e,
                        veterinaria.vt_clientes cl, veterinaria.vt_tipos_mascotas t,
                        veterinaria.vt_personas emp, veterinaria.vt_personas cli
                   WHERE c.emp_codigo = e.emp_codigo
                   AND c.cli_codigo = cl.cli_codigo
                   AND c.tip_codigo = t.tip_codigo
                   AND e.per_codigo = emp.per_codigo
                   AND cl.per_codigo = cli.per_codigo
                   AND cit_estado = 'A'
                   ORDER BY nombre_empleado, apellido_empleado, c.cit_fecha
                   """;

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                Permiso p = new Permiso(0, "", "");
                Empleado e = new Empleado("", 0, p, "",
                        res.getString("nombre_empleado"),
                        res.getString("apellido_empleado"), "", "", "", "");
                Cliente cli = new Cliente("", 0, "",
                        res.getString("nombre_cliente"),
                        res.getString("apellido_cliente"), "", "", "", "");
                Tipo_Mascota t = new Tipo_Mascota(0, res.getString("tip_nombre"));
                LocalDateTime fecha = obtenerFecha(res.getInt("cit_codigo"));
                Cita c = new Cita(res.getInt("cit_codigo"), fecha,
                        res.getString("cit_estado"),
                        cli, res.getString("cit_nombre_mascota"), e, t);
                citl.addElement(c);

            }
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }

        return citl;
    }

    public LocalDateTime obtenerFecha(int codigoCita) {
        LocalDateTime fecha = null;
        try {
            ps = con.prepareStatement("""
                   SELECT TO_CHAR(cit_fecha, 'YYYY-MM-DD HH24:MI:SS') AS fecha_y_hora
                   FROM veterinaria.vt_citas
                   WHERE cit_codigo = ?
                   """);
            ps.setInt(1, codigoCita);
            ResultSet res = ps.executeQuery();

            if (res.next()) {
                String fechaHoraCompleta = res.getString("fecha_y_hora");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                fecha = LocalDateTime.parse(fechaHoraCompleta, formatter);
            }

            res.close();
            ps.close();
        } catch (SQLException x) {
            System.out.println(x);
            System.out.println("no");
        }
        return fecha;
    }

    public DefaultListaFacturas obtenerFacturas(DefaultListaFacturas listFac) {
        try {

            sSQL = """
                  SELECT cab.fac_codigo,
                         MAX(per.per_nombre || ' ' || per.per_apellido) AS cliente,
                         MAX(emp.per_nombre || ' ' || emp.per_apellido) AS empleado,
                         cab.fac_fecha_emision,
                         SUM(det.det_cantidad) AS total_cantidad,
                         MAX(cab.fac_subtotal) AS subtotal,
                         MAX(cab.fac_total) AS total,
                         MAX(cab.fac_valor_iva) AS valor_iva
                  FROM veterinaria.vt_cabeceras_facturas cab, 
                       veterinaria.vt_detalles_facturas det, 
                       veterinaria.vt_clientes cli, 
                       veterinaria.vt_personas per, 
                       veterinaria.vt_usuarios_sistema usu,
                       veterinaria.vt_empleados e,
                       veterinaria.vt_personas emp
                  WHERE cab.fac_codigo = det.fac_codigo
                  AND cli.cli_codigo = cab.cli_codigo
                  AND per.per_codigo = cli.per_codigo
                  AND cab.usu_codigo = usu.usu_codigo
                  AND usu.emp_codigo = e.emp_codigo
                  AND e.per_codigo=emp.per_codigo
                  GROUP BY cab.fac_codigo, cab.fac_fecha_emision
                  ORDER BY 1""";

            Connection con = conexion.conectar();
            Statement cn = con.createStatement();
            ResultSet res = cn.executeQuery(sSQL);

            while (res.next()) {
                FacturasTablas fac = new FacturasTablas(
                        res.getInt("fac_codigo"),
                        res.getString("cliente"),
                        res.getString("empleado"),
                        res.getString("fac_fecha_emision"),
                        res.getInt("total_cantidad"),
                        res.getFloat("subtotal"),
                        res.getFloat("total"),
                        res.getFloat("valor_iva"));

                listFac.addElement(fac);
                System.out.println(fac);
            }
            //tableCli = new DefaultTablaClientes(lisCli);
        } catch (SQLException x) {
            System.out.println("------------------");
            System.out.println(x);
            System.out.println("------------------");
            System.out.println("no");
        }

        return listFac;
    }

}
