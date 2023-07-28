ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE ROLE empleados_administrador;

CREATE ROLE empleados_generales;

SELECT* 
FROM dba_roles
ORDER BY role;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA veterinariaa TO empleados_administrador;