ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE ROLE empleados_administrador;

CREATE ROLE empleados_generales;

SELECT* 
FROM dba_roles
ORDER BY role;
-- Privilegios para el administrador
GRANT ALL PRIVILEGES TO empleados_administrador;

-- Privilegios para un empleado general
GRANT CONNECT TO empleados_administrador;
--Se asigna privilegios de conexion al rol
GRANT CONNECT TO empleados_generales;

GRANT INSERT, SELECT ON vt_cabeceras_facturas TO empleados_generales;
GRANT INSERT, SELECT ON vt_detalles_facturas TO empleados_generales;

GRANT INSERT, UPDATE, SELECT ON vt_clientes TO empleados_generales;
GRANT INSERT, UPDATE, SELECT ON vt_personas TO empleados_generales;
GRANT SELECT ON vt_servicios TO empleados_generales;
GRANT SELECT, ALTER ON fac_codigo_seq TO empleados_generales;
GRANT SELECT, ALTER ON det_codigo_seq TO empleados_generales;
GRANT EXECUTE ON proximo_valor_fac_seq TO empleados_generales;
GRANT EXECUTE ON proximo_valor_det_seq TO empleados_generales;

-- Creacion de los usuarios nuevos
CREATE USER daniel_admin IDENTIFIED BY 12345;
CREATE USER paul_admin IDENTIFIED BY 12345;

CREATE USER daniel_general IDENTIFIED BY 12345;
CREATE USER paul_general IDENTIFIED BY 12345;

-- Asignacion hacia el rol
GRANT empleados_administrador TO daniel_admin;
GRANT empleados_administrador TO paul_admin;
GRANT empleados_generales TO daniel_general;
GRANT empleados_generales TO paul_general;
