ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE ROLE empleados_administrador;

CREATE ROLE empleados_generales;

SELECT* 
FROM dba_roles
ORDER BY role;

GRANT ALL PRIVILEGES TO empleados_administrador;