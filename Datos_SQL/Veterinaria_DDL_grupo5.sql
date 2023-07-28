------****CREACIÓN DEL USUARIO****----------

--ALTER SESSION SET "_ORACLE_SCRIPT"=true;

--CREATE USER veterinaria
--IDENTIFIED BY 12345;

--GRANT DBA TO veterinaria;

--DROP USER veterinaria cascade;

-- Generado por Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   en:        2023-07-09 20:51:34 COT
--   sitio:      Oracle Database 21c
--   tipo:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE vt_cabeceras_facturas (
    fac_codigo                     NUMBER(7) NOT NULL,
    fac_fecha_emision              DATE NOT NULL,
    fac_subtotal                   NUMBER(5) NOT NULL,
    fac_valor_iva                  NUMBER(5, 2) NOT NULL,
    fac_total                      NUMBER(8) NOT NULL,
    usu_codigo                     NUMBER(5) NOT NULL,
    cli_codigo                     NUMBER(7) NOT NULL
);

COMMENT ON COLUMN vt_cabeceras_facturas.fac_codigo IS
    'Codigo unico de la factura';

COMMENT ON COLUMN vt_cabeceras_facturas.fac_fecha_emision IS
    'Fecha y hora a la cual fue generada la factura';

COMMENT ON COLUMN vt_cabeceras_facturas.fac_subtotal IS
    'Valor subtotal de la factura';

COMMENT ON COLUMN vt_cabeceras_facturas.fac_valor_iva IS
    'Valor total del IVA de la factura';

COMMENT ON COLUMN vt_cabeceras_facturas.fac_total IS
    'Valor total de la factura';

ALTER TABLE vt_cabeceras_facturas ADD CONSTRAINT vt_cabeceras_facturas_pk PRIMARY KEY ( fac_codigo );

CREATE TABLE vt_citas (
    cit_codigo              NUMBER(7) NOT NULL,
    cit_fecha               DATE NOT NULL,
    cit_estado              CHAR(1) NOT NULL,
    emp_codigo              NUMBER(5) NOT NULL,
    cli_codigo              NUMBER(7) NOT NULL,
    tip_codigo              NUMBER(7) NOT NULL
);

COMMENT ON COLUMN vt_citas.cit_codigo IS
    'Codigo unico de la cita agendada';

COMMENT ON COLUMN vt_citas.cit_fecha IS
    'Fecha y hora a la cual es agendada la cita';

COMMENT ON COLUMN vt_citas.cit_estado IS
    'Estado de la cita agendada. Colocar (A) si la cita esta activa y colocar (I) si la cita fue cancelada';

ALTER TABLE vt_citas ADD CONSTRAINT vt_citas_pk PRIMARY KEY ( cit_codigo );

CREATE TABLE vt_clientes (
    cli_codigo             NUMBER(7) NOT NULL,
    cli_estado             CHAR(1) NOT NULL,
    per_codigo             NUMBER(7) NOT NULL
);

COMMENT ON COLUMN vt_clientes.cli_codigo IS
    'Codigo unico del cliente de la veterinaria';

COMMENT ON COLUMN vt_clientes.cli_estado IS
    'Estado del cliente donde colocar (A) si el cliente esta activo y colocar (I) si el estado del cliente esta inactivo';

CREATE UNIQUE INDEX vt_clientes__idx ON
    vt_clientes (
        per_codigo
    ASC );

ALTER TABLE vt_clientes ADD CONSTRAINT vt_clientes_pk PRIMARY KEY ( cli_codigo );

CREATE TABLE vt_detalles_facturas (
    det_codigo                       NUMBER(7) NOT NULL,
    det_cantidad                     NUMBER(4) NOT NULL,
    det_precio_unitario              NUMBER(7, 2) NOT NULL,
    det_subtotal                     NUMBER(8, 2) NOT NULL,
    det_valor_iva                    NUMBER(6, 2) NOT NULL,
    det_total                        NUMBER(7) NOT NULL,  
    fac_codigo                       NUMBER(7) NOT NULL,
    ser_codigo                       NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vt_detalles_facturas.det_codigo IS
    'Codigo unico del detalle de la factura';

COMMENT ON COLUMN vt_detalles_facturas.det_cantidad IS
    'Cantidad de servicios del detalle de la factura';

COMMENT ON COLUMN vt_detalles_facturas.det_precio_unitario IS
    'Precio unitario del servicio';

COMMENT ON COLUMN vt_detalles_facturas.det_subtotal IS
    'Valoor subtototal del detalle de la factura (det_cantidad * det_precio)';

COMMENT ON COLUMN vt_detalles_facturas.det_valor_iva IS
    'Valor total del IVA correspondiente al detalle de la factura, siempre y cuando el producto tenga IVA, en caso de no tenerlo, el valor sera cero'
    ;

COMMENT ON COLUMN vt_detalles_facturas.det_total IS
    'Valor total del detalle de la factura (det_subtotal + det_valor_iva)';

ALTER TABLE vt_detalles_facturas ADD CONSTRAINT vt_detalles_facturas_pk PRIMARY KEY ( det_codigo );

CREATE TABLE vt_empleados (
    emp_codigo             NUMBER(5) NOT NULL,
    emp_tipo               CHAR(1) NOT NULL,
    per_codigo             NUMBER(7) NOT NULL,
    rol_codigo             NUMBER(5)
);

COMMENT ON COLUMN vt_empleados.emp_codigo IS
    'Codigo unico del empleado de la veterinaria';

COMMENT ON COLUMN vt_empleados.emp_tipo IS
    'Tipo de empleado donde colocar (V) si el empleado es un veterinario o (C) si el empleado  es de atencion al cliente';

CREATE UNIQUE INDEX vt_empleados__idx ON
    vt_empleados (
        per_codigo
    ASC );

ALTER TABLE vt_empleados ADD CONSTRAINT vt_empleados_pk PRIMARY KEY ( emp_codigo );



CREATE TABLE vt_permisos (
    prm_codigo          NUMBER(5) NOT NULL,
    prm_nombre          VARCHAR2(60) NOT NULL,
    prm_descripcion     VARCHAR2(150) NOT NULL,
    rol_codigo          NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vt_permisos.prm_codigo IS
    'Codigo unico del permiso para  sistema';

COMMENT ON COLUMN vt_permisos.prm_nombre IS
    'Nombre del permiso para el sistema  sistema';

COMMENT ON COLUMN vt_permisos.prm_descripcion IS
    'Breve descripcion del permiso para el sistema';

CREATE TABLE vt_personas (
    per_codigo               NUMBER(7) NOT NULL,
    per_cedula               VARCHAR2(15) NOT NULL,
    per_nombre               VARCHAR2(60) NOT NULL,
    per_apellido             VARCHAR2(60) NOT NULL,
    per_direccion_principal  VARCHAR2(70) NOT NULL,
    per_direccion_secundaria VARCHAR2(80) NOT NULL,
    per_telefono             VARCHAR2(15) NOT NULL,
    per_correo_electronico   VARCHAR2(100) NOT NULL
);

COMMENT ON COLUMN vt_personas.per_codigo IS
    'Codigo unico de las personas';

COMMENT ON COLUMN vt_personas.per_cedula IS
    'Numero de cedula de la persona';

COMMENT ON COLUMN vt_personas.per_nombre IS
    'Nombres completos de las persona, colocar los dos nombres en caso de tenerlo, caso contrario colocar solamente el un nombre';

COMMENT ON COLUMN vt_personas.per_apellido IS
    'Colocar los dos apellidos de la persona en caso de tenerlos, caso contrario colocar solo el un apellido';

COMMENT ON COLUMN vt_personas.per_direccion_principal IS
    'Nombre de la direccion principal o calle principal de la persona';

COMMENT ON COLUMN vt_personas.per_direccion_secundaria IS
    'Direccion o calle secundaria de la persona';

COMMENT ON COLUMN vt_personas.per_telefono IS
    'Numero convencional o celular de la persona';

COMMENT ON COLUMN vt_personas.per_correo_electronico IS
    'Correo electronico de la persona';

ALTER TABLE vt_personas ADD CONSTRAINT vt_personas_pk PRIMARY KEY ( per_codigo );

CREATE TABLE vt_roles (
    rol_codigo      NUMBER(5) NOT NULL,
    rol_nombre      VARCHAR2(70) NOT NULL,
    rol_descripcion VARCHAR2(150)
);

COMMENT ON COLUMN vt_roles.rol_codigo IS
    'Codigo unico del rol del empleado';

COMMENT ON COLUMN vt_roles.rol_nombre IS
    'Nombre del Rol del empleado';

COMMENT ON COLUMN vt_roles.rol_descripcion IS
    'Descripcion pequeña sobre el rol que pertenece al empleado';

ALTER TABLE vt_roles ADD CONSTRAINT vt_roles_pk PRIMARY KEY ( rol_codigo );

CREATE TABLE vt_servicios (
    ser_codigo      NUMBER(5) NOT NULL,
    ser_nombre      VARCHAR2(60) NOT NULL,
    ser_descripcion VARCHAR2(200),
    ser_precio      NUMBER(7, 2) NOT NULL,
    ser_iva         CHAR(1) NOT NULL
);

COMMENT ON COLUMN vt_servicios.ser_codigo IS
    'Codigo del servicio de la veterinaria';

COMMENT ON COLUMN vt_servicios.ser_nombre IS
    'Nombre del servicio del servicio que ofrece la veterinaria';

COMMENT ON COLUMN vt_servicios.ser_descripcion IS
    'En caso de requerirlo, colocar una breve descripcion del servicio';

COMMENT ON COLUMN vt_servicios.ser_precio IS
    'Precio del servicio que ofrece la veterinaria';

COMMENT ON COLUMN vt_servicios.ser_iva IS
    'En caso de que el servicio tenga IVA colocar (S) y en el caso de que el servicio no tenga IVA colocar (N)';

ALTER TABLE vt_servicios ADD CONSTRAINT vt_servicios_pk PRIMARY KEY ( ser_codigo );

CREATE TABLE vt_tipos_mascotas (
    tip_codigo NUMBER(5) NOT NULL,
    tip_nombre VARCHAR2(60) NOT NULL
);

COMMENT ON COLUMN vt_tipos_mascotas.tip_codigo IS
    'Codigo unico del tipo de mascota';

COMMENT ON COLUMN vt_tipos_mascotas.tip_nombre IS
    'Nombre del tipo de mascota';

ALTER TABLE vt_tipos_mascotas ADD CONSTRAINT vt_tipos_mascotas_pk PRIMARY KEY ( tip_codigo );

CREATE TABLE vt_usuarios_sistema (
    usu_codigo              NUMBER(5) NOT NULL,
    usu_nombre_usuario      VARCHAR2(50) NOT NULL,
    usu_contrasenia         VARCHAR2(50) NOT NULL,
    emp_codigo              NUMBER(5) NOT NULL
);

COMMENT ON COLUMN vt_usuarios_sistema.usu_codigo IS
    'Codigo unico del usuario del sistema';

COMMENT ON COLUMN vt_usuarios_sistema.usu_nombre_usuario IS
    'Usuario del empleado usuario del sistema';

COMMENT ON COLUMN vt_usuarios_sistema.usu_contrasenia IS
    'Constrasenia del usuario del sistema';

CREATE UNIQUE INDEX vt_usuarios_sistema__idx ON
    vt_usuarios_sistema (
        emp_codigo
    ASC );

ALTER TABLE vt_usuarios_sistema ADD CONSTRAINT vt_usuarios_sistema_pk PRIMARY KEY ( usu_codigo );


ALTER TABLE vt_cabeceras_facturas
    ADD CONSTRAINT fac_cli_fk FOREIGN KEY ( cli_codigo )
        REFERENCES vt_clientes ( cli_codigo );

ALTER TABLE vt_cabeceras_facturas
    ADD CONSTRAINT fac_usu_fk FOREIGN KEY ( usu_codigo )
        REFERENCES vt_usuarios_sistema ( usu_codigo );

ALTER TABLE vt_citas
    ADD CONSTRAINT cit_cli_fk FOREIGN KEY ( cli_codigo )
        REFERENCES vt_clientes ( cli_codigo );

ALTER TABLE vt_citas
    ADD CONSTRAINT cit_emp_fk FOREIGN KEY ( emp_codigo )
        REFERENCES vt_empleados ( emp_codigo );

ALTER TABLE vt_citas
    ADD CONSTRAINT cit_tip_mas_fk FOREIGN KEY ( tip_codigo )
        REFERENCES vt_tipos_mascotas ( tip_codigo );

ALTER TABLE vt_clientes
    ADD CONSTRAINT cli_per_fk FOREIGN KEY ( per_codigo )
        REFERENCES vt_personas ( per_codigo );

ALTER TABLE vt_detalles_facturas
    ADD CONSTRAINT det_fac_fk FOREIGN KEY ( fac_codigo )
        REFERENCES vt_cabeceras_facturas ( fac_codigo );

ALTER TABLE vt_detalles_facturas
    ADD CONSTRAINT det_ser_fk FOREIGN KEY ( ser_codigo )
        REFERENCES vt_servicios ( ser_codigo );

ALTER TABLE vt_empleados
    ADD CONSTRAINT emp_per_fk FOREIGN KEY ( per_codigo )
        REFERENCES vt_personas ( per_codigo );

ALTER TABLE vt_empleados
    ADD CONSTRAINT emp_rol_fk FOREIGN KEY ( rol_codigo )
        REFERENCES vt_roles ( rol_codigo );

ALTER TABLE vt_permisos
    ADD CONSTRAINT per_rol_fk FOREIGN KEY ( rol_codigo )
        REFERENCES vt_roles ( rol_codigo );

ALTER TABLE vt_usuarios_sistema
    ADD CONSTRAINT usu_emp_fk FOREIGN KEY ( emp_codigo )
        REFERENCES vt_empleados ( emp_codigo );
